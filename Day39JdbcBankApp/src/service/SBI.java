package service;

import java.sql.*;
import java.util.Scanner;

import dbutil.DBConnection;
import model.Account;



public class SBI implements RBI {

	Scanner sc = new Scanner(System.in);
	Connection con = DBConnection.getConnection();
	Account ac = new Account();

	@Override
	public void createAccount() {
		System.out.println("Enter Account Number");
		ac.setAcno(sc.nextInt());

		System.out.println("Enter Account Name");
		String name = sc.next();
		name = name + sc.nextLine();

		ac.setAcname(name);

		System.out.println("Enter Account Pan");
		ac.setPanNumber(sc.next());

		System.out.println("Enter Account Adhar");
		ac.setAdharNumber(sc.nextLong());

		System.out.println("Enter Account Balance");
		ac.setBalance(sc.nextDouble());

		System.out.println("Enter Account Mobile");
		ac.setMobileNumber(sc.nextLong());

		String insert = "insert into Account values (?,?,?,?,?,?)";

		try {
			PreparedStatement ps = con.prepareStatement(insert);
			ps.setInt(1, ac.getAcno());
			ps.setString(2, ac.getAcname());
			ps.setString(3, ac.getPanNumber());
			ps.setLong(4, ac.getAdharNumber());
			ps.setDouble(5, ac.getBalance());
			ps.setLong(6, ac.getMobileNumber());

			ps.execute();

		} catch (SQLException e) {
			System.out.println("Account Createion Failed ........ " + e.getMessage());
		}

		System.out.println("Accout created .....");
	}

	@Override
	public void viewAccount() {

		System.out.println("Enter Account number");
		int acno = sc.nextInt();
		String select = "select * from account where Account_no  = ?";

		try {
			PreparedStatement ps = con.prepareStatement(select);
			ps.setInt(1, acno);

			ResultSet rs = ps.executeQuery();
			rs.next();

			ac.setAcno(rs.getInt(1));
			ac.setAcname(rs.getString(2));
			ac.setPanNumber(rs.getString(3));
			ac.setAdharNumber(rs.getLong(4));
			ac.setMobileNumber(rs.getLong(6));
			ac.setBalance(rs.getDouble(5));
			
			System.out.println(ac);

		} catch (SQLException e) {
			System.out.println("Issue With Your Account Details .......... " + e.getMessage());
		}

	}

	@Override
	public void withdrawMoney() {
		System.out.println("Enter Account number");
	    int acno = sc.nextInt();

	    System.out.println("Enter Amount to Withdraw");
	    double amount = sc.nextDouble();

	    String select = "select Account_balance from account where Account_no  = ?";
	    String update = "update account set Account_balance = ? where Account_no  = ?";
	    try {
	        PreparedStatement ps = con.prepareStatement(select);
	        ps.setInt(1, acno);

	        ResultSet rs = ps.executeQuery();
	        if (rs.next()) {
	            double currentBalance = rs.getDouble(1);
	            if (currentBalance >= amount) {
	                PreparedStatement psUpdate = con.prepareStatement(update);
	                psUpdate.setDouble(1, currentBalance - amount);
	                psUpdate.setInt(2, acno);

	                psUpdate.executeUpdate();
	                System.out.println("Withdrawal successful. Updated Balance: " + (currentBalance - amount));
	            } else {
	                System.out.println("Insufficient Balance.");
	            }
	        } else {
	            System.out.println("Account not found.");
	        }
	    } catch (SQLException e) {
	        System.out.println("Withdrawal Failed ........ " + e.getMessage());
	    }
	}

	@Override
	public void depositMoney() {
		 System.out.println("Enter Account number");
		    int acno = sc.nextInt();

		    System.out.println("Enter Amount to Deposit");
		    double amount = sc.nextDouble();

		    String select = "select Account_balance from account where Account_no = ?";
		    String update = "update account set Account_balance = ? where Account_no = ?";
		    try {
		        PreparedStatement ps = con.prepareStatement(select);
		        ps.setInt(1, acno);

		        ResultSet rs = ps.executeQuery();
		        if (rs.next()) {
		            double currentBalance = rs.getDouble(1);

		            PreparedStatement psUpdate = con.prepareStatement(update);
		            psUpdate.setDouble(1, currentBalance + amount);
		            psUpdate.setInt(2, acno);

		            psUpdate.executeUpdate();
		            System.out.println("Deposit successful. Updated Balance: " + (currentBalance + amount));
		        } else {
		            System.out.println("Account not found.");
		        }
		    } catch (SQLException e) {
		        System.out.println("Deposit Failed ........ " + e.getMessage());
		    }
	}

	@Override
	public void deleteAccount() {
		System.out.println("Enter Account number to Delete");
	    int acno = sc.nextInt();

	    String delete = "delete from account where Account_no = ?";
	    try {
	        PreparedStatement ps = con.prepareStatement(delete);
	        ps.setInt(1, acno);

	        int rows = ps.executeUpdate();
	        if (rows > 0) {
	            System.out.println("Account deleted successfully.");
	        } else {
	            System.out.println("Account not found.");
	        }
	    } catch (SQLException e) {
	        System.out.println("Deletion Failed ........ " + e.getMessage());
	    }
	}

	@Override
	public void updateAccount() {
		 System.out.println("Enter Account number to Update");
		    int acno = sc.nextInt();

		    System.out.println("Enter New Name");
		    String name = sc.next();
		    name = name + sc.nextLine();

		    System.out.println("Enter New Pan Number");
		    String pan = sc.next();

		    System.out.println("Enter New Aadhaar Number");
		    long adhar = sc.nextLong();

		    System.out.println("Enter New Mobile Number");
		    long mobile = sc.nextLong();

		    String update = "update account set Account_Name = ?, Pan_no = ?, Adhaar_no = ?, Mobile_no = ? where Account_no = ?";
		    try {
		        PreparedStatement ps = con.prepareStatement(update);
		        ps.setString(1, name);
		        ps.setString(2, pan);
		        ps.setLong(3, adhar);
		        ps.setLong(4, mobile);
		        ps.setInt(5, acno);

		        int rows = ps.executeUpdate();
		        if (rows > 0) {
		            System.out.println("Account updated successfully.");
		        } else {
		            System.out.println("Account not found.");
		        }
		    } catch (SQLException e) {
		        System.out.println("Update Failed ........ " + e.getMessage());
		    }
	}

}
