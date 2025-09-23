package com.neves.status.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.neves.status.controller.dto.blackbox.BlackboxRegisterRequestDto;
import com.neves.status.repository.Blackbox;
import com.neves.status.repository.BlackboxRepository;
import com.neves.status.utils.JwtUtils;
import com.neves.status.utils.TestUtils;
import jakarta.transaction.Transactional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.TestAnnotationUtils;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class BlackboxControllerTest {
	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private ObjectMapper objectMapper;
	@Autowired
	private BlackboxRepository blackboxRepository;

	@BeforeEach
	void setUp() {
		blackboxRepository.deleteAll();
	}

	@Test
	@DisplayName("블랙박스 등록 성공")
	void register_integration_success() throws Exception {
		// given - 테스트에 필요한 요청 DTO 생성
		BlackboxRegisterRequestDto requestDto = new BlackboxRegisterRequestDto(TestUtils.DEFAULT_UUID, "my blackbox");
		String requestBody = objectMapper.writeValueAsString(requestDto);

		mockMvc.perform(post("/blackboxes")
						.header(JwtUtils.JWT_HEADER, TestUtils.DEFAULT_JWT)
						.contentType(MediaType.APPLICATION_JSON)
						.content(requestBody))
				.andExpect(status().isOk()) // 200 OK 응답을 기대
				.andDo(print());

		// then - DB에 블랙박스가 정상적으로 저장되었는지 검증
		Blackbox savedBlackbox = blackboxRepository.findByUuid(TestUtils.DEFAULT_UUID).orElse(null);
		Assertions.assertThat(savedBlackbox).isNotNull();
		Assertions.assertThat(savedBlackbox.getNickname()).isEqualTo("my blackbox");
		Assertions.assertThat(savedBlackbox.getUserId()).isEqualTo(TestUtils.TEST_USER_ID);
		Assertions.assertThat(savedBlackbox.getUuid()).isEqualTo(TestUtils.DEFAULT_UUID);
	}
}