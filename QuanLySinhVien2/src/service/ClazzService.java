package service;

import java.util.List;

import model.Clazz;

public interface ClazzService {
	void input(Clazz c);

	void info(Clazz c);

	void insert(Clazz c);

	void delete(int class_id);

	void update(Clazz c);

	List<Clazz> getAll();

	List<Clazz> searchByCourseName(String courseName);
}
