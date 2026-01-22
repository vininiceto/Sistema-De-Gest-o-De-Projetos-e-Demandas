package br.com.vininiceto.sistemadegestaodeprojetosedemandas.service;

import br.com.vininiceto.sistemadegestaodeprojetosedemandas.Exceptions.handler.DateInvalidException;
import br.com.vininiceto.sistemadegestaodeprojetosedemandas.Exceptions.handler.ObjectNullException;
import br.com.vininiceto.sistemadegestaodeprojetosedemandas.dto.TaskRequestDTO;
import br.com.vininiceto.sistemadegestaodeprojetosedemandas.dto.TaskResponseDTO;
import br.com.vininiceto.sistemadegestaodeprojetosedemandas.dto.UpdateTaskStatusRequestDTO;
import br.com.vininiceto.sistemadegestaodeprojetosedemandas.model.Enums.TaskPriority;
import br.com.vininiceto.sistemadegestaodeprojetosedemandas.model.Enums.TaskStatus;
import br.com.vininiceto.sistemadegestaodeprojetosedemandas.model.Project;
import br.com.vininiceto.sistemadegestaodeprojetosedemandas.model.Task;
import br.com.vininiceto.sistemadegestaodeprojetosedemandas.repository.ProjectRepository;
import br.com.vininiceto.sistemadegestaodeprojetosedemandas.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

import java.time.DateTimeException;
import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository repository;

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    ObjectMapper mapper;


    public List<TaskResponseDTO> findTaskByParams(TaskStatus status, TaskPriority priority, Long projectId) {

        List<Task> task = repository.findTaskByParams(status, priority, projectId);

        return task.stream().map(t -> mapper.convertValue(t, TaskResponseDTO.class)).toList();

    }

    public TaskResponseDTO createTask(TaskRequestDTO task, Long projectId) {
        Project project = projectRepository.findProjectById(projectId).orElseThrow(() -> new ObjectNullException("Project not found!"));
        Task task1 = new Task();
        task1.setTitle(task.title());
        task1.setDescription(task.description());
        task1.setStatus(task.status());
        task1.setPriority(task.priority());
        if(project.getStartDate().after(task.dueDate())){
            throw new DateInvalidException("Data informada é anterior ao inicio do projeto");
        }
        if(project.getEndDate().before(task.dueDate())){
            throw new DateInvalidException("Data informada é após a finalização do projeto");
        }
        task1.setDueDate(task.dueDate());
        task1.setProject(project);
        Task saved =  repository.save(task1);

        return mapper.convertValue(saved, TaskResponseDTO.class);
    }

    public TaskResponseDTO updateStatus(UpdateTaskStatusRequestDTO statusTask, Long id) {

        Task task1 = repository.findById(id).orElseThrow(() -> new ObjectNullException("Task not found!"));

        task1.setStatus(statusTask.status());

        Task saved =  repository.save(task1);

        return mapper.convertValue(saved, TaskResponseDTO.class);
    }

    public void deleteTask(Long id) {
        repository.deleteById(id);
        System.out.println("Task deleted!");
    }


}
