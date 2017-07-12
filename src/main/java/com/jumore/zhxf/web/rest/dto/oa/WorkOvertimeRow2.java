package com.jumore.zhxf.web.rest.dto.oa;

public class WorkOvertimeRow2 {

	private String name;
	private int age;
	private String birthDate;
	private String payment;
	private String bonus;

	public WorkOvertimeRow2() {
		super();
	}

	public WorkOvertimeRow2(String name, int age, String birthDate, String payment, String bonus) {
		super();
		this.name = name;
		this.age = age;
		this.birthDate = birthDate;
		this.payment = payment;
		this.bonus = bonus;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public String getBonus() {
		return bonus;
	}

	public void setBonus(String bonus) {
		this.bonus = bonus;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "WorkOvertimeRow [name=" + name + ", age=" + age + ", birthDate=" + birthDate + ", payment=" + payment
				+ ", bonus=" + bonus + "]";
	}

}
