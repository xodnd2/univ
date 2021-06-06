package univ.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import univ.vo.Subject;
import univ.vo.ProSubjectStu;


public class UnivDao {
	private static UnivDao dao = new UnivDao();
	public static UnivDao getInstance() {
		return dao;
	}
	
	public Connection connect()
	{
		Connection conn = null;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/univ","root","1234");
		} catch (Exception e) {
			System.out.print("MDAO : connect"+e);
		}
		return conn;
	}
	public void close(Connection conn, PreparedStatement pstmt)
	{
		if(pstmt != null)
		{
			try {
				pstmt.close();
			} catch(Exception e) {
				System.out.print("Pstmt close error");
			}
		}
		if(conn != null)
		{
			try {
				conn.close();
			} catch(Exception e) {
				System.out.print("Conn close error");
			}
		}
	}
	public void close(Connection conn, PreparedStatement pstmt, ResultSet rs)
	{
		if(rs != null)
		{
			try {
				rs.close();
			} catch(Exception e) {
				System.out.print("Rs close error");
			}
		}
		close(conn, pstmt); 
	}
	
	public String login(String id, String pwd, String pos) {
		// TODO Auto-generated method stub
		String result = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try
		{
			conn = connect();
			if(pos.equals("professor"))
			{
				pstmt = conn.prepareStatement("select * from prof where id = ? and pwd = ?;");
				pstmt.setString(1, id);
				pstmt.setString(2, pwd);
				rs = pstmt.executeQuery();
				if(rs.next() )
				{
					result = "ProLogin";
				}
			} else if (pos.equals("student"))
			{
				pstmt = conn.prepareStatement("select * from student where id = ? and pwd = ?;");
				pstmt.setString(1, id);
				pstmt.setString(2, pwd);
				rs = pstmt.executeQuery();
				if(rs.next() )
				{
					result = "StuLogin";
				}
			} 
		} catch(Exception e) {
			System.out.print("Login error" + e);
		}
		finally
		{
			close(conn,pstmt,rs);
		}
		return result;
	}

	public boolean proEnrollSubject(String id, String sId, String title, int stuNum) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean result = true;
		try
		{
			conn = connect();
			pstmt = conn.prepareStatement("insert into subject values(?,?,?,?);");
			pstmt.setString(1, sId);
			pstmt.setString(2, title);
			pstmt.setString(3, stuNum+"");
			pstmt.setString(4, id);
			pstmt.executeUpdate();
		} catch(Exception e) {
			System.out.print("ProEnrollSubject error" + e);
			result = false;
		}
		finally
		{
			close(conn,pstmt);
		}
		return result;
	}

	public String search(String sId) {
		// TODO Auto-generated method stub
		String result = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try
		{
			conn = connect();
			pstmt = conn.prepareStatement("select name from subject where id = ?;");
			pstmt.setString(1, sId);
			rs = pstmt.executeQuery();
			if(rs.next())
			{
				result = rs.getString(1);
			}
			
		} catch(Exception e) {
			System.out.print("Search error" + e);
		}
		finally
		{
			close(conn,pstmt,rs);
		}
		
		return result;
	}

	public boolean stuEnrollSubject(String id, String title) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean result = true;
		try
		{
			conn = connect();
			pstmt = conn.prepareStatement("select id from subject where name = ?");
			pstmt.setString(1, title);
			rs = pstmt.executeQuery();
			rs.next();
			
			pstmt = conn.prepareStatement("insert into enroll values(?,?);");
			pstmt.setString(1, rs.getString(1));
			pstmt.setString(2, id);
			pstmt.executeUpdate();
		} catch(Exception e) {
			System.out.print("stuEnrollSubject error" + e);
			result = false;
		}
		finally
		{
			close(conn,pstmt, rs);
		}
		return result;
	}

	public ArrayList<Subject> proShowSubject(String id) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ResultSet rs2 = null;
		ArrayList<Subject> proSubjects = new ArrayList<Subject>();
		try
		{
			conn = connect();
			pstmt = conn.prepareStatement("select id, name, count from subject where prof = ?;");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()) 
			{
				pstmt = conn.prepareStatement("select count(*) as countnow from enroll where subject = ?;");
				pstmt.setString(1, rs.getString("id"));
				rs2 = pstmt.executeQuery();
				rs2.next();
				
				Subject proSubject = new Subject();
				proSubject.setSId(rs.getString("id"));
				proSubject.setSName(rs.getString("name"));
				proSubject.setCount(rs.getInt("count"));
				proSubject.setCountNow(rs2.getInt("countnow"));
				proSubjects.add(proSubject);
			}
		} catch(Exception e) {
			System.out.print("proShowSubject error"+e);
		} finally
		{
			close(conn,pstmt,rs);
			if(rs2 != null)
			{
				try {
					rs2.close();
				} catch(Exception e) {
					System.out.print("Rs2 close error");
				}
			}
		}
		return proSubjects;
	}

	public ArrayList<ProSubjectStu> proShowSubject2(String sId) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<ProSubjectStu> proSubjectStus = new ArrayList<ProSubjectStu>();
		try
		{
			conn = connect();
			pstmt = conn.prepareStatement("select a.id, a.name from student a, enroll b "
					+ "where a.id = b.student and b.subject = ?;");
			pstmt.setString(1, sId);
			rs = pstmt.executeQuery();
			while(rs.next()) 
			{			
				ProSubjectStu proSubjectStu = new ProSubjectStu();
				proSubjectStu.setId(rs.getString("id"));
				proSubjectStu.setName(rs.getString("name"));
				proSubjectStus.add(proSubjectStu);
			}
		} catch(Exception e) {
			System.out.print("proShowSubject2 error"+e);
		} finally
		{
			close(conn,pstmt,rs);
		}
		return proSubjectStus;
	}

	public ArrayList<Subject> stuShowSubject(String id) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Subject> stuSubjects = new ArrayList<Subject>();
		try
		{
			conn = connect();
			pstmt = conn.prepareStatement("select b.id, b.name from enroll a, subject b "
					+ "where a.subject = b.id and a.student = ?;");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()) 
			{			
				Subject stuSubject = new Subject();
				stuSubject.setSId(rs.getString("id"));
				stuSubject.setSName(rs.getString("name"));
				stuSubjects.add(stuSubject);
			}
		} catch(Exception e) {
			System.out.print("stuShowSubject error"+e);
		} finally
		{
			close(conn,pstmt,rs);
		}
		return stuSubjects;
	}

	public boolean register(String id, String pwd, String name, String pos) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean result = false;
		try
		{
			conn = connect();
			if(pos.equals("professor"))
			{
				pstmt = conn.prepareStatement("insert into prof values(?,?,?);");
				pstmt.setString(1, id);
				pstmt.setString(2, pwd);
				pstmt.setString(3, name);
				pstmt.executeUpdate();
				result = true;
			} else if (pos.equals("student"))
			{
				pstmt = conn.prepareStatement("insert into student values(?,?,?);");
				pstmt.setString(1, id);
				pstmt.setString(2, pwd);
				pstmt.setString(3, name);
				pstmt.executeUpdate();
				result = true;
			} 
		} catch(Exception e) {
			System.out.print("Register error" + e);
		}
		finally
		{
			close(conn,pstmt,rs);
		}
		return result;
	}

	public void cancelSubject(String sId, String id) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		try
		{
			conn = connect();
			pstmt = conn.prepareStatement("delete from enroll where subject = ? and student = ?;");
			pstmt.setString(1, sId);
			pstmt.setString(2, id);
			pstmt.executeUpdate();
		} catch(Exception e) {
			System.out.print("CancelSubject error" + e);
		}
		finally
		{
			close(conn,pstmt);
		}
	}

	public void removeSubject(String sId) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		try
		{
			conn = connect();
			pstmt = conn.prepareStatement("delete from subject where id =?	;");
			pstmt.setString(1, sId);
			pstmt.executeUpdate();
			
			pstmt = conn.prepareStatement("delete from enroll where subject = ?;");
			pstmt.setString(1, sId);
			pstmt.executeUpdate();
		} catch(Exception e) {
			System.out.print("RemoveSubject error" + e);
		}
		finally
		{
			close(conn,pstmt);
		}
	}
}
