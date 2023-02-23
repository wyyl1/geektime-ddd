package com.wyyl1.hi.common.util;

import java.time.LocalDateTime;
import java.util.Date;

public class DateUtils {

    public static final Date dateOf(LocalDateTime dateToConvert) {
        return java.sql.Timestamp.valueOf(dateToConvert);
    }
}
