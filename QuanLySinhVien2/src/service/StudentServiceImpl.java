package service;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import dao.PersonDAO;
import dao.StudentDAO;
import model.Student;

public class StudentServiceImpl implements StudentService {
	PersonDAO personDAO = new PersonDAO();
	StudentDAO studentDAO = new StudentDAO();

	@Override
	public void input(Student st) {
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

		System.out.println("Nhap studenCode: ");
		st.setStudentCode(new Scanner(System.in).nextLine());

	}

	@Override
	public void info(Student st) {
		System.out.println("Id Student: " + st.getId());
		System.out.println("Name Student: " + st.getName());
		SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy", new Locale("vi"));
		System.out.println("Birthday: " + formater.format(st.getBirthDate()));
		System.out.println("StudentCode: " + st.getStudentCode());
		System.out.println("------------");

	}

	@Override
	public void insert(Student st) {
		
		try {
			personDAO.add(st);
			studentDAO.add(st);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Khong them duoc!!!");
		}

	}

	@Override
	public void update(Student st) {
		try {
			personDAO.update(st);
			studentDAO.update(st);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Khong update duoc!!!");
		}

	}

	@Override
	public void delete(int id) {
		try {
			studentDAO.delete(id);
			personDAO.delete(id);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Khong delete duoc!!!");
		}

	}

	@Override
	public List<Student> getAll() {
		try {
			return studentDAO.selectAll();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Xay ra loi");
		}
		return new ArrayList<>();
	}

	@Override
	public List<Student> search(String name) {
		try {
			return studentDAO.searchName(name);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Xay ra loi");
		}
		return new ArrayList<>();
	}

	@Override
	public Student get(String studentCode) {
		try {
			return studentDAO.get(studentCode);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
