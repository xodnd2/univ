package univ.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import univ.service.Service;

public class RegisterController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		String pos = request.getParameter("pos");
		Service s = Service.getInstance();
		boolean result = s.register(id,pwd,name,pos);
		String msg = null;
		if(result)
		{
			msg = "RS";
		} else
		{
			msg = "RF";
		}
		request.setAttribute("msg", msg);
		HttpUtil.forward(request, response, "/login.jsp");
	}
}
