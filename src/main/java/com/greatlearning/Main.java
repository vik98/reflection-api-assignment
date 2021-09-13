package com.greatlearning;

import java.util.*;

import com.greatlearning.service.ClassOperationService;

public class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		ClassOperationService classOperationService = new ClassOperationService();
		System.out.println("Enter the name of the CLASS");

		String className = sc.next();
		boolean exit = false;
		if (checkClassName(className)) {
			do {
				displayMenu();
				int option = sc.nextInt();

				switch (option) {
					case 1:
						classOperationService.setClassMethod(className);
						break;
					case 2:
						classOperationService.setClassClasses(className);
						break;
					case 3:
						classOperationService.setClassSubClass(className);
						break;
					case 4:
						classOperationService.setClassParentClass(className);
						break;
					case 5:
						classOperationService.setClassConstructor(className);
						break;
					case 6: 
						classOperationService.setClassDataMember(className);
						break;
					default:
						System.out.println("Select correcct option");
						break;
				}
				
				displayNextOption();
				
				String nextOption = sc.next();
				
				if(nextOption.equals("yes")) {
					dispayNextMenu();
					exit = true;
					int nextInput = sc.nextInt();
					switch (nextInput) {
					case 1:
						classOperationService.writeToFile(className);
						break;
					case 2:
						classOperationService.listData();
						break;
					case 3:
						// Exit Current Menu
						break;
					default:
						System.err.println("Incorrect Option. Try Again.");
						break;
					}

				}
				
				if(exit) {
					break;
				}

			} while (true);

		} else {
			System.out.println("Incorrect Class Name. Restart the Application");
		}

	}

	public static boolean checkClassName(String className) {
		try {
			Class.forName(className);
		} catch (ClassNotFoundException classNotFound) {
			System.out.println("Class not found");
			return false;
		}
		return true;
	}

	public static void displayMenu() {
		
		System.out.println("-------------------------------");
		System.out.println("Press the option");
		System.out.println("1 Method");
		System.out.println("2 Class");
		System.out.println("3 Subclasses");
		System.out.println("4 Parent Class");
		System.out.println("5 Constructors");
		System.out.println("6 Data Members");
		System.out.println("-------------------------------");

	}
	
	public static void displayNextOption() {
		System.out.println("Press yes to see more menu and no to continue");
	}
	
	public static void dispayNextMenu() {
		
		System.out.println("1. Store information into file");
		System.out.println("2. To see all previous file created");
		System.out.println("3. Exit without storing");

	}

}
