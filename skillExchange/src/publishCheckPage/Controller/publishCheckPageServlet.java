package publishCheckPage.Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import publishCheckPage.Model.PublishBean;
import publishCheckPage.Service.PublishService;
import skillexchange.HibernateUtil;


@WebServlet("/publishCheckPage.Controller/publishCheckPageServlet")
public class publishCheckPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SessionFactory factory;
	HttpSession httpSession;
	Session session;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		httpSession = request.getSession();
		
		String publishTitle = httpSession.getAttribute("publishTitle").toString();
		String publishPic = httpSession.getAttribute("publishPic").toString();
		String publishDetail = httpSession.getAttribute("publishDetail").toString();
		String ownSkill = httpSession.getAttribute("ownSkill").toString();
		String wantSkill = httpSession.getAttribute("wantSkill").toString();
		String publishArea = httpSession.getAttribute("publishArea").toString();
		String City = httpSession.getAttribute("City").toString();
		String district = httpSession.getAttribute("district").toString();
		String road = httpSession.getAttribute("road").toString();
		String publishPlace = httpSession.getAttribute("publishPlace").toString();
		String publishMark = httpSession.getAttribute("publishMark").toString();
		String skillType = httpSession.getAttribute("skillType").toString();
		Date date = new Date();
		Timestamp updateTime = new java.sql.Timestamp(date.getTime());
		
		try {
			factory = HibernateUtil.getSessionFactory();
			session = factory.getCurrentSession();
			PublishService service = new PublishService(session);
			
			PublishBean pBean = new PublishBean(publishTitle,publishDetail,publishArea,City
					,district,road,publishPlace,publishPic,ownSkill,wantSkill,updateTime,publishMark,skillType);
			service.insertPublish(pBean);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		response.sendRedirect(request.getContextPath()+"/PublishFinishPage.jsp");
	}
}

