package org.moussaud.sb.secretagent.api;

import java.util.List;
import java.util.stream.Collectors;

import org.moussaud.sb.secretagent.domain.EnvironmentResponse;
import org.moussaud.sb.secretagent.domain.EnvironmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.transaction.annotation.Transactional;

@RestController
@RequestMapping("/api/env")
@CrossOrigin
public class EnvironmentController {

    private final EnvironmentService service;

    public EnvironmentController(EnvironmentService service) {
        this.service = service;
    }

    @GetMapping("/")
    @Transactional(readOnly = true)
    public ResponseEntity<List<EnvironmentResponse>> getAll() {
        List<EnvironmentResponse> all = service.getAll().collect(Collectors.toList());
        return ResponseEntity.ok(all);
    }
}
