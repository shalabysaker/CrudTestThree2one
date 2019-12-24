package com.test.testThree2one.Dao;

import java.util.List;

import com.test.testThree2one.model.Courses;
import com.test.testThree2one.model.Student;



public interface CoursesDao {

	
	public List<Courses> allCourses();
	
	public List<Courses> registerStudentCourses(Long studentId);
	
	public boolean registerStudentIntoCourse(Long courseid, Student student);
	
	public boolean unregisterStudentFromCourse(Long courseid, Student student);
	
	public void addCourse(Courses course);
}
