package com.example.commons.security;

import com.example.commons.uri.UriResolver;
import com.example.commons.uri.UsersUriResolver;
import com.example.domain.User;
import com.example.inbounds.rest.dtos.UserResponseDTO;
import lombok.RequiredArgsConstructor;
import org.greyhawk.rest.server.conventions.api.inbounds.rest.dtos.response.simple.SimpleResponseDto;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@RequiredArgsConstructor
@Component
public class CustomUserDetailsService implements UserDetailsService {

	private final RestTemplate restTemplate;
	private final UriResolver uriResolver = new UsersUriResolver();

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		String url = uriResolver.getFindOneUri(username);

		try {
			ResponseEntity<SimpleResponseDto<UserResponseDTO>> response = restTemplate.exchange(url, HttpMethod.GET,
					null, new ParameterizedTypeReference<>() {
					});

			UserResponseDTO user = Objects.requireNonNull(response.getBody()).getData();

			return User.builder().username(user.getUsername()).password(user.getPassword()).build();
		} catch (HttpClientErrorException ex) {
			throw new UsernameNotFoundException(username + " not found!");
		}
	}
}
