package org.exparity.hamcrest.date;

import org.exparity.hamcrest.date.DayMonthYear;
import org.exparity.hamcrest.date.Months;
import org.junit.Test;
import static org.exparity.hamcrest.date.DateMatchers.*;
import static org.exparity.hamcrest.date.testutils.Dates.JAN_1ST_2012_11_AM;
import static org.exparity.hamcrest.date.testutils.Dates.JAN_1ST_2012_11_PM;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Unit Tests for the {@link isSameOrAfterTest} class
 * 
 * @author Stewart Bissett
 */
public class IsSameOrAfterTest {

	@Test
	public void canCompareTheSameDate() {
		assertThat(JAN_1ST_2012_11_AM, sameOrAfter(JAN_1ST_2012_11_AM));
	}

	@Test(expected = AssertionError.class)
	public void canCompareABeforeDate() {
		assertThat(JAN_1ST_2012_11_AM, sameOrAfter(JAN_1ST_2012_11_PM));
	}

	@Test
	public void canCompareALaterDate() {
		assertThat(JAN_1ST_2012_11_PM, sameOrAfter(JAN_1ST_2012_11_AM));
	}

	@Test
	public void canCompareTheSameDayMonthYearFields() {
		assertThat(JAN_1ST_2012_11_AM, sameOrAfter(2012, Months.JAN, 1));
	}

	@Test(expected = AssertionError.class)
	public void canCompareABeforeDayMonthYearFields() {
		assertThat(JAN_1ST_2012_11_AM, sameOrAfter(2012, Months.JAN, 2));
	}

	@Test
	public void canCompareALaterDayMonthYearFields() {
		assertThat(JAN_1ST_2012_11_PM, sameOrAfter(2011, Months.DEC, 31));
	}

	@Test
	public void canCompareTheSameDayMonthYear() {
		assertThat(JAN_1ST_2012_11_AM, sameOrAfter(new DayMonthYear(1, Months.JAN, 2012)));
	}

	@Test(expected = AssertionError.class)
	public void canCompareABeforeDayMonthYear() {
		assertThat(JAN_1ST_2012_11_AM, sameOrAfter(new DayMonthYear(2, Months.JAN, 2012)));
	}

	@Test
	public void canCompareALaterDayMonthYear() {
		assertThat(JAN_1ST_2012_11_PM, sameOrAfter(new DayMonthYear(31, Months.DEC, 2011)));
	}

	@Test
	public void canCompareTheSameDayMonthYearAndTime() {
		assertThat(JAN_1ST_2012_11_AM, sameOrAfter(2012, Months.JAN, 1, 11, 00, 00));
	}

	@Test(expected = AssertionError.class)
	public void canCompareABeforeDayMonthYearAndTime() {
		assertThat(JAN_1ST_2012_11_AM, sameOrAfter(2012, Months.JAN, 1, 12, 00, 00));
	}

	@Test
	public void canCompareALaterDayMonthYearAndTime() {
		assertThat(JAN_1ST_2012_11_PM, sameOrAfter(2012, Months.JAN, 1, 10, 00, 00));
	}

}
