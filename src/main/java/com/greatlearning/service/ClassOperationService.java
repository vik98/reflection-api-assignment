package com.greatlearning.service;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.stream.*;
import java.util.*;

public class ClassOperationService {

	List<String> classData = null;

	public void setClassMethod(String className) {
		try {
			classData = new ArrayList<String>();
			Class c = Class.forName(className);

			Method[] methods = c.getDeclaredMethods();

			for (int i = 0; i < methods.length; i++) {
				classData.add(methods[i].toString());
				System.out.println("Added the method: " + methods[i].toString());
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void setClassClasses(String className) {
		try {
			classData = new ArrayList<String>();
			Class c = Class.forName(className);

			Class[] classes = c.getDeclaredClasses();

			for (int i = 0; i < classes.length; i++) {
				classData.add(classes[i].toString());
				System.out.println("Added the class: " + classes[i].toString());
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void setClassSubClass(String className) {
		try {
			classData = new ArrayList<String>();
			Class c = Class.forName(className);

			Class[] classes = c.getDeclaredClasses();

			for (int i = 0; i < classes.length; i++) {
				classData.add(classes[i].toString());
				System.out.println("Added the subclass: " + classes[i].toString());
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}
	
	public void setClassParentClass(String className) {
		try {
			classData = new ArrayList<String>();
			Class c = Class.forName(className);

			Class superClass = c.getSuperclass();

			classData.add(superClass.toString());
			System.out.println("Added the parent class: " + superClass);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void setClassConstructor(String className) {
		try {
			classData = new ArrayList<String>();
			Class c = Class.forName(className);

			Constructor[] constructors = c.getDeclaredConstructors();

			for (int i = 0; i < constructors.length; i++) {
				classData.add(constructors[i].toString());
				System.out.println("Added the constructor: " + constructors[i].toString());
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	public void setClassDataMember(String className) {
		try {

			classData = new ArrayList<String>();
			Class c = Class.forName(className);

			Field[] dataMembers = c.getDeclaredFields();

			for (int i = 0; i < dataMembers.length; i++) {
				classData.add(dataMembers[i].toString());
				System.out.println("Added the data member: " + dataMembers[i].toString());
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void writeToFile(String className) {
		try {

			SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
			String fileDate = formatter.format(new Date());

			Class c = Class.forName(className);

			String fileName = c.getName() + "_" + fileDate + ".txt";

			Path path = Paths.get("data", fileName);

			Files.write(path, classData);

		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
			
		}catch(IOException e) {
			
			e.printStackTrace();
			
		}

	}
	
	public void listData() {
		try {

			List<Path> files = Files.list(Paths.get("data")).filter(Files::isRegularFile)
					.map(Path::getFileName).collect(Collectors.toList());
			System.out.println(" Listing all previous file created");
			files.forEach(System.out::println);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}
	
}
