package com.wisdomleaf.speakingclock.utils;

import org.springframework.stereotype.Component;

import com.wisdomleaf.speakingclock.exception.WrongTimeFormatException;

@Component
public class TimeToWordsUtils {

	String[] single_digits = new String[] { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight",
			"nine" };

	String[] two_digits = new String[] { "", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen",
			"seventeen", "eighteen", "nineteen" };

	String[] tens_multiple = new String[] { "", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty",
			"Ninety" };
	String[] powOfTens = new String[] { "Hundred", "Thousand" };

	public String timeToWords(char[] hours, char[] min) {
		StringBuilder timeInWords = new StringBuilder("It's ");
		int hoursLength = hours.length;
		int minutesLength = min.length;
		if (hoursLength == 0 && minutesLength == 0) {
			throw new WrongTimeFormatException("Input time is empty");
		}
		if (hoursLength > 2 || minutesLength > 2) {
			throw new WrongTimeFormatException("Input time is formate is wrong");
		}

		if (Integer.valueOf(new String(hours)) < 24) {
			hoursInWords(hours, hoursLength, timeInWords);
		}
		if (Integer.valueOf(new String(min)) < 60) {
			minutesInWords(min, minutesLength, timeInWords);
		}
		if (Integer.valueOf(new String(hours)) == 24 && Integer.valueOf(new String(min)) == 60) {
			timeInWords.append("midnight");
		}
		return timeInWords.toString();
	}

	private void minutesInWords(char[] min, int minutesLength, StringBuilder timeInWords) {
		if (minutesLength == 1) {
			timeInWords.append(single_digits[min[0] - '0']).append(" minutes.");
		} else {
			numberInWords(min, minutesLength, timeInWords);
			timeInWords.append(" minutes.");
		}
	}

	private void hoursInWords(char[] hours, int hoursLength, StringBuilder timeInWords) {
		if (hoursLength == 1) {
			timeInWords.append(single_digits[hours[0] - '0']).append(" hours ");
		} else {
			numberInWords(hours, hoursLength, timeInWords);
			timeInWords.append(" hours ");
		}
	}

	private void numberInWords(char[] numbers, int numLength, StringBuilder timeInWords) {
		int p = 0;
		while (p < numbers.length) {
			if (numLength >= 3) {
				if (numbers[p] - '0' != 0) {
					timeInWords.append(single_digits[numbers[p] - '0'] + " ");
					timeInWords.append(powOfTens[numLength - 3] + " ");
				}
				--numLength;
			} else {
				if (numbers[p] - '0' == 1) {
					int sum = numbers[p] - '0' + numbers[p + 1] - '0';
					timeInWords.append(two_digits[sum]);
					return;
				} else if (numbers[p] - '0' == 2 && numbers[p + 1] - '0' == 0) {
					timeInWords.append("Twenty");
					return;
				} else {
					int i = (numbers[p] - '0');
					if (i > 0)
						timeInWords.append(tens_multiple[i] + " ");
					else
						timeInWords.append("");
					++p;
					if (numbers[p] - '0' != 0)
						timeInWords.append(single_digits[numbers[p] - '0']);
				}
			}
			++p;
		}
	}
}
