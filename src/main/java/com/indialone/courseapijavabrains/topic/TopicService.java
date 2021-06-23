package com.indialone.courseapijavabrains.topic;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TopicService {

    private final List<Topic> topics = new ArrayList<>(Arrays.asList(
            new Topic("1", "Java", "Learning Java"),
            new Topic("2", "Kotlin", "Learning Kotlin"),
            new Topic("3", "Android", "Learning Android"))
    );

    public List<Topic> getTopics() {
        return topics;
    }

    public Topic getTopicById(String id) {
        return topics.stream().filter(topic -> topic.getId().equals(id)).findFirst().get();
    }

    public void addTopic(Topic topic) {
        topics.add(topic);
    }

    public void updateTopic(String id, Topic topic) {

        for (int i = 0; i < topics.size(); i++) {
            Topic t = topics.get(i);
            if (t.getId().equals(id)) {
                topics.set(i, topic);
            }
        }

    }

    public void deleteTopicById(String id) {
        topics.removeIf(topic -> topic.getId().equals(id));
    }
}
