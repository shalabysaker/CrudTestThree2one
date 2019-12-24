package com.test.testThree2one.Dao;

import com.test.testThree2one.model.Student;

public interface StudentDao {
	
	public boolean addStudent(Student student);
	public boolean checkStudent(String email ,String password);
	public Student findStudent(String email);

}
