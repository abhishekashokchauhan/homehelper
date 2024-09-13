package com.abhishek.homehelper.service;

import java.util.List;
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

	public Task updateTask(Task task) {
		Task existingTask = repository.findById(task.getTaskId()).get();
		existingTask.setTitle(task.getTitle());
		existingTask.setCompleted(task.isCompleted());
		return repository.save(existingTask);
	}

	public String deleteTask(String taskId) {
		repository.deleteById(taskId);
		return taskId + "Deleted";
	}

}
