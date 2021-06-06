package univ.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import univ.service.Service;
import univ.vo.Subject;

public class ProShowSubjectController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		
		Service s = Service.getInstance();
		ArrayList<Subject> proSubjects = s.proShowSubject(id);
		request.setAttribute("proSubjects", proSubjects);
		HttpUtil.forward(request, response, "/result/proShowSubjectResult.jsp");
	}
}
