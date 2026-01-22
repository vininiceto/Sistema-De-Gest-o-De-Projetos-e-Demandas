package br.com.vininiceto.sistemadegestaodeprojetosedemandas.controller;

import br.com.vininiceto.sistemadegestaodeprojetosedemandas.dto.TaskRequestDTO;
import br.com.vininiceto.sistemadegestaodeprojetosedemandas.dto.TaskResponseDTO;
import br.com.vininiceto.sistemadegestaodeprojetosedemandas.dto.UpdateTaskStatusRequestDTO;
import br.com.vininiceto.sistemadegestaodeprojetosedemandas.model.Enums.TaskPriority;
import br.com.vininiceto.sistemadegestaodeprojetosedemandas.model.Enums.TaskStatus;
import br.com.vininiceto.sistemadegestaodeprojetosedemandas.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sistema/gestao/tasks")
public class TaskController {

    @Autowired
    private TaskService service;


    @GetMapping("/task")
    public ResponseEntity<List<TaskResponseDTO>> findTask(@RequestParam TaskStatus status, @RequestParam TaskPriority priority, @RequestParam Long projectId) {
        return ResponseEntity.ok(service.findTaskByParams(status, priority, projectId));
    }

    @PostMapping("/create/{projectId}")
    public ResponseEntity<TaskResponseDTO> createTask(@PathVariable Long projectId, @Valid @RequestBody TaskRequestDTO task) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createTask(task, projectId));
    }

    @PutMapping("/update/{id}")

    public ResponseEntity<TaskResponseDTO> updateTask(@RequestBody UpdateTaskStatusRequestDTO statusTask, @PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.updateStatus(statusTask, id));
    }

    @DeleteMapping("/delete/{id}")

    public void deleteTask(@PathVariable Long id) {
        service.deleteTask(id);
    }


}
