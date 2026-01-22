package br.com.vininiceto.sistemadegestaodeprojetosedemandas.repository;

import br.com.vininiceto.sistemadegestaodeprojetosedemandas.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProjectRepository extends JpaRepository<Project, Long> {

    @Query("SELECT p FROM Project p WHERE p.name = :name")
    List<Project> findByName(String name);

    @Query("SELECT p FROM Project p WHERE p.id = :id")
    Optional<Project> findProjectById(Long id);
}
