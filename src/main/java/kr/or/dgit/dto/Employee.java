package kr.or.dgit.dto;

public class Employee {
	private String eno;
	private String ename;
	private int salary;
	private Department dno;
	private boolean gender;
	private String joindate;
	private Title title;

	public Employee() {
	}

	public Employee(String eno, String ename, int salary, Department dno, boolean gender, String joindate,
			Title title) {
		super();
		this.eno = eno;
		this.ename = ename;
		this.salary = salary;
		this.dno = dno;
		this.gender = gender;
		this.joindate = joindate;
		this.title = title;
	}

	public String getEno() {
		return eno;
	}

	public void setEno(String eno) {
		this.eno = eno;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public Department getDno() {
		return dno;
	}

	public void setDno(Department dno) {
		this.dno = dno;
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public String getJoindate() {
		return joindate;
	}

	public void setJoindate(String joindate) {
		this.joindate = joindate;
	}

	public Title getTitle() {
		return title;
	}

	public void setTitle(Title title) {
		this.title = title;
	}

}
