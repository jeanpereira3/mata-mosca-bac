package com.example.demo.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.entities.Player;
import com.example.demo.service.PlayerService;

@RestController
@RequestMapping(value = "/players")
public class PlayerController {
	
	@Autowired
	private PlayerService service;
	
	@GetMapping
	public Page<Player> findPlayers(Pageable pageable){
		return service.findPlayers(pageable);
	}

	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody Player obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/id").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
}
