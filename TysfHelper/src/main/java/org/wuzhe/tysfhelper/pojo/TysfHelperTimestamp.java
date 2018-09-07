package org.wuzhe.tysfhelper.pojo;

import java.sql.Timestamp;

public class TysfHelperTimestamp extends Timestamp {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    
	@SuppressWarnings("deprecation")
	public TysfHelperTimestamp(int year, int month, int date, int hour, int minute, int second, int nano) {
		super(year, month, date, hour, minute, second, nano);
	}
    
	public TysfHelperTimestamp(long time) {
		super(time);
	}

	@Override
	public String toString() {
		 @SuppressWarnings("deprecation")
		int year = super.getYear() + 1900;
	        @SuppressWarnings("deprecation")
			int month = super.getMonth() + 1;
	        @SuppressWarnings("deprecation")
			int day = super.getDate();
	        @SuppressWarnings("deprecation")
			int hour = super.getHours();
	        @SuppressWarnings("deprecation")
			int minute = super.getMinutes();
	        @SuppressWarnings("deprecation")
			int second = super.getSeconds();
	        String yearString;
	        String monthString;
	        String dayString;
	        String hourString;
	        String minuteString;
	        String secondString;
	        String yearZeros = "0000";
	        StringBuffer timestampBuf;

	        if (year < 1000) {
	            // Add leading zeros
	            yearString = "" + year;
	            yearString = yearZeros.substring(0, (4-yearString.length())) +
	                yearString;
	        } else {
	            yearString = "" + year;
	        }
	        if (month < 10) {
	            monthString = "0" + month;
	        } else {
	            monthString = Integer.toString(month);
	        }
	        if (day < 10) {
	            dayString = "0" + day;
	        } else {
	            dayString = Integer.toString(day);
	        }
	        if (hour < 10) {
	            hourString = "0" + hour;
	        } else {
	            hourString = Integer.toString(hour);
	        }
	        if (minute < 10) {
	            minuteString = "0" + minute;
	        } else {
	            minuteString = Integer.toString(minute);
	        }
	        if (second < 10) {
	            secondString = "0" + second;
	        } else {
	            secondString = Integer.toString(second);
	        }
	        // do a string buffer here instead.
	        timestampBuf = new StringBuffer(20);
	        timestampBuf.append(yearString);
	        timestampBuf.append("-");
	        timestampBuf.append(monthString);
	        timestampBuf.append("-");
	        timestampBuf.append(dayString);
	        timestampBuf.append(" ");
	        timestampBuf.append(hourString);
	        timestampBuf.append(":");
	        timestampBuf.append(minuteString);
	        timestampBuf.append(":");
	        timestampBuf.append(secondString);

	        return (timestampBuf.toString());
	}
	

}
