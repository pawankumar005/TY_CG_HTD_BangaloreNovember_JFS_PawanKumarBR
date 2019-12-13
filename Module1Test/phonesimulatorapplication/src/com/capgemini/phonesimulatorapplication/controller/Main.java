package com.capgemini.phonesimulatorapplication.controller;

import java.util.List;
import java.util.Scanner;

import com.capgemini.phonesimulatorapplication.bean.UserBean;
import com.capgemini.phonesimulatorapplication.dao.DAO;
import com.capgemini.phonesimulatorapplication.factory.Factory;

public class Main {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("****Phone Simulator Application****");
		System.out.println("---------------------------------------");

		System.out.println("Enter 1 to Show all contacts");
		System.out.println("Enter 2 to Search for contact using name");
		System.out.println("Enter 3 to Operate on Contact");
		int choice= sc.nextInt();
		DAO d= Factory.insataceOfDaoImpl();

		switch(choice) {
		case 1:

			List<UserBean> list = d.getAllContacts();

			if(list!=null)
				for(UserBean user: list) {
					System.out.println(user);
				}else
					System.out.println("no contact present");
			Main.main(null);
			break;

		case 2:
			Search.search();
			break;


		case 3:
			System.out.println("Enter 1 to save contact");
			System.out.println("Enter 2 to delete contact");
			System.out.println("Enter 3 to Edit contact");
			System.out.println("Enter 4 to go back");
			int ch= sc.nextInt();
			switch(ch) {
			case 1:
				UserBean user= new UserBean();
				System.out.println("Enter Name");
				user.setName(sc.next());
				System.out.println("Enter Mobile number");
				user.setNumber(sc.nextLong());
				System.out.println("Enter Group");
				user.setGroup(sc.next());
				if(d.addContact(user)) {
					System.out.println("contact saved");
				}
				else {
					System.err.println("something went wrong");
				}
				break;
			case 2:
				System.out.println("enter the contact name to delete");
				String s= sc.next();
				if(d.deleteContact(s))
					System.out.println("contact deleted");
				else
					System.out.println("something went wrong");
				break;

			case 3:
				System.out.println("enter 1 to edit mobile number");
				System.out.println("enter 2 to edit group");
				System.out.println("enter 3 to go back");
				int e= sc.nextInt();
				switch(e) {
				case 1: 
					System.out.println("enter contact name");
					String t= sc.next();
					System.out.println("enter new mobile number ");
					long  u= sc.nextLong();
					if(d.editPhoneNum(u, t))
						System.out.println("updated successfully");
					else
						System.out.println("comething went wrong");
					break;
				case 2:
					System.out.println("enter contact name");
					String h= sc.next();
					System.out.println("enter new group name ");
					String j= sc.next();
					if(d.editGroup(j, h))
						System.out.println("updated successfully");
					else
						System.out.println("comething went wrong");
					break;
				case 3:
					Main.main(null);
					break;
				default: System.out.println("enter valid choice");

				}
			case 4: Main.main(null);
			break;

			default: System.out.println("enter valid choice");


			}

		default: System.out.println("enter valid choice");


		}
	}

}


