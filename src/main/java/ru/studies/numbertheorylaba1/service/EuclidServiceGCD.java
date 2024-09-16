package ru.studies.numbertheorylaba1.service;

import org.springframework.stereotype.Service;

@Service
public class EuclidServiceGCD implements EuclidService {
    @Override
    public double calculate(double a, double b) {
        if (a == 0)
            return b;
        return calculate(b % a, a);
    }
}
