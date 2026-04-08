package org.example.gymnasticsscore.repository;

import org.example.gymnasticsscore.model.Meet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeetRepository extends JpaRepository<Meet,Long> {
}
