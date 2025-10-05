package com.sebastian.cruddependencies.repositories;

import com.sebastian.cruddependencies.Dependency;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DependencyRepository extends JpaRepository<Dependency, Integer> {

}
