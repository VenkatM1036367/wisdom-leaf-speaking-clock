package com.wisdomleaf.speakingclock.service;

import org.springframework.stereotype.Service;

@Service
public interface SpeakingClockService {
	
	public String getCurrentTimeInWords();
	public String getTimeInWords(String time);
}
