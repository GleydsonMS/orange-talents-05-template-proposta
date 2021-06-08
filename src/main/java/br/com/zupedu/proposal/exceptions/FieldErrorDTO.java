package br.com.zupedu.proposal.exceptions;

public class FieldErrorDTO {
    private String field;
    private String error;

    public FieldErrorDTO(String field, String error) {
        this.field = field;
        this.error = error;
    }

    public String getField() {
        return field;
    }

    public String getError() {
        return error;
    }
}
