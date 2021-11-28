/**
 * 
 */
package edu.ncsu.csc316.customer_service.data;

/**
 * Holds information about a help ticket
 * 
 * @author someshherath
 */
public class HelpTicket {

	/**
	 * priority of the help ticket
	 */
	private int priority;
	/**
	 * first name of the customer
	 */
	private String first;
	/**
	 * last name of the customer
	 */
	private String last;
	/**
	 * the question stated in the help ticket
	 */
	private String question;
	/**
	 * the time information of the ticket
	 */
	private TimeStamp stamp;

	/**
	 * Constructs a HelpTicket
	 * 
	 * @param priority
	 *            priority of the help ticket
	 * @param first
	 *            first name of the customer
	 * @param last
	 *            last name of the customer
	 * @param question
	 *            the question stated in the help ticket
	 */
	public HelpTicket(int priority, String first, String last, String question, String stamp) {
		this.priority = priority;
		this.first = first;
		this.last = last;
		this.question = question;
		this.stamp = new TimeStamp(stamp);
	}

	/**
	 * returns the priority
	 * 
	 * @return the priority
	 */
	public int getPriority() {
		return priority;
	}

	/**
	 * returns the first name
	 * 
	 * @return the first
	 */
	public String getFirst() {
		return first;
	}

	/**
	 * returns the last name
	 * 
	 * @return the last
	 */
	public String getLast() {
		return last;
	}

	/**
	 * returns the question asked in the help ticket
	 * 
	 * @return the question
	 */
	public String getQuestion() {
		return question;
	}

	/**
	 * returns the TimeStamp of the help ticket
	 * 
	 * @return the TimeStamp
	 */
	public TimeStamp getTimeStamp() {
		return stamp;
	}

	/**
	 * Compares HelpTickets by place in line
	 * 
	 * @param c
	 *            HelpTicket to compare this to
	 * @return 0 if equal, >0 if c is later in line, <0 if earlier in line
	 */
	public int compareByPlaceInLine(HelpTicket c) {
		if (c.getPriority() < this.getPriority()) {
			return 1;
		} else if (c.getPriority() > this.getPriority()) {
			return -1;
		} else if (stamp.compareTo(c.getTimeStamp()) != 0) {
			return stamp.compareTo(c.getTimeStamp());
		} else {
			return this.compareByCustomer(c);
		}
	}

	/**
	 * Compares HelpTickets by Customer names
	 * 
	 * @param c
	 *            HelpTicket to compare this to
	 * @return 0 if equal, >0 if c is later in line, <0 if c is earlier in line
	 */
	public int compareByCustomer(HelpTicket c) {
		String thisName = this.getLast() + " " + this.getFirst();
		String CName = c.getLast() + " " + c.getFirst();
		return thisName.compareTo(CName);
	}

	/**
	 * Returns a string version of HelpTicket
	 * 
	 * @return HelpTicket in string form
	 */
	@Override
	public String toString() {
		return "Priority " + getPriority() + ": submitted at " + getTimeStamp().getDate() + " "
				+ getTimeStamp().getTime() + " by " + getFirst() + " " + getLast() + ", Question: " + getQuestion();

	}
}
