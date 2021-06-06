package univ.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import univ.service.Service;

public class RemoveSubjectController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String sId = request.getParameter("sId");
		Service s = Service.getInstance();
		s.removeSubject(sId);
		HttpUtil.forward(request, response, "proShowSubject.do");
	}
}
