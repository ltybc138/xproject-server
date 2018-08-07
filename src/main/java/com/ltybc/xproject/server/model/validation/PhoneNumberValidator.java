package com.ltybc.xproject.server.model.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhoneNumberValidator implements ConstraintValidator<PhoneNumber, String> {
    @Override
    public void initialize(PhoneNumber phoneNumber) {
    }

    @Override
    public boolean isValid(String phone, ConstraintValidatorContext constraintValidatorContext) {
        boolean valid = false;
        if (phone == null) {
            valid = true;
        } else if (phone.length() == 0 ||
                (phone.matches("[+]*[0-9]+") && phone.length() > 8 && phone.length() < 14)) {
            valid = true;
        }
        return valid;
    }
}
