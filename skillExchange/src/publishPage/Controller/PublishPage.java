package publishPage.Controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;




@WebServlet("/publishPage.Controller/publishPage")
public class PublishPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		
		try {
			request.setCharacterEncoding("utf-8");
			HttpSession session = request.getSession();
			
//			PublishPageService service = new PublishPageService();
//			List<publishSelectBean> list = service.Skill();
//			for(publishSelectBean pBean :list) {
//				 System.out.println(pBean.getSkillNameCN());
//			}
//			session.setAttribute("skill",list );
//			
//			System.out.println(list);
			
			String publishTitle = request.getParameter("publishTitle");
			String publishPic = request.getParameter("publishPic");
			String publishDetail = request.getParameter("publishDetail");
			String ownSkill = request.getParameter("ownSkill");
			String wantSkill = request.getParameter("wantSkill");
			String publishArea = request.getParameter("publishArea");
			String City = request.getParameter("City");
			String district = request.getParameter("district");
			String road = request.getParameter("road");
			String publishPlace = request.getParameter("publishPlace");
			String publishMark = request.getParameter("publishMark");
			String skillType = request.getParameter("skillType");
			
			
			System.out.println(publishTitle);
			
//			PublishBean publish = new PublishBean();
			
			Map<String, String> errorMsg = new HashMap<String, String>();
			request.setAttribute("error", errorMsg);
			
////			??????????????????
//			if (publishTitle == null || publishTitle.trim().length() == 0) {
//				errorMsg.put("publishTitle", "??????????????????");
//			}
//			if (publishDetail == null || publishDetail.trim().length() == 0) {
//				errorMsg.put("publishDetail", "??????????????????");
//			}
//			if (publishArea == null || publishArea.trim().length() == 0) {
//				errorMsg.put("publishArea", "??????????????????");
//			}
//			if (City == null || City.trim().length() == 0) {
//				errorMsg.put("City", "??????????????????");
//			}
//			if (publishPlace == null || publishPlace.trim().length() == 0) {
//				errorMsg.put("publishPlace", "????????????????????????");
//			}
//			if (ownSkill == null || ownSkill.trim().length() == 0) {
//				errorMsg.put("ownSkill", "??????????????????");
//			}
//			if (wantSkill == null || wantSkill.trim().length() == 0) {
//				errorMsg.put("wantSkill", "??????????????????");
//			}
//			if (!errorMsg.isEmpty()) {
//				response.sendRedirect("/skillExchange//PublishPage.jsp");
////				RequestDispatcher rd = request.getRequestDispatcher("/PublishPage.jsp");
////				rd.forward(request, response);
////				return;
//			}
		    
			session.setAttribute("publishTitle", publishTitle);
//			Object attribute = session.getAttribute("publishTitle");
//			System.out.println(attribute);
			session.setAttribute("publishPic", publishPic);
			session.setAttribute("publishDetail", publishDetail);
			session.setAttribute("ownSkill", ownSkill);
			session.setAttribute("wantSkill", wantSkill);
			session.setAttribute("publishArea", publishArea);
			session.setAttribute("City", City);
			session.setAttribute("district", district);
			session.setAttribute("road", road);
			session.setAttribute("publishPlace", publishPlace);
			session.setAttribute("publishMark", publishMark);
			session.setAttribute("skillType", skillType);
			
			
			
			
	
			response.sendRedirect(request.getContextPath()+"/PublishCheckPage.jsp");
			
//			RequestDispatcher rd =                       
//	                request.getRequestDispatcher("/PublishCheckPage.jsp");
//	         rd.forward(request, response);               	
//	         return ;     
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}	
	}
}
