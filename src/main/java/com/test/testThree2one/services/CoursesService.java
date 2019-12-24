package com.test.testThree2one.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.testThree2one.Dao.CoursesDao;
import com.test.testThree2one.Dao.StudentDao;
import com.test.testThree2one.model.Courses;
import com.test.testThree2one.model.Student;



@Service
public class CoursesService {

	@Autowired
	private CoursesDao coursesDoa;

	@Autowired
	private StudentDao studentDao;
	public List<Courses> allCourses() {
		return coursesDoa.allCourses();
	}

	public List<Courses> registerStudentCourses(String email) {
		Student student=studentDao.findStudent(email);
		
		return coursesDoa.registerStudentCourses(student.getId());
	}

	public String registerStudentIntoCourse(Long courseid, String email) {
		Student student=studentDao.findStudent(email);
		boolean res = coursesDoa.registerStudentIntoCourse(courseid, student);

		if (res) {
			return "done";
		} else {
			return "not added";
		}
	}
	
	public String unregisterStudentFromCourse(Long courseid, String email) {
		Student student=studentDao.findStudent(email);
		boolean res = coursesDoa.unregisterStudentFromCourse(courseid, student);
		
		if (res) {
			return "OK";
		} else {
			return "not removed";
		}
	}
}
