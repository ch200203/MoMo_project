package momo.vo;

public class MyClassListVo {
	
	private String tutorNo;
	private String classNo;
	private String className;
	
	public MyClassListVo() {}

	public MyClassListVo(String tutorNo, String classNo, String className) {
		super();
		this.tutorNo = tutorNo;
		this.classNo = classNo;
		this.className = className;
	}

	public String getTutorNo() {
		return tutorNo;
	}

	public void setTutorNo(String tutorNo) {
		this.tutorNo = tutorNo;
	}

	public String getClassNo() {
		return classNo;
	}

	public void setClassNo(String classNo) {
		this.classNo = classNo;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	@Override
	public String toString() {
		return "MyClassListVo [tutorNo=" + tutorNo + ", classNo=" + classNo + ", className=" + className + "]";
	}
	
}
