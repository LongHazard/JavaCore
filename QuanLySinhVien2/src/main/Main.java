package main;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		while (true) {
			System.out.println("---VUI LONG CHON---");
			System.out.println("1. Menu Student");
			System.out.println("2. Menu Teacher");
			System.out.println("3. Menu Class");
			System.out.println("4. Menu Course");
			System.out.println("5. Exit");
			System.out.println("---VUI LONG CHON---");
			int sc = new Scanner(System.in).nextInt();
			if(sc == 1) {
				MenuStudent.menuStudent();
			}else if(sc == 2) {
				MenuTeacher.menuTeacher();
			}else if(sc == 3) {
				MenuClass.menuClass();
			}else if(sc == 4) {
				MenuCourse.menuCouse();
			}else if(sc == 5) {
				break;
			}else 
				System.out.println("Chon sai, vui long chon lai !");
			
		}
	}

}
