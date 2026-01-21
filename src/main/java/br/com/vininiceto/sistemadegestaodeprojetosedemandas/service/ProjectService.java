package br.com.vininiceto.sistemadegestaodeprojetosedemandas.service;

import br.com.vininiceto.sistemadegestaodeprojetosedemandas.Exceptions.handler.ObjectNullException;
import br.com.vininiceto.sistemadegestaodeprojetosedemandas.Exceptions.handler.ObjectEmptyException;
import br.com.vininiceto.sistemadegestaodeprojetosedemandas.model.Project;
import br.com.vininiceto.sistemadegestaodeprojetosedemandas.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository repository;

    public Optional<Project> findProjectById(Long id) {
        return Optional.of(repository.findById(id).orElseThrow(() -> new ObjectNullException("Id informado inválido!")));
    }

    public List<Project> findAllProjects() {
        return repository.findAll();
    }

    public Project createProject(Project project) {
        if (project.getName().isBlank()) {
            throw new ObjectEmptyException("Field name is required");
        }


        return repository.save(project);
    }


}
