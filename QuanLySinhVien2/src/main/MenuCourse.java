package main;

import java.util.List;
import java.util.Scanner;

import com.mysql.cj.x.protobuf.MysqlxCrud.Update;

import model.Course;
import service.CourseService;
import service.CourseServiceImpl;

public class MenuCourse {
	
	public static void menuCouse() {
		CourseService courseService = new CourseServiceImpl();
		while (true) {
			System.out.println("1. Add Course");
			System.out.println("2. Update Course");
			System.out.println("3. Delete Course");
			System.out.println("4. Read Course");
			System.out.println("5. Exit");
			System.out.println("VUI LONG CHON !!!!");
			int c = new Scanner(System.in).nextInt();
			if (c == 1) {
				write();
			} else if (c == 2) {
				update();
			} else if (c == 3) {
				delete();
			} else if (c == 4) {
				readAll();
			} else if (c == 5) {
				break;
			} else {
				System.out.println("VUI LONG CHON LAI !!!!");
			}

		}
	}

	public static void write() {
		CourseService courseService = new CourseServiceImpl();
		while (true) {
			// tao moi
			Course mh = new Course();
			courseService.input(mh);
			courseService.insert(mh);
			System.out.println("Nhap them Y/N");
			String s = new Scanner(System.in).nextLine();
			if (s.equalsIgnoreCase("N")) {
				break;
			}
		}
	}

	public static void readAll() {
		// sau khi nhap xong doc ra
		CourseService courseService = new CourseServiceImpl();
		List<Course> courses = courseService.getAll();

		for (Course course : courses) {
			courseService.info(course);
		}
	}

	public static void update() {
		CourseService courseService = new CourseServiceImpl();
		System.out.println("Cap nhat!!!");
		Course mh = new Course();
		courseService.input(mh);
		courseService.update(mh);
	}

	public static void delete() {
		CourseService courseService = new CourseServiceImpl();
		System.out.println("Nhap Id can xoa");
		int c = new Scanner(System.in).nextInt();
		courseService.delete(c);
	}

}
