package com.zipc.epm.web.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.zipc.epm.web.entity.AlertWordCountListener;
import com.zipc.epm.web.service.AlertWordCountListenerService;
import com.zipc.epm.web.service.MailAddressService;

@Component("alertWordCountListenerFormValidator")
public class AlertWordCountListenerFormValidator implements Validator {

    @Autowired
    @Qualifier("alertWordCountListenerService")
    private AlertWordCountListenerService alertWordCountListenerService;

    @Autowired
    @Qualifier("mailAddressService")
    private MailAddressService mailAddressService;

    @Override
    public boolean supports(Class<?> clazz) {
        return AlertWordCountListener.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        AlertWordCountListener alertWordCountListener = (AlertWordCountListener) target;
        int mailId = alertWordCountListener.getMailAddress().getId();
        if (mailId == 0) {
            errors.rejectValue("mailAddress.id", "mailAddress.id.notSelected", "Select Mail Address.");
        }
        if (alertWordCountListenerService.findById(mailId) != null) {
            errors.rejectValue("mailAddress.id", "mailAddress.id.alreadyExists", "Email already exist.");
        }
    }

}