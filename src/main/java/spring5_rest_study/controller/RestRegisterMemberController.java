package spring5_rest_study.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import spring5_rest_study.dto.Member;
import spring5_rest_study.exception.DuplicateMemberException;
import spring5_rest_study.service.RegisterMemberService;

@Controller
@RequestMapping("/api")
public class RestRegisterMemberController {
	@Autowired
	private RegisterMemberService service;
	
	@PostMapping("/members/")
	public ResponseEntity<Object> newMember(@RequestBody Member member, Errors errors) {
		if (errors.hasErrors()) {
			return ResponseEntity.badRequest().build();
		}
		try {
			service.registerMember(member);
			
			URI uri = URI.create("/api/mambers/" + member.getId());
			System.out.println("member.getId() > " + member.getId());
			return ResponseEntity.created(uri).body(member.getId());
		}catch (DuplicateMemberException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
	}
}
