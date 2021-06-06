package univ.vo;

public class Subject {
	private String sId;
	private String sName;
	private int count;
	private int countNow;
	
	public String getSId()
	{
		return sId;
	}
	public void setSId(String sId)
	{
		this.sId = sId;
	}
	public String getSName()
	{
		return sName;
	}
	public void setSName(String sName)
	{
		this.sName = sName;
	}
	public int getCount()
	{
		return count;
	}
	public void setCount(int count)
	{
		this.count = count;
	}
	public int getCountNow()
	{
		return countNow;
	}
	public void setCountNow(int countNow)
	{
		this.countNow = countNow;
	}
}
