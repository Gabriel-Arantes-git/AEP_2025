package com.backend.aep_2025.application.utils;

import com.backend.aep_2025.application.exception.globalError.InvalidArgumentException;

import java.util.regex.Pattern;

public class ValidationUtils {
    private static final Pattern EMAIL_PATTERN = Pattern.compile(
            "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$"
    );

    public static void requireValidEmail(String email) {
        if (email == null || !EMAIL_PATTERN.matcher(email).matches()) {
            throw new InvalidArgumentException(email,"Email inválido");
        }
    }
}
