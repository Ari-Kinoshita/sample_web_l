package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Live;
import com.example.demo.repository.LiveRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LiveRegistServiceImple implements LiveRegistService {
	
	private final LiveRepository repository;

	@Override
	public void regist(Live live) {
		
		repository.add(live);

	}

}
