package com.example.web;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalControllerAdvice {

    @ExceptionHandler({
            com.example.exception.AccountNotFoundException.class,
            com.example.exception.BalanceException.class,
            com.example.exception.TransferLimitException.class
    })
    public ModelAndView handleException(Exception ex) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("error", ex.getMessage());
        modelAndView.setViewName("transfer-error");
        return modelAndView;
    }

}
