package br.com.vininiceto.sistemadegestaodeprojetosedemandas.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.Date;

public record ProjectDTO(@Size(min = 3, max = 100) @NotBlank(message = "Field name is required")String name, String description,@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy") Date endDate){}

