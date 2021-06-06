package univ.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import univ.service.Service;

public class ProEnrollSubjectController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		String sId = request.getParameter("sId");
		String title = request.getParameter("title");
		int stuNum = Integer.parseInt(request.getParameter("stuNum"));
		String msg = null;
		Service s = Service.getInstance();
		boolean result = s.proEnrollSubject(id,sId,title,stuNum);
		
		if(result == false)
		{
			msg = "Already Enrolled!";
		}
		request.setAttribute("msg", msg);
		HttpUtil.forward(request, response, "/result/proEnrollSubjectResult.jsp");
	}
}
