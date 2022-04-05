package main;

import java.util.List;
import java.util.Scanner;

import model.Clazz;
import service.ClazzService;
import service.ClazzServiceImpl;

public class MenuClass {

	public static void menuClass() {
		while (true) {
			System.out.println("-----MENU-----");
			System.out.println("1. Add class");
			System.out.println("2. Update class");
			System.out.println("3. Delete class");
			System.out.println("4. Search class by name");
			System.out.println("5. Read class");
			System.out.println("6. Exit");
			System.out.println("---VUI LONG CHON!---");
			int sc = new Scanner(System.in).nextInt();
			if (sc == 1) {
				add();
			} else if (sc == 2) {
				update();
			} else if (sc == 3) {
				delete();
			} else if (sc == 4) {
				searchByCourseName();
			} else if (sc == 5) {
				get();
			} else if (sc == 6) {
				break;
			} else
				System.out.println("Chon sai, vui long chon lai !!!!!");
		}
	}

	public static void add() {
		ClazzService clazzService = new ClazzServiceImpl();
		while (true) {
			Clazz clazz = new Clazz();
			clazzService.input(clazz);
			clazzService.insert(clazz);
			System.out.println("Them nua ko? (Y/N)");
			String s = new Scanner(System.in).nextLine();
			if (s.equalsIgnoreCase("N")) {
				break;
			}
		}
	}

	public static void get() {
		ClazzService clazzService = new ClazzServiceImpl();
		List<Clazz> list = clazzService.getAll();
		for (Clazz clazz : list) {
			clazzService.info(clazz);
		}
	}

	public static void delete() {
		ClazzService clazzService = new ClazzServiceImpl();
		System.out.println("Nhap id can delete: ");
		int c = new Scanner(System.in).nextInt();
		clazzService.delete(c);
	}

	public static void update() {
		ClazzService clazzService = new ClazzServiceImpl();
		Clazz clazz = new Clazz();
		clazzService.input(clazz);
		clazzService.update(clazz);
	}

	private static void searchByCourseName() {

		ClazzService clazzService = new ClazzServiceImpl();

		System.out.println("Nhap vao ten khoa hoc can tim: ");
		String str = new Scanner(System.in).nextLine();

		List<Clazz> list = clazzService.searchByCourseName(str);
		if (list.size() > 0) {
			for (Clazz clazz : list) {
				clazzService.info(clazz);
			}
		} else
			System.out.println("Khong co !!!");

	}

}
