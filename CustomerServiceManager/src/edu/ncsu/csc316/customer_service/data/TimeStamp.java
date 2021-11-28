/**
 * 
 */
package edu.ncsu.csc316.customer_service.data;

/**
 * Contains information about the time stamp of a HelpTicket
 * 
 * @author someshherath
 */
public class TimeStamp {

	/**
	 * date of the help ticket
	 */
	private String date;

	/**
	 * time of the help ticket
	 */
	private String time;

	/**
	 * Receives the time stamp of the help ticket and breaks it into date and
	 * time
	 * 
	 * @param stamp
	 *            the date and the time of the help ticket
	 */
	public TimeStamp(String stamp) {
		this.date = stamp.substring(0, 10);

		this.time = stamp.substring(11);
	}

	/**
	 * returns the date
	 * 
	 * @return the date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * returns the time
	 * 
	 * @return the time
	 */
	public String getTime() {
		return time;
	}

	/**
	 * Compares TimeStamps
	 * 
	 * @param t
	 *            TimeStamp to compare this to
	 * @return 0 if equal, >0 if t is later in line, <0 if t is earlier in line
	 */
	public int compareTo(TimeStamp t) {
		if (Integer.parseInt((t.getDate()).substring(6)) > Integer.parseInt(date.substring(6))) {
			return 1;
		} else if (Integer.parseInt((t.getDate()).substring(6)) < Integer.parseInt(date.substring(6))) {
			return -1;
		} else if (Integer.parseInt((t.getDate()).substring(0, 2)) > Integer.parseInt(date.substring(0, 2))) {
			return 1;
		} else if (Integer.parseInt((t.getDate()).substring(0, 2)) < Integer.parseInt(date.substring(0, 2))) {
			return -1;
		} else if (Integer.parseInt((t.getDate()).substring(3, 5)) > Integer.parseInt(date.substring(3, 5))) {
			return 1;
		} else if (Integer.parseInt((t.getDate()).substring(3, 5)) < Integer.parseInt(date.substring(3, 5))) {
			return -1;
		} else if (Integer.parseInt((t.getTime()).substring(0, 2)) > Integer.parseInt(time.substring(0, 2))) {
			return 1;
		} else if (Integer.parseInt((t.getTime()).substring(0, 2)) < Integer.parseInt(time.substring(0, 2))) {
			return -1;
		} else if (Integer.parseInt((t.getTime()).substring(3, 5)) > Integer.parseInt(time.substring(3, 5))) {
			return 1;
		} else if (Integer.parseInt((t.getTime()).substring(3, 5)) < Integer.parseInt(time.substring(3, 5))) {
			return -1;
		}
		if (Integer.parseInt((t.getTime()).substring(6)) > Integer.parseInt(time.substring(6))) {
			return 1;
		} else if (Integer.parseInt((t.getTime()).substring(6)) < Integer.parseInt(time.substring(6))) {
			return -1;
		} else {
			return 0;
		}

	}

}
