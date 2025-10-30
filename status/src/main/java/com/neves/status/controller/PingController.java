package com.neves.status.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@Tag(name = "ping", description = "서버 테스트를 위한 API")
@Log4j2
@RestController
@RequestMapping("/ping")
public class PingController {
	@GetMapping("/2xx")
	public ResponseEntity<String> getSuccess() {
		log.info("(PingController) getSuccess called");
		return new ResponseEntity<>("200 OK: 요청을 성공적으로 처리했습니다.", HttpStatus.OK);
	}

	@GetMapping("/4xx")
	public ResponseEntity<String> getBadRequest() {
		log.info("(PingController) getBadRequest called");
		return new ResponseEntity<>("400 BAD REQUEST: 요청 형식이 잘못되었습니다.", HttpStatus.BAD_REQUEST);
	}

	@GetMapping("/5xx")
	public ResponseEntity<String> getServerErrorByException() {
		log.info("(PingController) getServerErrorByException called");
		return new ResponseEntity<>("500 INTERNAL SERVER ERROR: 서버 내부에서 처리되지 않은 예외가 발생했습니다.", HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
