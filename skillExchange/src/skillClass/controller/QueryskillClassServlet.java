package skillClass.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import skillClass.model.Publish;
import skillexchange.HibernateUtil;


@WebServlet("/queryskillClass.do")
public class QueryskillClassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SessionFactory factory;
	private Session session;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			response.setContentType("text/html;charset=UTF-8");
		
		try {
			factory = HibernateUtil.getSessionFactory();	
			session=factory.openSession();
			String skillType = request.getParameter("name");
			skillupdate(skillType);
			List<Publish> skills = skillQuery(skillType);			
			request.setAttribute("allSkills", skills);
		} catch(Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
		finally {
			RequestDispatcher rd = request.getRequestDispatcher("/skillClass/skill.jsp");
			rd.forward(request, response);	
			session.close();
		}								
	}	
	private List<Publish> skillQuery(String skillType) {
		String hql = "from Publish P join fetch P.member WHERE P.skillType = :skillType";
		Query<Publish> query = session.createQuery(hql).setParameter("skillType",skillType);
		return (List<Publish>) query.list();
	}
	private boolean skillupdate(String skillType) {
		Transaction txn = session.beginTransaction();
		String hql=" update Skill2 s set s.typeCTR=typeCTR+1 where s.typeCN=:skillType";
		Query query = session.createQuery(hql).setParameter("skillType",skillType );
		query.executeUpdate();	
		txn.commit();
		return true;
	}
}
