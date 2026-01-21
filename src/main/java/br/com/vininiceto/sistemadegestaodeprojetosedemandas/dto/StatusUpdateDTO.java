package br.com.vininiceto.sistemadegestaodeprojetosedemandas.dto;

import br.com.vininiceto.sistemadegestaodeprojetosedemandas.model.Enums.TaskStatus;
import lombok.Data;

@Data
public class StatusUpdateDTO {

    private TaskStatus status;
}
