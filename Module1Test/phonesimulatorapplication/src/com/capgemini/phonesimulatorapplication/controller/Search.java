package com.capgemini.phonesimulatorapplication.controller;

import java.util.Scanner;

import com.capgemini.phonesimulatorapplication.bean.UserBean;
import com.capgemini.phonesimulatorapplication.dao.DAO;
import com.capgemini.phonesimulatorapplication.factory.Factory;

public class Search {
	public static void search() {
		Scanner sc= new Scanner(System.in);
		DAO d= Factory.insataceOfDaoImpl();
		System.out.println("enter the contact name to search");
		UserBean u= d.searchContact(sc.next());
		if(u==null) {
			System.out.println("contact not present");
			Main.main(null);
		}
		else {
			System.out.println(u);
			System.out.println("Enter 1 to call");
			System.out.println("Enter 2 to Message");
			System.out.println("Enter 3 to go back to main menu");
			int choice1= sc.nextInt();
			switch(choice1) {
			case 1:
				System.out.println("calling......");
				System.out.println("connected....");
				System.out.println("enter any number to end the call");
				int n= sc.nextInt();
				System.out.println("call ended");
				Main.main(null);
				break;
			case 2:
				System.out.println("enter text");
				String s= sc.next();
				System.out.println("message sent");
				Main.main(null);
			case 3: Main.main(null);
			default: System.out.println("enter valid choice");
			}


		}
	}

}
