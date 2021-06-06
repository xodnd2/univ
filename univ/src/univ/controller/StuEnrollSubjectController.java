package univ.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import univ.service.Service;

public class StuEnrollSubjectController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		String title = request.getParameter("title");
		boolean result = false;
		String msg = null;
		
		Service s = Service.getInstance();
		result = s.stuEnrollSubject(id,title);
		if(result == false)
		{
			msg = "Already Enrolled!";
		}
		request.setAttribute("msg", msg);
		HttpUtil.forward(request, response, "/result/stuEnrollSubjectResult.jsp");
	}
}
