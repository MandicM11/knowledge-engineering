package app.Knowledge_engineering.controller;

import app.Knowledge_engineering.dto.MonitorRequestDTO;
import app.Knowledge_engineering.dto.MonitorResponseDTO;
import app.Knowledge_engineering.service.MonitorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@RestController
@RequestMapping("/api/monitor")
public class MonitorController {
    private final MonitorService monitorService;

    @Autowired
    public MonitorController(MonitorService monitorService) {
        this.monitorService = monitorService;
    }
/*
    @GetMapping
    public ResponseEntity<List<MonitorResponseDTO>> getAllMonitors() {
        return new ResponseEntity<>(this.monitorService.getAllMonitors(), HttpStatus.OK);
    }
*/
}