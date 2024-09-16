package ru.studies.numbertheorylaba1.controller.spa;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.studies.numbertheorylaba1.config.AppConfig;
import ru.studies.numbertheorylaba1.dto.EuclidRequest;
import ru.studies.numbertheorylaba1.service.EuclidFileWorkerService;

@Controller
@RequiredArgsConstructor
public class EuclidController {
    private final EuclidFileWorkerService euclidFileWorkerService;
    private final AppConfig appConfig;

    @GetMapping("/")
    public String indexPage() {
        return "index";
    }

    @GetMapping("/euclid")
    public String euclidPage(Model model) {
        EuclidRequest euclidRequest = euclidFileWorkerService.readRequestFromFile(appConfig.getFilePath());
        model.addAttribute("euclidRequest", euclidRequest);
        return "euclid";
    }
}
