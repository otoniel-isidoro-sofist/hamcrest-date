package org.exparity.hamcrest.date;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Helper class to format
 *
 * @author Stewart Bissett
 */
abstract class DateFormatter {

    private static final String DATE_PATTERN_WITH_MILLIS = "dd MMM yyyy HH:mm:ss SSS'ms' Z";

    /**
     * Format the date into a string showing milliseconds
     */
    static String formatDateWithMillis(final Date date) {
        if (date != null)
            return new SimpleDateFormat(DATE_PATTERN_WITH_MILLIS).format(date);
        else return "null";

    }

}
