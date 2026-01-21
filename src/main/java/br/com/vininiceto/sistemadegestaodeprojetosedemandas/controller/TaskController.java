package br.com.vininiceto.sistemadegestaodeprojetosedemandas.controller;

import br.com.vininiceto.sistemadegestaodeprojetosedemandas.dto.StatusUpdateDTO;
import br.com.vininiceto.sistemadegestaodeprojetosedemandas.model.Enums.TaskPriority;
import br.com.vininiceto.sistemadegestaodeprojetosedemandas.model.Enums.TaskStatus;
import br.com.vininiceto.sistemadegestaodeprojetosedemandas.model.Task;
import br.com.vininiceto.sistemadegestaodeprojetosedemandas.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/sistema/gestao/tasks")
public class TaskController {

    @Autowired
    private TaskService service;


    @GetMapping("/task")
    public ResponseEntity<List<Task>> findTask(@RequestParam TaskStatus status, @RequestParam TaskPriority priority, @RequestParam Long projectId){
                return ResponseEntity.ok(service.findTaskByParams(status, priority, projectId));
    }

    @PostMapping("/create/{projectId}")
    public ResponseEntity<Task> createTask(@PathVariable Long projectId, @RequestBody Task task){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createTask(task, projectId));
    }

    @PutMapping("/update/{id}")

    public ResponseEntity<Task> updateTask(@RequestBody StatusUpdateDTO statusTask, @PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.updateStatus(statusTask.getStatus(), id));
    }

    @DeleteMapping("/delete/{id}")

    public void deleteTask(@PathVariable Long id){
        service.deleteTask(id);
    }




}
