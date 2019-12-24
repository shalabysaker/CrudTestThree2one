package com.test.testThree2one.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.testThree2one.Dao.StudentDao;
import com.test.testThree2one.model.Student;


@Service
public class StudentService {

	@Autowired
	private StudentDao studentDao;

	public String registerStudent(String name, String email, String password, String username, String gender) {

		Student checkEmailExist = studentDao.findStudent(email);

		if (checkEmailExist == null) {
			Student student = new Student();
			student.setName(name);
			student.setEmail(email);
			student.setUsername(username);
			student.setPassword(password);
			student.setGender(gender);

			boolean res = studentDao.addStudent(student);

			if (res) {
				return "OK";
			} else {
				return "Student not add";
			}
		}else{
			return "email exist";
		}

	}
	
	
	public String loginStudent(String email,String password){
		boolean res = studentDao.checkStudent(email, password);
		
		if(res){
			return "OK";
		}else{
			return "username or password not correct";
		}
	}
}
