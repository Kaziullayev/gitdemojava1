package com.example.demojava1.Services;

import com.example.demojava1.Entities.Task;
import com.example.demojava1.Repositories.TaskRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    public TaskService(TaskRepository taskRepo) {
        this.taskRepository = taskRepo;
    }

    public Page<Task> findTaskByUserId(Long userId, Pageable pageable) {
        return taskRepository.findByUserId(userId, pageable);
    }

    public void save(Task task) {
        taskRepository.save(task);
    }


    public Page<Task> findByUserIdAndCategoryId(Long userId, String status, Pageable pageable) {
        return taskRepository.findByUserIdAndStatus(userId, status, pageable);}

    public Page<Task> findByUserIdAndTitleContainingAndStatus(Long userId, String title, String status, Pageable pageable) {
        return taskRepository.findByUserIdAndTitleContainingAndStatus(userId, title, status, pageable);
    }

    public Page<Task> findByUserIdAndTitleContaining(Long userId, String title, Pageable pageable) {
        return taskRepository.findByUserIdAndTitleContaining(userId, title, pageable);
    }

    public Page<Task> findByUserIdAndStatus(Long userId, String status, Pageable pageable) {
        return taskRepository.findByUserIdAndStatus(userId, status, pageable);
    }

    public Page<Task> findByUserId(Long userId, Pageable pageable) {
        return taskRepository.findByUserId(userId, pageable);
    }

    public void deleteById(Long id) {
        taskRepository.deleteById(id);
    }
    public Page<Task> findTasksByUserId(Long userId, Pageable pageable) {
        return taskRepository.findByUserId(userId, pageable);
    }

    public List<Task> findTasksByUserId(Long userId) {
        List<Task> tasks = taskRepository.findByUserId(userId);
        System.out.println("Tasks found: " + tasks);
        return tasks;
    }

    public Task findById(Long id) {
        return taskRepository.findById(id).orElse(null); // Используем Optional
    }
}