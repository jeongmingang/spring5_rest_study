package spring5_rest_study.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import spring5_rest_study.dto.ErrorResponse;
import spring5_rest_study.dto.Member;
import spring5_rest_study.service.GetMemberService;

@RestController
@RequestMapping("/api")
public class RestGetMemberController {
	@Autowired
	private GetMemberService service;
	
	@GetMapping("/members/{id}")
	public ResponseEntity<Object> member (@PathVariable long id, HttpServletResponse response) throws IOException {
		Member member = service.getMember(id);
		if (member == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse("no member"));
		}
		return ResponseEntity.status(HttpStatus.OK).body(member);
	}
}
