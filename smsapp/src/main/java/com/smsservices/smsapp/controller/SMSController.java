package com.smsservices.smsapp.controller;

import com.smsservices.smsapp.payload.SMSRequest;
import com.smsservices.smsapp.service.SMSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SMSController {

    private final SMSService smsService;

    @Autowired
    public SMSController(SMSService smsService) {
        this.smsService = smsService;
    }

    //http://localhost:8080/send-sms
    @PostMapping("/send-sms")
    public void sendSMS(@RequestBody SMSRequest request) {
        String phoneNumber = request.getPhoneNumber();
        String message = request.getMessage();
        smsService.sendSMS(phoneNumber, message);
    }
}

