package com.example.demo.repository;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Live;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class LiveRepositoryImpl implements LiveRepository {

	private final JdbcTemplate jdbcTemplate;

	@Override
	public void add(Live live) {

		String sql = " INSERT INTO t_live " +
				" (date, live_title, place) " +
				" VALUES (?, ?, ?) ";

		jdbcTemplate.update(sql,
				live.getDate(),
				live.getLiveTitle(),
				live.getPlace());

	}

	@Override
	public List<Live> selectByliveId(int liveId) {

		String sql = 
				"  SELECT            " +
				"    date,           " +
				"    live_title,     " +
				"    place,          " +
				"  FROM              " +
				"    t_live          " +
				"  WHERE             " +
				"    live_id = ?     " +
				"  ORDER BY          " +
				"    date DESC,      ";

	}

}
