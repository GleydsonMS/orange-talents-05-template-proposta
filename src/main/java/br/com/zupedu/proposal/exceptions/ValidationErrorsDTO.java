package br.com.zupedu.proposal.exceptions;

import java.util.ArrayList;
import java.util.List;

public class ValidationErrorsDTO {

    private List<String> globalErrorsMessages = new ArrayList<>();
    private List<FieldErrorDTO> fieldErrors = new ArrayList<>();

    public void addError(String message) {
        globalErrorsMessages.add(message);
    }

    public void addFieldError(String field, String message) {
        FieldErrorDTO fieldErrorDTO = new FieldErrorDTO(field, message);
        fieldErrors.add(fieldErrorDTO);
    }

    public List<String> getGlobalErrorsMessages() {
        return globalErrorsMessages;
    }

    public List<FieldErrorDTO> getFieldErrors() {
        return fieldErrors;
    }
}
