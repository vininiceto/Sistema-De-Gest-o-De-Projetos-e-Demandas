package br.com.vininiceto.sistemadegestaodeprojetosedemandas.dto;

import br.com.vininiceto.sistemadegestaodeprojetosedemandas.model.Enums.TaskPriority;
import br.com.vininiceto.sistemadegestaodeprojetosedemandas.model.Enums.TaskStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record TaskRequestDTO(@Size(min = 5, max = 150) @NotBlank() String title, String description, TaskStatus status,
                             TaskPriority priority,
                             @JsonInclude(JsonInclude.Include.NON_NULL) @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy") LocalDate dueDate) {
}
