package io.simpolor.logback.controller;

import io.simpolor.logback.component.SlackSender;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("/slack")
@RestController
@RequiredArgsConstructor
public class SlackController {

	private final SlackSender slackSender;

	@PostMapping("")
	public String slack() {

		return slackSender.send();
	}
}
