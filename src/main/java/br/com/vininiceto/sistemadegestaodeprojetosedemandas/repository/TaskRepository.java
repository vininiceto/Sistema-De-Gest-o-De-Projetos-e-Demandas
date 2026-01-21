package br.com.vininiceto.sistemadegestaodeprojetosedemandas.repository;

import br.com.vininiceto.sistemadegestaodeprojetosedemandas.model.Enums.TaskPriority;
import br.com.vininiceto.sistemadegestaodeprojetosedemandas.model.Enums.TaskStatus;
import br.com.vininiceto.sistemadegestaodeprojetosedemandas.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    @Query("SELECT t FROM Task t WHERE t.status = :status AND t.priority = :priority AND t.project.id = :projectId")
    List<Task> findTaskByParams(@Param("status") TaskStatus status,
                                @Param("priority") TaskPriority priority, @Param("projectId") Long projectId);







}
