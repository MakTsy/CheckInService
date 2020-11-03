package com.checkin.demo.repo;


import com.checkin.demo.entities.BoardingPass;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BoardingPassRepository extends JpaRepository<BoardingPass, UUID> {
}
