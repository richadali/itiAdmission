package com.dect.itiAdmission.exception;

public class ApplicantAlreadyExists extends RuntimeException{
    public ApplicantAlreadyExists() {
    }

    public ApplicantAlreadyExists(String message) {
        super(message);
    }
}
