package br.com.vininiceto.sistemadegestaodeprojetosedemandas.service;

import br.com.vininiceto.sistemadegestaodeprojetosedemandas.Exceptions.handler.DateInvalidException;
import br.com.vininiceto.sistemadegestaodeprojetosedemandas.Exceptions.handler.ObjectEmptyException;
import br.com.vininiceto.sistemadegestaodeprojetosedemandas.dto.ProjectRequestDTO;
import br.com.vininiceto.sistemadegestaodeprojetosedemandas.dto.ProjectResponseDTO;
import br.com.vininiceto.sistemadegestaodeprojetosedemandas.model.Project;
import br.com.vininiceto.sistemadegestaodeprojetosedemandas.repository.ProjectRepository;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

import java.time.DateTimeException;
import java.util.Date;
import java.util.List;

@Service
public class ProjectService {


    private final ProjectRepository repository;


    private final ObjectMapper mapper;

    public ProjectService(ProjectRepository repository, ObjectMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }


    public List<ProjectResponseDTO> findAllProjects() {

        List<Project> project = repository.findAll();

        return project.stream().map(p -> mapper.convertValue(p, ProjectResponseDTO.class)).toList();

        //return mapper.convertValue(project, new TypeReference<List<ProjectResponseDTO>>() {
        // });
    }

    public List<ProjectResponseDTO> findByName(String name) {

        List<Project> projects = repository.findByName(name);

        return projects.stream().map(p -> mapper.convertValue(p, ProjectResponseDTO.class)).toList();

    }

    public ProjectResponseDTO createProject(ProjectRequestDTO project) {
        if (project.name().isBlank()) {
            throw new ObjectEmptyException("Field name is required");
        }

        if (!project.endDate().after(new Date())) {
            throw new DateInvalidException("Data final do projeto não pode ser antes da data inicial do projeto");
        }

        Project project1 = new Project();

        project1.setName(project.name());
        project1.setDescription(project.description());
        project1.setEndDate(project.endDate());

        Project saved = repository.save(project1);

        return mapper.convertValue(saved, ProjectResponseDTO.class);
    }


}
