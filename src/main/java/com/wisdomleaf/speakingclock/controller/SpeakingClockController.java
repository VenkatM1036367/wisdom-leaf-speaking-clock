package com.wisdomleaf.speakingclock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.wisdomleaf.speakingclock.service.SpeakingClockService;

@RestController
public class SpeakingClockController {
	
	@Autowired
	private SpeakingClockService speakingClockService;

	@GetMapping("/getTime")
	public ResponseEntity<String> getCurrentTimeSpeaking() {
		String s = speakingClockService.getCurrentTimeInWords();
		return new ResponseEntity<String>(s, HttpStatus.OK);
	}
	
	@GetMapping("/getTime/{time}")
	public ResponseEntity<String> getTimeSpeaking(@PathVariable String time) {
		String s = speakingClockService.getTimeInWords(time);
		return new ResponseEntity<String>(s, HttpStatus.OK);
	}
}
