package com.dect.itiAdmission.exception;

public class ApplicantNotPresent extends RuntimeException{
    public ApplicantNotPresent() {
        super();
    }

    public ApplicantNotPresent(String message) {
        super(message);
    }
}
