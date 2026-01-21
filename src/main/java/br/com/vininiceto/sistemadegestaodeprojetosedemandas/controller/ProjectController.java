package br.com.vininiceto.sistemadegestaodeprojetosedemandas.controller;

import br.com.vininiceto.sistemadegestaodeprojetosedemandas.model.Project;
import br.com.vininiceto.sistemadegestaodeprojetosedemandas.service.ProjectService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/sistema/gestao/projetos")
public class ProjectController {

    @Autowired
    private ProjectService service;

    @GetMapping("/all")
    public ResponseEntity<List<Project>> findAllProjects(){
        return ResponseEntity.ok(service.findAllProjects());
    }

    @PostMapping("/create")
    public ResponseEntity<Project> createProject(@RequestBody Project project){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createProject(project));
    }




}
