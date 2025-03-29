package model;

public class Account {

	private int acno;
	private String acname;
	private String panNumber;
	private long adharNumber;
	private double balance;
	private long mobileNumber;

	public int getAcno() {
		return acno;
	}

	public void setAcno(int acno) {
		this.acno = acno;
	}

	public String getAcname() {
		return acname;
	}

	public void setAcname(String acname) {
		this.acname = acname;
	}

	public String getPanNumber() {
		return panNumber;
	}

	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}

	public long getAdharNumber() {
		return adharNumber;
	}

	public void setAdharNumber(long adharNumber) {
		this.adharNumber = adharNumber;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	@Override
	public String toString() {
		return "\n---------------------\n"+"Account Details :: \n---------------------\nAc No : " + acno + "\nAc Name : " + acname + 
				"\nPan No : " + panNumber + "\nAdhar No : "+ adharNumber + 
				"\n Balance  :  " + balance + "\nMobile No : " + mobileNumber+"\n---------------------";
	}

	
}
