package com.zipc.epm.web.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.zipc.epm.web.entity.AlertWordCountSetting;
import com.zipc.epm.web.service.AlertWordCountSettingService;

@Component("alertWordCountSettingFormValidator")
public class AlertWordCountSettingFormValidator implements Validator {

    @Autowired
    @Qualifier("alertWordCountSettingService")
    private AlertWordCountSettingService alertWordCountSettingService;

    @Override
    public boolean supports(Class<?> clazz) {
        return AlertWordCountSetting.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        AlertWordCountSetting alertWordCountSetting = (AlertWordCountSetting) target;
        String name = alertWordCountSetting.getName();
        if (!(alertWordCountSettingService.getAlertWordCountSettingNames().contains(name))) {
            errors.rejectValue("name", "name.alreadyExists", "Select name");
        }
        if (alertWordCountSetting.getValue().equals(null)) {
            errors.rejectValue("value", "value.alreadyExists", "Enter value");
        }
    }
}
