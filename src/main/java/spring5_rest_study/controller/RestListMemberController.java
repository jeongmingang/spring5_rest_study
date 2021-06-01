package spring5_rest_study.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import spring5_rest_study.dto.ErrorResponse;
import spring5_rest_study.dto.Member;
import spring5_rest_study.service.MemberListService;

@RestController
@RequestMapping("/api")
public class RestListMemberController {
	@Autowired
	private MemberListService service;
	
	@GetMapping("/members")
	public ResponseEntity<Object> member (HttpServletResponse response) {
		List<Member> member = service.getLists();
		if (member == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse("no member"));
		}
		return ResponseEntity.status(HttpStatus.OK).body(member);
	}
}
