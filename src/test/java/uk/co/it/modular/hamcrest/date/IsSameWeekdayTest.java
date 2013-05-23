/*
 * Copyright (c) Modular IT Limited.
 */

package uk.co.it.modular.hamcrest.date;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.not;
import static uk.co.it.modular.hamcrest.date.DateMatchers.sameWeekday;
import static uk.co.it.modular.hamcrest.date.testutils.DateMatcherTestUtils.addDateField;
import java.util.Calendar;
import java.util.Date;
import org.junit.Test;

/**
 * Unit Tests for the {@link IsSameMonth} class
 * 
 * @author Stewart Bissett
 */
public class IsSameWeekdayTest {

	@Test
	public void canCompareTheSameWeekday() {
		Date date = new Date(), other = addDateField(date, Calendar.DATE, 7);
		assertThat(other, sameWeekday(date));
	}

	@Test
	public void canDetectDifferentWeekdays() {
		Date date = new Date(), other = addDateField(date, Calendar.DATE, 1);
		assertThat(other, not(sameWeekday(date)));
	}
}
