package br.com.vininiceto.sistemadegestaodeprojetosedemandas.dto;

import br.com.vininiceto.sistemadegestaodeprojetosedemandas.model.Enums.TaskStatus;


public record UpdateTaskStatusRequestDTO(TaskStatus status) {


}
