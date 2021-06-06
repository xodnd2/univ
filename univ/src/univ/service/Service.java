package univ.service;

import java.util.ArrayList;

import univ.dao.UnivDao;
import univ.vo.Subject;
import univ.vo.ProSubjectStu;

public class Service {
	private static Service service = new Service() {};
	private Service() {}
	private UnivDao dao = UnivDao.getInstance();
	public static Service getInstance()
	{
		return service;
	}
	public String login(String id, String pwd, String pos) {
		// TODO Auto-generated method stub
		return dao.login(id, pwd, pos);
	}
	public boolean proEnrollSubject(String id, String sId, String title, int stuNum) {
		// TODO Auto-generated method stub
		return dao.proEnrollSubject(id, sId,title,stuNum);
	}
	public String search(String sId) {
		// TODO Auto-generated method stub
		return dao.search(sId);
	}
	public boolean stuEnrollSubject(String id, String title) {
		// TODO Auto-generated method stub
		return dao.stuEnrollSubject(id,title);
	}
	public ArrayList<Subject> proShowSubject(String id) {
		// TODO Auto-generated method stub
		return dao.proShowSubject(id);
	}
	public ArrayList<ProSubjectStu> proShowSubject2(String sId) {
		// TODO Auto-generated method stub
		return dao.proShowSubject2(sId);
	}
	public ArrayList<Subject> stuShowSubject(String id) {
		// TODO Auto-generated method stub
		return dao.stuShowSubject(id);
	}
	public boolean register(String id, String pwd, String name, String pos) {
		// TODO Auto-generated method stub
		return dao.register(id,pwd,name,pos);
	}
	public void cancelSubject(String sId, String id) {
		// TODO Auto-generated method stub
		dao.cancelSubject(sId, id);
	}
	public void removeSubject(String sId) {
		// TODO Auto-generated method stub
		dao.removeSubject(sId);
	}
 }
