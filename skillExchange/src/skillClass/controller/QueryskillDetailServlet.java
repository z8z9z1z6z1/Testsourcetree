package skillClass.controller;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import skillClass.model.Publish;
import skillexchange.HibernateUtil;


@WebServlet("/queryskillDetail.do")
public class QueryskillDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SessionFactory factory;
	private Session session;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			response.setContentType("text/html;charset=UTF-8");
		
		try {
			factory = HibernateUtil.getSessionFactory();
			session=factory.openSession();
			String publishNo = request.getParameter("name");
			int PublishNo = Integer.parseInt(publishNo);
			skillupdate(PublishNo);
			List<Publish> skills = skillQuery(PublishNo);			
			request.setAttribute("allSkills", skills);
		} catch(Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}			
		finally {
				RequestDispatcher rd = request.getRequestDispatcher("/skillClass/skillDetail.jsp");
				rd.forward(request, response);	
				session.close();
			}				
	}
	private List<Publish> skillQuery(int PublishNo) {
		String hql = "from Publish P join fetch P.member WHERE P.publishNo = :publishNo";
		@SuppressWarnings("unchecked")
		Query<Publish> query = session.createQuery(hql);
		query.setParameter("publishNo",PublishNo);
		return (List<Publish>) query.list();
	}
	private boolean skillupdate(int publishNo) {
		Transaction txn = session.beginTransaction();
		String hql=" update Publish P set P.publishCTR=publishCTR+1 where P.publishNo=:publishNo";
		Query query = session.createQuery(hql).setParameter("publishNo",publishNo );
		query.executeUpdate();	
		txn.commit();
		return true;
	}
}
