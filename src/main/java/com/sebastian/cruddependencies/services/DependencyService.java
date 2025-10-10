package com.sebastian.cruddependencies.services;

import com.sebastian.cruddependencies.Dependency;

import com.sebastian.cruddependencies.dto.DependencyRequest;
import com.sebastian.cruddependencies.repositories.DependencyRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class DependencyService {
    private final DependencyRepository dependencyRepository;

    public DependencyService(DependencyRepository dependencyRepository) {
        this.dependencyRepository = dependencyRepository;
    }

    public List<Dependency> getAllDependencies() {
        return dependencyRepository.findAll();
    }

    public Page<Dependency> getDependencies(Pageable pageable) {
        return dependencyRepository.findAll(pageable);
    }

    public Dependency insertDependency(Dependency dependency) {
        if (dependencyRepository.existsByTelephone(dependency.getTelephone())) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Telephone already exists"
            );
        }
        if (dependencyRepository.existsByEmail(dependency.getEmail())) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Email already exists"
            );
        }
        return dependencyRepository.save(dependency);
    }

    public Dependency getDependencyById(Integer id) {
        return dependencyRepository.findById(id).orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND , "Dependency with id " + id + " not found"));
    }

    public Dependency updateDependency(Integer id, DependencyRequest request) {
        Dependency existing = dependencyRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Dependency with id " + id + " not found"));

        boolean isTelephoneTaken = dependencyRepository.existsByTelephone(request.getTelephone()) &&
                !existing.getTelephone().equals(request.getTelephone());

        if (isTelephoneTaken) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Telephone already exists"
            );
        }

        boolean isEmailTaken = dependencyRepository.existsByEmail(request.getEmail()) &&
                !existing.getEmail().equals(request.getEmail());

        if (isEmailTaken) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Email already exists"
            );
        }

        existing.setName(request.getName());
        existing.setAddress(request.getAddress());
        existing.setEmail(request.getEmail());
        existing.setTelephone(request.getTelephone());
        existing.setAcronym(request.getAcronym());

        return dependencyRepository.save(existing);
    }

    public Dependency updateStatus(Integer id, boolean isActive) {
        Dependency dependency = dependencyRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Dependency with id " + id + " not found"));
        dependency.setIs_active(isActive);
        return dependencyRepository.save(dependency);
    }


}
