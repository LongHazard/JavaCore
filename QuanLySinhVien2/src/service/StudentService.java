package service;

import java.util.List;

import model.Person;
import model.Student;

public interface StudentService {
	void input(Student st);

	void info(Student st);

	void insert(Student st);

	void update(Student st);

	void delete(int id);

	List<Student> getAll();

	List<Student> search(String name);

	Student get(String studentCode);
}
