package br.com.zupedu.proposal.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Base64;


public class IsBase64Validator implements ConstraintValidator<IsBase64, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        try {
            String decode = new String(Base64.getDecoder().decode(value));
            String encode = Base64.getEncoder().encodeToString(decode.getBytes());
            return value.equals(encode);
        } catch (Exception e) {
            return false;
        }
    }
}
