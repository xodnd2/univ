package univ.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FrontController extends HttpServlet{
	HashMap<String, Controller> map = null;
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		map = new HashMap<String, Controller>();
		map.put("/login.do",new LoginController());
		map.put("/proEnrollSubject.do",new ProEnrollSubjectController());
		map.put("/stuEnrollSubject.do",new StuEnrollSubjectController());
		map.put("/search.do",new SearchController());
		map.put("/proShowSubject.do",new ProShowSubjectController());
		map.put("/proShowSubject2.do",new ProShowSubject2Controller());
		map.put("/stuShowSubject.do",new StuShowSubjectController());
		map.put("/register.do",new RegisterController());
		map.put("/cancelSubject.do",new CancelSubjectController());
		map.put("/removeSubject.do",new RemoveSubjectController());
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uri = req.getRequestURI();
		String contextPath = req.getContextPath();
		String path = uri.substring(contextPath.length());
		
		Controller cont = map.get(path);
		cont.execute(req, resp);
	}
}
