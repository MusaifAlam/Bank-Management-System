package controller;

import java.util.Scanner;


import service.RBI;
import service.SBI;

public class AdminController {

	public static void main(String[] args) {

		boolean flag = true;
		Scanner sc = new Scanner(System.in);
		RBI rbi = new SBI();

		while (flag) {
 
			  System.out.println("1: Create Account ");
			  System.out.println("2: View Account ");
			  System.out.println("3: Withdraw Money ");
			  System.out.println("4: Deposit Money ");
			  System.out.println("5: Delete Account ");
			  System.out.println("6: Update Account ");
			  System.out.println("7: Exit ");
			  
			  int key = sc.nextInt();
			  switch (key) {
			case 1:
				rbi.createAccount();
				break;
			case 2:
				rbi.viewAccount();
				break;
			case 3:
				rbi.withdrawMoney();
				break;
			case 4:
				rbi.depositMoney();
				break;
			case 5:
				rbi.deleteAccount();
				break;
			case 6:
				rbi.updateAccount();
				break;
			case 7:
				flag = false;
				break;

			default:
				System.out.println("Enter Correct Option........");
				break;
			}
			  
		}
		 System.out.println("---------Thank You For Banking With Us----------------");
		 sc.close();
	}
}
