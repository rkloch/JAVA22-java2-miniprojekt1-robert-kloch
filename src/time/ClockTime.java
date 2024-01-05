package time;

import java.util.Calendar;
import java.util.Date;

public class ClockTime {
	int hour;
	int minutes;
	int seconds;

	public ClockTime() {
		java.util.Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		hour = cal.get(Calendar.HOUR);
		minutes = cal.get(Calendar.MINUTE);
		seconds = cal.get(Calendar.SECOND);
	}

	public void displayTime() {

		System.out.println((hour < 10 ? "0" : "") + hour + ":" + (minutes < 10 ? "0" : "") + minutes + ":"
				+ (seconds < 10 ? "0" : "") + seconds);

	}

	public void setTime(int hour, int minutes, int seconds) {
		this.hour = hour;
		this.minutes = minutes;
		this.seconds = seconds;
	}
}
