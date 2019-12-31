package io.javabrains.springbootstarter.topic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {

	@Autowired
	private TopicRepository topicRepository;

	public long getAllTopicsCount() {
		return topicRepository.count();
	}
	
	public List<Topic> getAllTopics() {
		return (List<Topic>) topicRepository.findAll();
	}

	public Topic getTopic(String id) {
		return topicRepository.findById(id).orElse(null);
	}

	public void addTopic(Topic topic) {
		topicRepository.save(topic);
	}
	
	public void saveAll(List<Topic> topicList) {
		topicRepository.saveAll(topicList);
	}

	public void updateTopic(Topic topic, String id) {
		topicRepository.save(topic);
	}

	public void deleteTopicById(String id) {
		topicRepository.deleteById(id);
	}
	
	public void deleteTopic(Topic topic) {
		topicRepository.delete(topic);
	}
}
