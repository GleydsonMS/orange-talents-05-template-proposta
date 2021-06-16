package br.com.zupedu.proposal.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = {IsBase64Validator.class})
@Target({FIELD})
@Retention(RUNTIME)
public @interface IsBase64 {
    String message() default "Deve ser informado um valor no formato Base64 válido!";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
