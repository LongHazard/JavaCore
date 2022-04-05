package service;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import dao.PersonDAO;
import dao.TeacherDAO;
import model.Teacher;

public class TeacherServiceImpl implements TeacherService{
	PersonDAO personDAO = new PersonDAO();
	TeacherDAO teacherDAO = new TeacherDAO();

	@Override
	public void input(Teacher st) {
		while (true) {
			try {
				System.out.println("Nhap id: ");
				st.setId(new Scanner(System.in).nextInt());

				break;
			} catch (Exception e) {
				System.out.println("Nhap sai, nhap lai!!!!");
			}
		}

		System.out.println("Nhap name: ");
		st.setName(new Scanner(System.in).nextLine());

		while (true) {
			try {
				System.out.println("Date (dd/mm/yyyy): ");
				String sDate = new Scanner(System.in).nextLine();
				SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy");
				st.setBirthDate(formater.parse(sDate));
				break;
			} catch (ParseException e) {
				System.out.println("Nhap sai nhap lai");
			}
		}

		System.out.println("Nhap department: ");
		st.setDepartment(new Scanner(System.in).nextLine());

	}

	@Override
	public void info(Teacher st) {
		System.out.println("Id Student: " + st.getId());
		System.out.println("Name Student: " + st.getName());
		SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy", new Locale("vi"));
		System.out.println("Birthday: " + formater.format(st.getBirthDate()));
		System.out.println("Department: " + st.getDepartment());
		System.out.println("------------");

	}

	@Override
	public void insert(Teacher st) {
		
		try {
			personDAO.add(st);
			teacherDAO.add(st);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Khong them duoc!!!");
		}

	}

	@Override
	public void update(Teacher st) {
		try {
			personDAO.update(st);
			teacherDAO.update(st);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Khong update duoc!!!");
		}

	}

	@Override
	public void delete(int id) {
		try {
			teacherDAO.delete(id);
			personDAO.delete(id);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Khong delete duoc!!!");
		}

	}

	@Override
	public List<Teacher> getAll() {
		try {
			return teacherDAO.selectAll();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Xay ra loi");
		}
		return new ArrayList<>();
	}

	@Override
	public List<Teacher> search(String name) {
		try {
			return teacherDAO.searchName(name);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Xay ra loi");
		}
		return new ArrayList<>();
	}

	@Override
	public List<Teacher> get(String deparment) {
		try {
			return teacherDAO.get(deparment);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Xay ra loi");
		}
		return new ArrayList<>();
	}
}

	