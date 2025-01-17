package ru.studies.numbertheorylaba1.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EuclidRequest {
    @NotNull
    private Double a;
    @NotNull
    private Double b;
}
