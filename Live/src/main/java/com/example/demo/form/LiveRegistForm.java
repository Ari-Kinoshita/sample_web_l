package com.example.demo.form;

import java.sql.Date;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import lombok.Data;

@Data
public class LiveRegistForm {
	@NotNull(message="選択してください。")
	private Date date;
	
	@Size(min=1, message="入力してください。")
	private String liveTitle;

	@NotNull(message="入力してください。")
	private String place;
}
