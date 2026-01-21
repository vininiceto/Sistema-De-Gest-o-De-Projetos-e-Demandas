package br.com.vininiceto.sistemadegestaodeprojetosedemandas.repository;

import br.com.vininiceto.sistemadegestaodeprojetosedemandas.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
