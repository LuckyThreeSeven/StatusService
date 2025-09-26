package com.neves.status.config;

import com.neves.status.utils.RequestContextHolder;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import org.springframework.stereotype.Component;

@Component
public class RequestTimeFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		RequestContextHolder.set(LocalDateTime.now());
		try {
			chain.doFilter(request, response);
		} finally {
			RequestContextHolder.clear();
		}
	}
}
