package org.api.reqres.registration;

public class UnSuccessReg {
    private String error;

    public UnSuccessReg(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }
}
