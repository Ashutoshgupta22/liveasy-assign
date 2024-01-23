package com.example.liveasylogisticsassign.controller;

import com.example.liveasylogisticsassign.entity.Load;
import com.example.liveasylogisticsassign.service.LoadService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/load")
public class LoadController {

    private LoadService loadService;

    @PostMapping
    public ResponseEntity<String> addLoad(@RequestBody Load load) {
        loadService.saveLoad(load);
        return ResponseEntity.ok("Load details added successfully");
    }

    @GetMapping
    public ResponseEntity<List<Load>> getLoadsByShipperId(@RequestParam String shipperId) {
        return ResponseEntity.ok(loadService.getLoadsByShipperId(shipperId));
    }

    @GetMapping("/{loadId}")
    public ResponseEntity<Load> getLoad(@PathVariable Long loadId) {
        Load load = loadService.getLoadById(loadId);
        return ResponseEntity.ok(load);
    }

    @PutMapping("/{loadId}")
    public ResponseEntity<Load> updateLoad(@PathVariable Long loadId, @RequestBody Load load) {
        Load updatedLoad = loadService.updateLoad(loadId, load);
        return ResponseEntity.ok(updatedLoad);
    }

    @DeleteMapping("/{loadId}")
    public ResponseEntity<Void> deleteLoad(@PathVariable Long loadId) {
        loadService.deleteLoad(loadId);
        return ResponseEntity.ok().build();
    }
}
