package univ.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import univ.service.Service;

public class CancelSubjectController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String sId = request.getParameter("sId");
		Service s = Service.getInstance();
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		s.cancelSubject(sId,id);
		HttpUtil.forward(request, response, "stuShowSubject.do");
	}
}
