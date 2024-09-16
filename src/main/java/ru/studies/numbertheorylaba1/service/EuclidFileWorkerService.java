package ru.studies.numbertheorylaba1.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
import ru.studies.numbertheorylaba1.dto.EuclidRequest;
import ru.studies.numbertheorylaba1.dto.EuclidResponse;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Component
@RequiredArgsConstructor
public class EuclidFileWorkerService {
    private final ObjectMapper objectMapper = new ObjectMapper();

    public EuclidRequest readRequestFromFile(String filePath) {
        try (BufferedReader br = Files.newBufferedReader(Paths.get(filePath))) {
            return br.lines().map(l -> {
                        try {
                            EuclidResponse euclidResponse = objectMapper.readValue(l, EuclidResponse.class);
                            return new EuclidRequest(euclidResponse.getA(), euclidResponse.getB());
                        } catch (JsonProcessingException e) {
                            throw new RuntimeException(e);
                        }
                    })
                    .findAny().orElse(new EuclidRequest());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void writeResponseToFile(String filePath, EuclidResponse response) {
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(filePath))) {
            writer.write(objectMapper.writeValueAsString(response));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
