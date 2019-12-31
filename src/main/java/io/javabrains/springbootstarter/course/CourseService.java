package io.javabrains.springbootstarter.course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

	@Autowired
	private CourseRepository courseRepository;

	public long getAllCoursesCount(String tid) {
		return courseRepository.countByTopicId(tid);
	}

	public List<Course> findByName(String name) {
		return (List<Course>) courseRepository.findByName(name);
	}
	
	public List<Course> getAllCourses(String tid) {
		return (List<Course>) courseRepository.findByTopicId(tid);
	}

	public Course getCourse(String tid, String cid) {
		return courseRepository.findByTopicIdAndId(tid, cid).orElse(null);
	}

	public void addCourse(Course course) {
		courseRepository.save(course);
	}

	public void updateCourse(Course course) {
		courseRepository.save(course);
	}

	public void deleteCourseById(String id) {
		courseRepository.deleteById(id);
	}

	public void deleteCourse(Course course) {
		courseRepository.delete(course);
	}
}
