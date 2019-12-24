package com.test.testThree2one;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.test.testThree2one.Dao.CoursesDao;
import com.test.testThree2one.model.Courses;

@SpringBootApplication
@ComponentScan({ "com.test.testThree2one" })
public class TestThree2oneApplication implements CommandLineRunner {

	@Autowired
	CoursesDao coursesDao;

	public static void main(String[] args) {
		SpringApplication.run(TestThree2oneApplication.class, args);
	}

	@Override
	public void run(String... args) {

		Date d = new Date();
		Date lastUpdate = new Date(d.getTime() - 3 * 24 * 3600 * 1000);
		Courses courses = new Courses();
		courses.setCourseName("Java");
		courses.setDescription("Java is high level language ");
		courses.setInstractor("shalaby");
		courses.setLastUpdate(lastUpdate);
		courses.setPublishDate(new Date());
		courses.setTotalHour((long) 10);
		coursesDao.addCourse(courses);

		Courses courses2 = new Courses();
		courses2.setCourseName("angualr");
		courses2.setDescription("angular is front end ");
		courses2.setInstractor("yousef");
		courses2.setLastUpdate(lastUpdate);
		courses2.setPublishDate(new Date());
		courses2.setTotalHour((long) 20);
		coursesDao.addCourse(courses2);

		Courses courses3 = new Courses();
		courses3.setCourseName("react");
		courses3.setDescription("react is front end ");
		courses3.setInstractor("mohamed");
		courses3.setLastUpdate(lastUpdate);
		courses3.setPublishDate(new Date());
		courses3.setTotalHour((long) 30);
		coursesDao.addCourse(courses3);

		Courses courses4 = new Courses();
		courses4.setCourseName("c#");
		courses4.setDescription("c# is back end ");
		courses4.setInstractor("7osam");
		courses4.setLastUpdate(lastUpdate);
		courses4.setPublishDate(new Date());
		courses4.setTotalHour((long) 40);
		coursesDao.addCourse(courses4);

		Courses courses5 = new Courses();
		courses5.setCourseName("c++");
		courses5.setDescription("c++ ");
		courses5.setInstractor("m7md");
		courses5.setLastUpdate(lastUpdate);
		courses5.setPublishDate(new Date());
		courses5.setTotalHour((long) 40);
		coursesDao.addCourse(courses5);

	}

}
