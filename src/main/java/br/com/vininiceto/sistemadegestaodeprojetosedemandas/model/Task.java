package br.com.vininiceto.sistemadegestaodeprojetosedemandas.model;

import br.com.vininiceto.sistemadegestaodeprojetosedemandas.model.Enums.TaskPriority;
import br.com.vininiceto.sistemadegestaodeprojetosedemandas.model.Enums.TaskStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Date;

@Entity(name = "Task")
@Data
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(min = 5, max = 150)
    @NotBlank(message = "Field title is required!")
    private String title;
    private String description;
    private TaskStatus status;
    private TaskPriority priority;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dueDate;
    @ManyToOne
    @JoinColumn(name = "projectId")
    private Project project;

}
