package br.com.vininiceto.sistemadegestaodeprojetosedemandas.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDate;
import java.util.List;


public record ProjectResponseDTO(String name, String description, @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy") LocalDate startDate, @JsonInclude(JsonInclude.Include.NON_NULL)    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy") LocalDate endDate, List<TaskResponseDTO> tasks) {
}
