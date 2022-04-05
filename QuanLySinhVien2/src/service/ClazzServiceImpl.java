package service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dao.ClazzDAO;
import model.Clazz;
import model.Course;

public class ClazzServiceImpl implements ClazzService {
	ClazzDAO clazzDAO = new ClazzDAO();

	@Override
	public void input(Clazz c) {
		while (true) {
			try {
				System.out.println("Nhap class_id: ");
				c.setId(new Scanner(System.in).nextInt());
				break;
			} catch (Exception e) {
				System.out.println("Nhap sai nhap lai");
			}
		}

		System.out.println("Nhap class_name: ");
		c.setName(new Scanner(System.in).nextLine());

		while (true) {
			try {
				System.out.println("Nhap course_id: ");
				Course course = new Course();
				course.setId(new Scanner(System.in).nextInt());
				c.setCourse(course);
				break;
			} catch (Exception e) {
				System.out.println("Nhap sai nhap lai");
			}
		}

	}

	@Override
	public void info(Clazz c) {
		System.out.println("Class_id: " + c.getId());
		System.out.println("Class_name: " + c.getName());
		if (c.getCourse() != null) {
			CourseService courseService = new CourseServiceImpl();
			//System.out.println("Course_id: ");
			courseService.info(c.getCourse());
		}
	}

	@Override
	public void insert(Clazz c) {
		try {
			clazzDAO.add(c);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Không add được");
		}

	}

	@Override
	public void delete(int class_id) {
		try {
			clazzDAO.delete(class_id);;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Không delete được");
		}

	}

	@Override
	public void update(Clazz c) {
		try {
			clazzDAO.update(c);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Không update được");
		}

	}

	@Override
	public List<Clazz> getAll() {
		try {
			return clazzDAO.selectAll();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("LOI !!!!");
		}
		return new ArrayList<>();
	}

	@Override
	public List<Clazz> searchByCourseName(String courseName) {
		try {
			return clazzDAO.searchByCourseName(courseName);
		} catch (Exception e) {
			System.out.println("LOI !!!!");
		}
		return new ArrayList<>();
	}

}
