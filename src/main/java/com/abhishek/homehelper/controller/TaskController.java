package com.abhishek.homehelper.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.abhishek.homehelper.model.Task;
import com.abhishek.homehelper.service.TaskService;

@RestController
@RequestMapping("/tasks")
public class TaskController {
	
	@Autowired
	private TaskService service;
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Task> getAllTasks()
	{
		return service.getAllTask();
	}
	
	@GetMapping("/{taskId}")
	@ResponseStatus(HttpStatus.OK)
	public Task getTaskById(@PathVariable String taskId)
	{
		return service.getTaskByID(taskId);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Task addTasks(@RequestBody Task task)
	{
		return service.addTask(task);
	}
	
	
	@PutMapping
	@ResponseStatus(HttpStatus.OK)
	public Task updateTask(@RequestBody Task task)
	{
		return service.updateTask(task);
	}
	
	@DeleteMapping
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public String updateTask(@PathVariable String taskId)
	{
		return service.deleteTask(taskId);
	}
}
