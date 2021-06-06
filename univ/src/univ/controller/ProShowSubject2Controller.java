package univ.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import univ.service.Service;
import univ.vo.ProSubjectStu;

public class ProShowSubject2Controller implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String sId = request.getParameter("sId");
		String sName = request.getParameter("sName");
		String cN = request.getParameter("cN");
		Service s = Service.getInstance();
		ArrayList<ProSubjectStu> proSubjectStus = s.proShowSubject2(sId);
		request.setAttribute("proSubjectStus", proSubjectStus);
		request.setAttribute("sName", sName);
		request.setAttribute("cN", cN);
		HttpUtil.forward(request, response, "/result/proShowSubjectResult2.jsp");
	}
}
