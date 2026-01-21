package br.com.vininiceto.sistemadegestaodeprojetosedemandas.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.List;

@Entity(name = "Project")
@Data
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Field name is required")
    @Size(min = 3, max = 100)
    private String name;
    private String descrption;
    @CreationTimestamp
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private Date startDate;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private Date endDate;
    @OneToMany(mappedBy = "project")
    private List<Task> tasks;


}
