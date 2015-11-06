
package org.exparity.hamcrest.date;

import java.util.Calendar;
import java.util.Date;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;

/**
 * A matcher that tests that the examined date is on the same minute as the reference date
 * 
 * @author Stewart Bissett
 */
public class IsSameMinute extends IsSameDatePart {

	public IsSameMinute(final Date date) {
		super(date, Calendar.MINUTE, "minute", "m");
	}

	public IsSameMinute(final int minute) {
		super(minute, String.valueOf(minute), Calendar.MINUTE, "minute", "m");
	}

	/**
	 * Creates a matcher that matches when the examined date is on the same minute as the reference date
	 * <p/>
	 * For example:
	 * 
	 * <pre>
	 * assertThat(myDate, sameMinute(new Date()))
	 * </pre>
	 * 
	 * @param date
	 *            the reference date against which the examined date is checked
	 */
	@Factory
	public static Matcher<Date> sameMinute(final Date date) {
		return new IsSameMinute(date);
	}

	/**
	 * Creates a matcher that matches when the examined date is on the reference minute
	 * <p/>
	 * For example:
	 * 
	 * <pre>
	 * assertThat(myDate, sameMinute(55))
	 * </pre>
	 * 
	 * @param minute
	 *            the reference minute against which the examined date is checked
	 */
	@Factory
	public static Matcher<Date> sameMinute(final int minute) {
		return new IsSameMinute(minute);
	}

}