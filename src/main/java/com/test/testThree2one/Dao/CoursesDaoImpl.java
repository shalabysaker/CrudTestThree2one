package com.test.testThree2one.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PreRemove;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.test.testThree2one.model.Courses;
import com.test.testThree2one.model.Student;


@Repository
@Transactional
public class CoursesDaoImpl implements CoursesDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Courses> allCourses() {
		String hql = "from Courses";
		List<Courses> courses = em.createQuery(hql, Courses.class).getResultList();

		return courses;
	}

	@Override
	public List<Courses> registerStudentCourses(Long studentId) {
		String hql = "select c from Courses c join c.students s where s.id=:studentId";
		List<Courses> courses = em.createQuery(hql, Courses.class).setParameter("studentId", studentId).getResultList();
		return courses;
	}

	@Override
	public boolean registerStudentIntoCourse(Long courseid, Student student) {
		String hql = "from Courses c where c.id=:courseid";
		Courses courses = em.createQuery(hql, Courses.class).setParameter("courseid", courseid).getSingleResult();
		
		student.getCourses().add(courses);
		courses.getStudents().add(student);
		Courses res = em.merge(courses);

		if (res != null) {
			return true;
		} else {
			return false;
		}

	}

	@PreRemove
	@Override
	public boolean unregisterStudentFromCourse(Long courseid, Student student) {
		
		Courses courses=em.find(Courses.class, courseid);

		student.getCourses().removeIf(s -> s.getId() ==courses.getId());
		Student res = em.merge(student);

		if (res != null) {
			return true;
		} else {
			return false;
		}

	}

	@Override
	public void addCourse(Courses course) {
		// TODO Auto-generated method stub
		em.merge(course);
	}

}
