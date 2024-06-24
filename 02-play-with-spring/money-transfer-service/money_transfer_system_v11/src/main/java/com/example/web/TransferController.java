package com.example.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.service.TransferService;
import com.example.web.dto.TransferRequest;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class TransferController {

    private final TransferService transferService;

    @GetMapping(value = "/transfer")
    public String showTransferForm() {
        // authoirzation
        // ...
        return "transfer-form"; // ViewName
    }

    @PostMapping("/transfer")
    public ModelAndView handleTransfer(@ModelAttribute TransferRequest transferRequest) {
        // validation
        // ...
        var transferStatus = transferService.transfer(transferRequest.getSourceAccount(),
                transferRequest.getTargetAccount(),
                transferRequest.getAmount());

        ModelAndView modelAndView = new ModelAndView(); // Model
        modelAndView.addObject("transferStatus", transferStatus);
        modelAndView.setViewName("transfer-status");

        return modelAndView; // ViewName
    }

}
