package main;

import java.util.List;
import java.util.Scanner;

import model.Teacher;
import service.TeacherService;
import service.TeacherServiceImpl;

public class MenuTeacher {
	
	public static void menuTeacher() {
		while (true) {
			System.out.println("-----MENU-----");
			System.out.println("1. Add teacher");
			System.out.println("2. Update teacher");
			System.out.println("3. Delete teacher");
			System.out.println("4. Search teacher by name");
			System.out.println("5. Search teacher by department");
			System.out.println("6. Read teacher");
			System.out.println("7. Exit");
			System.out.println("---VUI LONG CHON!---");
			try {
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
				}
			
			} catch (Exception e) {
				System.out.println("Chon sai, vui long chon lai !!!!!");

			}
			
		}
	}

	public static void add() {
		TeacherService teacherService = new TeacherServiceImpl();
		while (true) {
			Teacher st = new Teacher();
			teacherService.input(st);
			teacherService.insert(st);
			System.out.println("Them nua ko (Y/N)");
			String s = new Scanner(System.in).nextLine();
			if (s.equalsIgnoreCase("N")) {
				break;
			}
		}
	}

	public static void readAll() {
		TeacherService teacherService = new TeacherServiceImpl();
		List<Teacher> list = teacherService.getAll();
		for (Teacher teacher : list) {
			teacherService.info(teacher);
		}
		
	}

	public static void update() {
		TeacherService teacherService = new TeacherServiceImpl();
		Teacher st = new Teacher();
		teacherService.input(st);
		teacherService.update(st);
	}

	public static void delete() {
		TeacherService teacherService = new TeacherServiceImpl();
		System.out.println("Nhap id can delete: ");
		int c = new Scanner(System.in).nextInt();
		teacherService.delete(c);
	}

	public static void searchName() {
		TeacherService teacherService = new TeacherServiceImpl();
		System.out.println("Nhap ten can tim: ");
		String name = new Scanner(System.in).nextLine();
		List<Teacher> list = teacherService.search(name);
		if (list.size() > 0) {
			for (Teacher teacher : list) {
				teacherService.info(teacher);
			}
		} else
			System.out.println("Khong co student name: " + name);

	}

	public static void get() {
		TeacherService teacherService = new TeacherServiceImpl();
		System.out.println("Nhap department can tim: ");
		String c = new Scanner(System.in).nextLine();
		List<Teacher> list = teacherService.get(c);
		if (list.size() > 0) {
			for (Teacher teacher : list) {
				teacherService.info(teacher);
			}
		} else
			System.out.println("Khong co department name: " + c);

	}

}
