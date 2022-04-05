package service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dao.CourseDAO;
import model.Course;

public class CourseServiceImpl implements CourseService {

	@Override
	public void input(Course course) {
		while (true) {
			try {
				System.out.println("Id: ");
				course.setId(new Scanner(System.in).nextInt());
				break;

			} catch (Exception e) {
				System.out.println("Nhap sai nhap lai !");
			}
		}

		System.out.println("Name: ");
		course.setName(new Scanner(System.in).nextLine());

	}

	@Override
	public void info(Course course) {
		System.out.println("Course Id: " + course.getId());
		System.out.println("Course Name: " + course.getName());
		System.out.println("-----------");

	}

	@Override // them course vao file
	public void insert(Course course) {
		CourseDAO dao = new CourseDAO();
		try {
			dao.add(course);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Khong them dc");
		}
	}

	@Override
	public List<Course> getAll() {
		CourseDAO dao = new CourseDAO();

		try {
			return dao.selectAll();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Xay ra loi!");
		}
		return new ArrayList<>();

	}

	@Override
	public void update(Course course) {
		CourseDAO dao = new CourseDAO();
		try {
			dao.update(course);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Khong update duoc!");
		}

	}

	@Override
	public void delete(int id) {
		CourseDAO dao = new CourseDAO();
		try {
			dao.delete(id);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Khong xoa duoc!");
		}

	}

}
