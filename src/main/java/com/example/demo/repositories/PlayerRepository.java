package com.example.demo.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
	
	@Query("SELECT obj FROM Player obj ORDER BY obj.score DESC")
	Page<Player> findByScore(Pageable pageable);
}
