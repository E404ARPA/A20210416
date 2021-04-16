package com.bosonit.adrian.ruiz.A20210416.controller.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class personNotFoundException extends RuntimeException {
    public personNotFoundException(String name) {
        super("The person named "+ name +" doesn't exist");
    }
}
