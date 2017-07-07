package com.zipc.epm.web.validator;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.zipc.epm.web.entity.MailPropertyKey;
import com.zipc.epm.web.service.MailPropertyKeyService;

@Component("mailPropertyKeyValidator")
public class MailPropertyKeyValidator implements Validator {

    @Autowired
    @Qualifier("mailPropertyKeyService")
    private MailPropertyKeyService mailPropertyKeyService;

    @Override
    public boolean supports(Class<?> clazz) {
        return MailPropertyKey.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        MailPropertyKey mailPropertyKey = (MailPropertyKey) target;

        if (mailPropertyKey.getName().equals("")) {
            errors.rejectValue("name", "name.alreadyExists", "Enter Mail Property Key");
        }

        List<MailPropertyKey> mailPropertyKeyList = mailPropertyKeyService.findAll();
        for (MailPropertyKey m : mailPropertyKeyList) {
            if (m.getName().equals(mailPropertyKey.getName())) {
                errors.rejectValue("name", "name.alreadyExists", "Duplicate Mail Property Key");
            }
        }
    }
}
