package br.com.portal.portalbackend.handler;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/post")
public class PostHandler {

	@GetMapping
	public String getAll() {
		return "getAll";
	}
}