package exercise.controller;

import java.util.List;

import exercise.dto.TaskCreateDTO;
import exercise.dto.TaskDTO;
import exercise.dto.TaskUpdateDTO;
import exercise.mapper.TaskMapper;
import exercise.repository.UserRepository;
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

import exercise.exception.ResourceNotFoundException;
import exercise.repository.TaskRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/tasks")
public class TasksController {
    // BEGIN
    @Autowired TaskRepository taskRepository;
    
    @Autowired TaskMapper taskMapper;
    
    @Autowired UserRepository userRepository;
    
    @GetMapping(path = "")
    public List<TaskDTO> index() {
        var tasks = taskRepository.findAll();
        return tasks.stream()
                .map(t -> taskMapper.map(t))
                .toList();
    }
    
    @GetMapping(path = "/{id}")
    public TaskDTO show(@PathVariable Long id) {
        var task = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task with id " + id + " not found"));
        return taskMapper.map(task);
    }
    
    @PostMapping(path = "")
    @ResponseStatus(HttpStatus.CREATED)
    public TaskDTO create(@Valid @RequestBody TaskCreateDTO dataDTO) {
        var task = taskMapper.map(dataDTO);
        taskRepository.save(task);
        //var userId = task.getAssigneeId();
        //var user = userRepository.findById(userId);
        var user = task.getAssignee();
        user.addTask(task);
        return taskMapper.map(task);
    }
    
    @PutMapping(path = "{id}")
    public TaskDTO update(@Valid @RequestBody TaskUpdateDTO dataDTO, @PathVariable Long id) {
        var task = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task with id " + id + " not found"));
        taskMapper.update(dataDTO, task);
        var user = userRepository.findById(dataDTO.getAssigneeId())
                .orElseThrow(() -> new ResourceNotFoundException("User with id " + id + " not found"));
        task.setAssignee(user);
        taskRepository.save(task);
        return taskMapper.map(task);
    }
    
    @DeleteMapping(path = "{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        var task = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task with id " + id + " not found"));
        taskRepository.deleteById(id);
        //var userId = task.getAssigneeId();
        //var user = userRepository.findById(userId);
        var user = task.getAssignee();
        user.removeTask(task);
    }
    // END
}
