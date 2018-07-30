package com.ruhuna.kavinda.exception;

import java.math.BigDecimal;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created By Supun Kavinda
 * Email naskavinda@gmail.com
 * Date  : 7/28/2018
 */
public class Assert {
    public static void isGreaterThenZero(int value) {
        if (value <= 0) {
            throw new IllegalArgumentException("This Integer Value can not be less then zero.");
        }
    }

    public static void isGreaterThenZero(double value) {
        if (value <= 0.0) {
            throw new IllegalArgumentException("This Double Value can not be less then zero.");
        }
    }

    public static void isGreaterThenZero(BigDecimal value) {
        if (value.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("This BigDecimal Value can not be less then zero.");
        }
    }

    public static <T> void isEmpty(List<T> list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("This List can not be empty. It should have at least one element.");
        }
    }

    public static void isNull(Object object) {
        if (object == null) {
            throw new IllegalArgumentException("This object can not be null.");
        }
    }

    public static void isSimNo(int simNo) {
        if (!Pattern.matches("^[0-9]{9}$", Integer.toString(simNo))) {
            throw new IllegalArgumentException("This is not a Sim No");
        }
    }

    public static void isEmpty(String parameter, String message) {
        if (parameter == null || parameter.length() == 0){
            throw new IllegalArgumentException(message);
        }
    }
}
