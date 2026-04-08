package org.example.gymnasticsscore.repository;

import org.example.gymnasticsscore.model.Gymnast;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GymnastRepository extends JpaRepository<Gymnast,Long> {
}
