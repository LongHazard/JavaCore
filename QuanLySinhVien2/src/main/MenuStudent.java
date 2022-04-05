package main;

import java.util.List;
import java.util.Scanner;

import model.Student;
import service.StudentService;
import service.StudentServiceImpl;

public class MenuStudent {
	
	public static void menuStudent() {
		while (true) {
			System.out.println("-----MENU-----");
			System.out.println("1. Add student");
			System.out.println("2. Update student");
			System.out.println("3. Delete student");
			System.out.println("4. Search student by name");
			System.out.println("5. Search student by code");
			System.out.println("6. Read student");
			System.out.println("7. Exit");
			System.out.println("---VUI LONG CHON!---");
			int sc = new Scanner(System.in).nextInt();
			if(sc == 1) {
				add();
			}else if(sc == 2) {
				update();
			}else if(sc == 3) {
				delete();
			}else if(sc == 4) {
				searchName();
			}else if(sc == 5) {
				get();
			}else if(sc == 6) {
				readAll();
			}else if(sc == 7) {
				break;
			}else 
				System.out.println("Chon sai, vui long chon lai !!!!!");
		}
	}
	
	public static void add() {
		StudentService studentService = new StudentServiceImpl();
		while (true) {
			Student st = new Student();
			studentService.input(st);
			studentService.insert(st);
			System.out.println("Them nua ko (Y/N)");
			String s =  new Scanner(System.in).nextLine();
			if(s.equalsIgnoreCase("N")) {
				break;
			}
		}
	}
	
	public static void readAll() {
		StudentService studentService = new StudentServiceImpl();
		List<Student> list = studentService.getAll();
		for (Student student : list) {
			studentService.info(student);
		}
	} 
	
	public static void update() {
		StudentService studentService = new StudentServiceImpl();
		Student st = new Student();
		studentService.input(st);
		studentService.update(st);
	}
	
	public static void delete() {
		StudentService studentService = new StudentServiceImpl();
		System.out.println("Nhap id can delete: ");
		int c = new Scanner(System.in).nextInt();
		studentService.delete(c);
	}
	
	public static void searchName() {
		StudentService studentService = new StudentServiceImpl();
		System.out.println("Nhap ten can tim: ");
		String name = new Scanner(System.in).nextLine();
		List<Student> list = studentService.search(name);
		if(list.size() > 0) {
			for (Student student : list) {
				studentService.info(student);
			}
		}else
			System.out.println("Khong co student name: " + name);

		
	}
	
	public static void get() {
		StudentService studentService = new StudentServiceImpl();
		System.out.println("Nhap studentCode can tim: ");
		String c = new Scanner(System.in).nextLine();
		Student st = studentService.get(c);
		if(st != null) {
			studentService.info(st);
		}else 
			System.out.println("Khong co!!!!!");
		
	}
	
	
	
	

}
