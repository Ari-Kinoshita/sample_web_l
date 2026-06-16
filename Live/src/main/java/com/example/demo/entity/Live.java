package com.example.demo.entity;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Live {
	
	private int liveId;
	private Date date;
	private String liveTitle;
	private String place;

}
