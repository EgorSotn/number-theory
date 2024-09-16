package ru.studies.numbertheorylaba1.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EuclidResponse {
    private Double a;
    private Double b;
    private Double res;
}
