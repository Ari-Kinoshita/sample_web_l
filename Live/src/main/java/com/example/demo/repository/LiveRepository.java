package com.example.demo.repository;

import java.util.List;

import com.example.demo.entity.Live;

public interface LiveRepository {

	void add(Live live);
	
	List<Live> selectByliveId(int liveTitle);
	
}
