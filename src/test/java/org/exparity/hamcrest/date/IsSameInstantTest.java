package org.exparity.hamcrest.date;

import java.util.Date;
import org.junit.Test;
import static org.exparity.hamcrest.date.DateMatchers.sameInstant;
import static org.exparity.hamcrest.date.testutils.Dates.JAN_1ST_2012_11_AM;
import static org.exparity.hamcrest.date.testutils.Dates.JAN_1ST_2012_11_AM_GMT;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNot.not;

/**
 * Unit Tests for the {@link IsSameInstant} class
 * 
 * @author Stewart Bissett
 */
public class IsSameInstantTest {

	@Test
	public void canCompareTheSameInstant() {
		Date date = new Date(), other = new Date(date.getTime());
		assertThat(other, sameInstant(date));
	}

	@Test
	public void canDetectDifferentInstants() {
		Date date = new Date(), other = new Date(date.getTime() + 1);
		assertThat(other, not(sameInstant(date)));
	}

	@Test
	public void canCompareTheSameLinuxTimstamp() {
		assertThat(JAN_1ST_2012_11_AM_GMT, sameInstant(1325415600000L));
	}

	@Test
	public void canDetectDifferentLinuxTimstamp() {
		assertThat(JAN_1ST_2012_11_AM, not(sameInstant(1L)));
	}

	@Test
	public void canCompareTheSameFullTime() {
		assertThat(JAN_1ST_2012_11_AM, sameInstant(2012, Months.JANUARY, 1, 11, 00, 00, 000));
	}

	@Test
	public void canDetectDifferentFullTime() {
		assertThat(JAN_1ST_2012_11_AM, not(sameInstant(2012, Months.JANUARY, 1, 11, 00, 00, 1)));
	}

}
