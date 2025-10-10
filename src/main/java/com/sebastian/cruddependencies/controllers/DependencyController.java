package com.sebastian.cruddependencies.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sebastian.cruddependencies.Dependency;
import com.sebastian.cruddependencies.dto.DependencyRequest;
import com.sebastian.cruddependencies.services.DependencyService ;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1/dependencies")
@Tag(name="Dependency management", description = "CRUD operations for dependencies")
public class DependencyController {

    private final DependencyService dependencyService;

    public DependencyController(DependencyService dependencyService) {
        this.dependencyService = dependencyService;
    }

    @Operation(summary = "List all dependencies", description = "Retrieve a complete list of all software dependencies.")
    @GetMapping
    public ResponseEntity<List<Dependency>> getAllDependencies() {
        List<Dependency> dependencies = dependencyService.getAllDependencies();
        return ResponseEntity.ok(dependencies);
    }

    @Operation(summary = "List dependencies with pagination", description = "Retrieve a paginated list of dependencies.")
    @GetMapping("pagination")
    public Page<Dependency> getDependencies(Pageable pageable) {
        return dependencyService.getDependencies(pageable);
    }

    @Operation(summary = "Get dependency by ID", description = "Retrieve a single dependency by its unique ID.")
    @GetMapping("{id}")
    public Dependency getDependencyById(@PathVariable Integer id) {
        return dependencyService.getDependencyById(id);
    }

    @Operation(summary = "Create a new dependency", description = "Add a new software dependency to the system.")
    @PostMapping
    public ResponseEntity<Map<String, Object>> addNewDependency(@Valid @RequestBody DependencyRequest dependencyRequest) {
        Dependency dependency = new Dependency(dependencyRequest.getName(), dependencyRequest.getAddress(), dependencyRequest.getEmail(), dependencyRequest.getTelephone(),dependencyRequest.getAcronym());
        Dependency saved = dependencyService.insertDependency(dependency);

        Map<String, Object> response = new HashMap<>();
        response.put("message", "Dependency added successfully");
        response.put("data", saved);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Operation(summary = "Update a dependency", description = "Update the information of an existing dependency.")
    @PutMapping("{id}")
    public ResponseEntity<Map<String, Object>> updateDependency(
            @PathVariable Integer id,
            @Valid @RequestBody DependencyRequest dependencyRequest) {

        Dependency updated = dependencyService.updateDependency(id, dependencyRequest);

        Map<String, Object> response = new HashMap<>();
        response.put("message", "Dependency updated successfully");
        response.put("data", updated);

        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Update dependency status", description = "Activate or deactivate a dependency.")
    @PatchMapping("{id}/status")
    public ResponseEntity<Map<String, Object>> updateStatus(
            @PathVariable Integer id,
            @RequestParam boolean isActive) {

        Dependency updated = dependencyService.updateStatus(id, isActive);

        Map<String, Object> response = new HashMap<>();
        response.put("message", "Dependency status updated successfully");
        response.put("data", updated);
        return ResponseEntity.ok(response);
    }


}
