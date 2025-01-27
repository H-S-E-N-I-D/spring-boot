package com.shdinesh.springcrud.controller;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController("/employee")
public class InternationalController {
    /*
        This method is to test Internationalization in spring boot
        Need to send 'Accept-Language' in request header
     */


    private MessageSource messageSource;

    public InternationalController(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @GetMapping("/greeting-message")
    public ResponseEntity<String> greetingMessageI18n() {
        Locale locale = LocaleContextHolder.getLocale();
        String message = messageSource.getMessage(
                "good.morning.message", null, "Good Morning", locale
        );
        return new ResponseEntity(message, HttpStatus.OK);
    }



}
