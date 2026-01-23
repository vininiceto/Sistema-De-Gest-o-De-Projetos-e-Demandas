package br.com.vininiceto.sistemadegestaodeprojetosedemandas.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public record UpdateEndDateProjectRequestDTO(@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy") LocalDate endDate) {
}
