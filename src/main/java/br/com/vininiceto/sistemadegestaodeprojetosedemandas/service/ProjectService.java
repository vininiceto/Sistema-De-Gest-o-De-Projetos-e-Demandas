package br.com.vininiceto.sistemadegestaodeprojetosedemandas.service;

import br.com.vininiceto.sistemadegestaodeprojetosedemandas.Exceptions.handler.RequiredObjectEmptyException;
import br.com.vininiceto.sistemadegestaodeprojetosedemandas.model.Project;
import br.com.vininiceto.sistemadegestaodeprojetosedemandas.repository.ProjectRepository;
import jakarta.validation.constraints.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository repository;

    public Optional<Project> findProjectById(Long id) {
        return Optional.of(repository.findById(id).orElseThrow(() -> new NullPointerException("Id informado inválido!")));
    }

    public List<Project> findAllProjects() {
        return repository.findAll();
    }

    public Project createProject(Project project){
        Project p1 = new Project();
        if(project.getName().isBlank()){
            throw new RequiredObjectEmptyException("Field name is required");
        }
        p1.setName(project.getName());
        p1.setDescrption(project.getDescrption());
        p1.setStartDate(project.getStartDate());
        p1.setEndDate(project.getEndDate());
        return repository.save(p1);
    }



}
