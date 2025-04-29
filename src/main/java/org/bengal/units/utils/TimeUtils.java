package org.bengal.units.utils;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class TimeUtils {

	private TimeUtils(){
		//Do nothing
	}

	public static Date getFutureTime(Date initialTime, long millisToAdd) {
		Calendar cal = GregorianCalendar.getInstance();
		cal.setTimeInMillis(initialTime.getTime() + millisToAdd);
		
		return cal.getTime();
	}

	public static String convertToFractionalSecondsStr(long seconds, long millis) {
		return new SecondsAndMillis(seconds, millis).toString();
	}

	public static SecondsAndMillis getTimeDifferenceInSeconds(Date start, Date end) {
		return new SecondsAndMillis(end.getTime() - start.getTime());
	}

	public static class SecondsAndMillis {
		
		public final String sign;
		public final long seconds;
		public final long millis;

		public SecondsAndMillis(long seconds, long millis) {
			this.sign    = "";
			this.seconds = seconds;
			this.millis  = millis;
		}

		public SecondsAndMillis(long millisDuration) {
			this.sign = (millisDuration < 0) ? "-" : "";
			this.seconds = Math.abs(millisDuration / 1000);
			this.millis  = Math.abs(millisDuration % 1000);
		}
		
		@Override
		public String toString() {
			double secsNMillis = seconds + (millis/1000.0);
			String secsStr     = String.format("%.3f", secsNMillis);
			
			return sign + secsStr + " SECONDS";
		}
	}
}
