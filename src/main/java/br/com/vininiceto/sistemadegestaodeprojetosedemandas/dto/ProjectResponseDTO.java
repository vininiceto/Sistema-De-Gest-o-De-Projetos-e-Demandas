package br.com.vininiceto.sistemadegestaodeprojetosedemandas.dto;

import br.com.vininiceto.sistemadegestaodeprojetosedemandas.model.Task;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;


public record ProjectResponseDTO(String name, String description, @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy") Date startDate,    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy") Date endDate, List<TaskResponseDTO> tasks) {
}
