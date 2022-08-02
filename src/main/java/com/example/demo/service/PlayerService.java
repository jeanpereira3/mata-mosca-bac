package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Player;
import com.example.demo.repositories.PlayerRepository;

@Service
public class PlayerService {

	@Autowired
	private PlayerRepository repository;
	
	public Page<Player> findPlayers(Pageable pageable){
		return repository.findByScore(pageable);
	}

	public Player insert(Player obj) {
		obj.setId(null);
		return repository.save(obj);
	}
}
