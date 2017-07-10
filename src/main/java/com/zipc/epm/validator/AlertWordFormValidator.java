package com.zipc.epm.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.zipc.epm.entity.AlertWord;
import com.zipc.epm.service.AlertWordService;

@Component("alertWordFormValidator")
public class AlertWordFormValidator implements Validator {

    @Autowired
    @Qualifier("alertWordService")
    private AlertWordService alertWordService;

    @Override
    public boolean supports(Class<?> clazz) {
        return AlertWord.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        AlertWord alertWord = (AlertWord) target;
        if(alertWordService.findByWordAndLanguage(alertWord.getWord(), alertWord.getLanguage()) != null){
            errors.rejectValue("word", "word.alreadyExists", "Word already exists.");
        }
    }

}
