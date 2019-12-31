package io.javabrains.springbootstarter.course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.javabrains.springbootstarter.topic.Topic;

@RestController
public class CourseController {

	@Autowired
	private CourseService courseService;
	
	@RequestMapping("topics/{tid}/courseCount")
	public Long getAllCoursesCount(@PathVariable String tid) {
		return courseService.getAllCoursesCount(tid);
	}
	
	@RequestMapping("topics/{tid}/findByNameCourse/{cname}")
	public List<Course> findByName(@PathVariable String cname) {
		return courseService.findByName(cname);
	}

	@RequestMapping("topics/{tid}/course")
	public List<Course> getAllCourses(@PathVariable String tid) {
		return courseService.getAllCourses(tid);
	}

	@RequestMapping("topics/{tid}/course/{cid}")
	public Course getCourse(@PathVariable String tid, @PathVariable String cid) {
		return courseService.getCourse(tid, cid);
	}

	@RequestMapping(method = RequestMethod.POST, value = "topics/{tid}/course")
	public void addCourse(@PathVariable String tid, @RequestBody Course course) {
		course.setTopic(new Topic(tid, "", ""));
		courseService.addCourse(course);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "topics/{tid}/course")
	public void updateCourse(@RequestBody Course course, @PathVariable String tid) {
		course.setTopic(new Topic(tid, "", ""));
		courseService.updateCourse(course);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "topics/{tid}/course")
	public void deleteCourse(@RequestBody Course course) {
		courseService.deleteCourse(course);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "topics/{tid}/course/{cid}")
	public void deleteCourseById(@PathVariable String cid) {
		courseService.deleteCourseById(cid);
	}

}
