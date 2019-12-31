package io.javabrains.springbootstarter.course;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, String>{
	
	public List<Course> findByName(String name);
	
	public List<Course> findByTopicId(String topicId);
	
	public Optional<Course> findByTopicIdAndId(String topicId, String courseId);
	
	public Long countByTopicId(String topicId);
	

	
	


}
