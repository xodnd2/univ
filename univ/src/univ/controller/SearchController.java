package univ.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import univ.service.Service;

public class SearchController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String sId = request.getParameter("sId");
		Service s = Service.getInstance();
		String title = null;
		String msg = null;
		title = s.search(sId);
		if(title != null)
		{
			request.setAttribute("title", title);
			msg = "Success";
		} else
		{
			msg = "Fail";
		}
		request.setAttribute("msg", msg);
		HttpUtil.forward(request, response, "/stuEnrollSubject.jsp");
	}

}
