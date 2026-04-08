package org.example.gymnasticsscore.repository;

import org.example.gymnasticsscore.model.Gym;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GymRepository extends JpaRepository<Gym,Long> {
}
