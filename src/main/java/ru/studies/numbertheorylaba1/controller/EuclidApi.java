package ru.studies.numbertheorylaba1.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.studies.numbertheorylaba1.config.AppConfig;
import ru.studies.numbertheorylaba1.dto.EuclidRequest;
import ru.studies.numbertheorylaba1.dto.EuclidResponse;
import ru.studies.numbertheorylaba1.service.EuclidFileWorkerService;
import ru.studies.numbertheorylaba1.service.EuclidService;

@RestController
@RequestMapping("/api/euclid")
@RequiredArgsConstructor
public class EuclidApi {
    private final EuclidService euclidService;
    private final EuclidFileWorkerService euclidFileWorkerService;
    private final AppConfig appConfig;

    @PostMapping("/calculate")
    public ResponseEntity<EuclidResponse> calculateGCD(@Valid @RequestBody EuclidRequest request) {
        double calculate = euclidService.calculate(request.getA(), request.getB());
        EuclidResponse euclidResponse = new EuclidResponse(request.getA(), request.getB(), calculate);
        euclidFileWorkerService.writeResponseToFile(appConfig.getFilePath(), euclidResponse);
        return ResponseEntity.ok(euclidResponse);
    }

}
