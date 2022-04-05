package service;

import java.util.List;

import model.Teacher;

public interface TeacherService {
	void input(Teacher tc);

	void info(Teacher tc);

	void insert(Teacher tc);

	void update(Teacher tc);

	void delete(int id);

	List<Teacher> getAll();

	List<Teacher> search(String name);

	List<Teacher> get(String deparment);
}
