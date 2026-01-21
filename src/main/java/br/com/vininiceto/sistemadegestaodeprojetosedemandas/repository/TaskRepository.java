package br.com.vininiceto.sistemadegestaodeprojetosedemandas.repository;

import br.com.vininiceto.sistemadegestaodeprojetosedemandas.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
