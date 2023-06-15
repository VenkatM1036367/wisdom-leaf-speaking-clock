package com.wisdomleaf.speakingclock.service;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wisdomleaf.speakingclock.exception.WrongTimeFormatException;
import com.wisdomleaf.speakingclock.utils.TimeToWordsUtils;

@Service
public class SpeakingClockServiceImpl implements SpeakingClockService {

	@Autowired
	private TimeToWordsUtils timeToWordsUtils;

	public String getCurrentTimeInWords() {
		Calendar now = Calendar.getInstance();
		int hours = now.get(Calendar.HOUR_OF_DAY);
		int minuts = now.get(Calendar.MINUTE);
		return timeToWordsUtils.timeToWords(Integer.toString(hours).toCharArray(),
				Integer.toString(minuts).toCharArray());
	}

	public String getTimeInWords(String time) {
		if (!time.contains(":")) {
			throw new WrongTimeFormatException("time should seperate with : ");
		}
		String[] timeminuts = time.split(":", 2);
		return timeToWordsUtils.timeToWords(timeminuts[0].toCharArray(), timeminuts[1].toCharArray());
	}
}
