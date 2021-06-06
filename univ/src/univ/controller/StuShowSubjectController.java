package univ.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import univ.service.Service;
import univ.vo.Subject;

public class StuShowSubjectController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		
		Service s = Service.getInstance();
		ArrayList<Subject> stuSubjects = s.stuShowSubject(id);
		request.setAttribute("stuSubjects", stuSubjects);
		HttpUtil.forward(request, response, "/result/stuShowSubjectResult.jsp");
	}
}
