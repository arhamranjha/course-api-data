package io.javabrains.springbootstarter.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TopicService {

	private List<Topic> topicsList = new ArrayList<Topic>(Arrays.asList(new Topic("1", "name1", "desc2"),
			new Topic("2", "name2", "desc2"), new Topic("3", "name3", "desc3")));

	public List<Topic> getAllTopics() {
		return topicsList;
	}

	public Topic getTopic(String id) {
		return topicsList.stream().filter(e -> id.equals(e.getId())).findFirst().orElse(null);
	}

	public void addTopic(Topic topic) {
		topicsList.add(topic);
	}

	public void updateTopic(Topic topic, String id) {
		for (int i = 0; i < topicsList.size(); i++) {
			if (topicsList.get(i).getId().equalsIgnoreCase(id)) {
				topicsList.set(i, topic);
				return;
			}
		}
	}

	public void deleteTopic(String id) {
		topicsList.removeIf(e -> e.getId().equalsIgnoreCase(id));
	}
}
