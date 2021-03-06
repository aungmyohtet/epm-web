package com.zipc.epm.validator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.zipc.epm.entity.MailPropertySetting;
import com.zipc.epm.service.MailAddressService;
import com.zipc.epm.service.MailPropertyKeyService;
import com.zipc.epm.service.MailPropertySettingService;

@Component("mailPropertySettingValidator")
public class MailPropertySettingValidator implements Validator {

    @Autowired
    @Qualifier("mailAddressService")
    private MailAddressService mailAddressService;

    @Autowired
    @Qualifier("mailPropertyKeyService")
    private MailPropertyKeyService mailPropertyKeyService;

    @Autowired
    @Qualifier("mailPropertySettingService")
    private MailPropertySettingService mailPropertySettingService;

    @Override
    public boolean supports(Class<?> clazz) {
        return MailPropertySetting.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        MailPropertySetting mailPropertySetting = (MailPropertySetting) target;
        int mailPropertyKey = mailPropertySetting.getMailPropertyKey().getId();
        int mailAddressId = mailPropertySetting.getMailAddress().getId();
        String value = mailPropertySetting.getValue();
        if (value.equals("")) {
            errors.rejectValue("value", "value.alreadyExists", "Value cannot be empty.");
        }
        if (mailAddressId == 0) {
            errors.rejectValue("mailAddress.id", "mailAddress.id.alreadyExists", "Select Mail Address");
        }
        if (mailPropertyKey == 0) {
            errors.rejectValue("mailPropertyKey.id", "mailPropertyKey.id.alreadyExists", "Select Mail Property Key");
        }
        List<MailPropertySetting> mailPropertySettingLists = mailPropertySettingService.findAll();
        for (MailPropertySetting m : mailPropertySettingLists) {
            if (m.getMailAddress().getId().equals(mailAddressId) && m.getMailPropertyKey().getId().equals(mailPropertyKey)) {
                errors.rejectValue("mailPropertyKey.id", "mailPropertyKey.id.alreadyExists", "Duplicate Primary Key");
            }
        }

    }

}
