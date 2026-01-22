package br.com.vininiceto.sistemadegestaodeprojetosedemandas.controller;

import br.com.vininiceto.sistemadegestaodeprojetosedemandas.dto.ProjectRequestDTO;
import br.com.vininiceto.sistemadegestaodeprojetosedemandas.dto.ProjectResponseDTO;
import br.com.vininiceto.sistemadegestaodeprojetosedemandas.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/sistema/gestao/projetos")
public class ProjectController {

    @Autowired
    private ProjectService service;


    @GetMapping("/all")
    public ResponseEntity<List<ProjectResponseDTO>> findAllProjects() {
        return ResponseEntity.ok(service.findAllProjects());
    }

    @GetMapping("/projeto/{name}")
    public ResponseEntity<List<ProjectResponseDTO>> findByNameProject(@PathVariable String name) {
        return ResponseEntity.ok(service.findByName(name));
    }

    @PostMapping("/create")
    public ResponseEntity<ProjectResponseDTO> createProject(@RequestBody ProjectRequestDTO project) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createProject(project));
    }


}
