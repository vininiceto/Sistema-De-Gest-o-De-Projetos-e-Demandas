package br.com.vininiceto.sistemadegestaodeprojetosedemandas.service;

import br.com.vininiceto.sistemadegestaodeprojetosedemandas.Exceptions.handler.ObjectNullException;
import br.com.vininiceto.sistemadegestaodeprojetosedemandas.model.Enums.TaskPriority;
import br.com.vininiceto.sistemadegestaodeprojetosedemandas.model.Enums.TaskStatus;
import br.com.vininiceto.sistemadegestaodeprojetosedemandas.model.Project;
import br.com.vininiceto.sistemadegestaodeprojetosedemandas.model.Task;
import br.com.vininiceto.sistemadegestaodeprojetosedemandas.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository repository;

    @Autowired
    private ProjectService projectRepository;


    public List<Task> findTaskByParams(TaskStatus status, TaskPriority prioriry, Long projectId) {
        return repository.findTaskByParams(status, prioriry, projectId);
    }

    public Task createTask(Task task, Long projectId) {
        Project project = projectRepository.findProjectById(projectId).orElseThrow(() -> new ObjectNullException("Project not found!"));
        task.setProject(project);
        return repository.save(task);
    }

    public Task updateStatus(TaskStatus statusTask, Long id) {

        Task task1 = repository.findById(id).orElseThrow(() -> new ObjectNullException("Task not found!"));

        task1.setStatus(statusTask);

        return repository.save(task1);


    }

    public void deleteTask(Long id) {
        repository.deleteById(id);
        System.out.println("Task deleted!");
    }


}
