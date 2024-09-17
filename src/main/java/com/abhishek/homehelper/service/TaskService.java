package com.abhishek.homehelper.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abhishek.homehelper.model.Task;
import com.abhishek.homehelper.repository.TaskRepository;

@Service
public class TaskService {

	@Autowired
	private TaskRepository repository;

	public Task addTask(Task task) {
		task.setTaskId(UUID.randomUUID().toString().split("-")[0]);
		return repository.save(task);
	}

	public List<Task> getAllTask() {
		return repository.findAll();
	}

	public Task getTaskByID(String taskId) {
		return repository.findById(taskId).get();
	}

	public Task updateTask(String taskId,Task task) {
		Optional<Task> existingTask = repository.findById(taskId);
		
		
		if(existingTask.isPresent()) {
			Task existing = existingTask.get();
			existing.setTitle(task.getTitle());
			existing.setCompleted(task.isCompleted());
			repository.save(existing);
			return existing;
			
		}
		
		throw new RuntimeException("Could not find the resource with the ID : "+ taskId);
	}

	public String deleteTask(String taskId) {
		repository.deleteById(taskId);
		return taskId + "Deleted";
	}

}
