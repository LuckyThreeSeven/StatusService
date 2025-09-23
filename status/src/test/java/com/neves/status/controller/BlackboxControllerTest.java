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
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
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

	private static final String BASE_URL = "/blackboxes";

	@BeforeEach
	void setUp() {
		blackboxRepository.deleteAll();
	}

	@Test
	@DisplayName("블랙박스 등록 성공")
	void registerBlackboxSuccess() throws Exception {
		//given
		String nickname = "my blackbox";
		BlackboxRegisterRequestDto requestDto = new BlackboxRegisterRequestDto(TestUtils.DEFAULT_UUID, nickname);
		String requestBody = objectMapper.writeValueAsString(requestDto);

		//when
		mockMvc.perform(post(BASE_URL)
						.header(JwtUtils.JWT_HEADER, TestUtils.DEFAULT_JWT)
						.contentType(MediaType.APPLICATION_JSON)
						.content(requestBody))
				.andExpect(status().isOk());

		//then
		Blackbox savedBlackbox = blackboxRepository.findByUuid(TestUtils.DEFAULT_UUID).orElse(null);
		Assertions.assertThat(savedBlackbox).isNotNull();
		Assertions.assertThat(savedBlackbox.getNickname()).isEqualTo(nickname);
		Assertions.assertThat(savedBlackbox.getUserId()).isEqualTo(TestUtils.TEST_USER_ID);
		Assertions.assertThat(savedBlackbox.getUuid()).isEqualTo(TestUtils.DEFAULT_UUID);
	}
}