package com.zipc.epm.web.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.zipc.epm.web.entity.MailAddress;
import com.zipc.epm.web.entity.Project;
import com.zipc.epm.web.service.MailAddressService;
import com.zipc.epm.web.service.ProjectService;

@Component("projectFormValidator")
public class ProjectFormValidator implements Validator {

    @Autowired
    @Qualifier("projectService")
    private ProjectService projectService;

    @Autowired
    @Qualifier("mailAddressService")
    private MailAddressService mailAddressService;

    @Override
    public boolean supports(Class<?> clazz) {
        return Project.class.equals(clazz) && MailAddress.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Project project = (Project) target;
        if (projectService.findByName(project.getName()) != null) {
            errors.rejectValue("name", "name.alreadyExists", "Name already taken.");
        }
    }

    public void validate(Object target1, Object target2, Errors error) {
        MailAddress mailAddress = (MailAddress) target1;
        Project project = (Project) target2;
        if (projectService.IsExistsMailAddress(mailAddress, project)) {
            error.rejectValue("address", "address.alreadyExists", "Address already taken.");
        }
    }
}
