package univ.controller;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import univ.service.Service;

public class LoginController implements Controller{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String pos = request.getParameter("pos");
		String result = null;
		String msg = null;
		Service s = Service.getInstance();
		result = s.login(id,pwd,pos);
		String path = null;
		if(result != null) {
		if(result.equals("ProLogin"))
		{
			HttpSession session = request.getSession();
			session.setAttribute("id", id);
			path = "/proMenu.jsp";
		} else if (result.equals("StuLogin"))
		{
			HttpSession session = request.getSession();
			session.setAttribute("id", id);
			path = "/stuMenu.jsp";
		} 
		} else
		{
			path ="/login.jsp";
			msg = "LF";	
		}
		request.setAttribute("msg", msg);
		HttpUtil.forward(request, response, path);
	}
}
