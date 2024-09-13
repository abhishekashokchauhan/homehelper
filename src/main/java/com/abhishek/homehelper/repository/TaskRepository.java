package com.abhishek.homehelper.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.abhishek.homehelper.model.Task;

public interface TaskRepository extends MongoRepository<Task, String> {

}
