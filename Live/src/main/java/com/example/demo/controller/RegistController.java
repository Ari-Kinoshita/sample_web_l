package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entity.Live;
import com.example.demo.form.LiveRegistForm;
import com.example.demo.service.LiveRegistService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class RegistController {
	
	private final LiveRegistService service;
	
	/*--- トップ画面表示 ---*/
	@GetMapping("/live-top")
	private String ShowTop() {
		return "top-list";
	}
	
	/*--- ライブ登録画面表示 ---*/
	@PostMapping("/show-live-form")
	public String liveShowRegist(@ModelAttribute LiveRegistForm form) {
		return "live-regist";
	}
	
	/*--- 登録リクエスト（登録画面より） ---*/
	@PostMapping("/regist-live")
	public String RegistLive(
		@Validated @ModelAttribute LiveRegistForm form,
		BindingResult result ) {

		if (result.hasErrors()) {
			return "live-regist";			// 入力がエラーの場合
		}

		return "confirm-regist-live";		// 入力が正常の場合
	}

	/*--- 登録リクエスト（登録確認画面より） ---*/
	@PostMapping("/confirm-regist-live")
	public String ConfirmRegist(
			@Validated @ModelAttribute LiveRegistForm form,
			BindingResult result,
			RedirectAttributes redirectAttributes ) {

		if (result.hasErrors()) {
			return "live-regist";			// 入力がエラーの場合
		}

		Live live = new Live();
		live.setDate(form.getDate());
		live.setLiveTitle(form.getLiveTitle());
		live.setPlace(form.getPlace());

		service.regist(live);
			
		redirectAttributes.addFlashAttribute("msg", "(ライブ登録)");
			
		return "redirect:/complete";
	}

}
