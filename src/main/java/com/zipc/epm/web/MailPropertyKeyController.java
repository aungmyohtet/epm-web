package com.zipc.epm.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.zipc.epm.entity.MailPropertyKey;
import com.zipc.epm.service.MailPropertyKeyService;
import com.zipc.epm.service.MailPropertySettingService;
import com.zipc.epm.validator.MailPropertyKeyValidator;

@Controller
public class MailPropertyKeyController {

    @Autowired
    @Qualifier("mailPropertyKeyValidator")
    private MailPropertyKeyValidator mailPropertyKeyValidator;

    @Autowired
    private MailPropertyKeyService mailPropertyKeyService;

    public void setMailPropertyKeyService(MailPropertyKeyService mailPropertyKeyService) {
        this.mailPropertyKeyService = mailPropertyKeyService;
    }

    @Autowired
    private MailPropertySettingService mailPropertySettingService;

    public void setMailPropertySettingService(MailPropertySettingService mailPropertySettingService) {
        this.mailPropertySettingService = mailPropertySettingService;
    }

    @RequestMapping(value = "/mail_property_keys", method = RequestMethod.GET)
    public String showMailPropertyKeys(Model model) {
        if (!model.containsAttribute("mailPropertyKey")) {
            model.addAttribute("mailPropertyKey", new MailPropertyKey());
        }
        model.addAttribute("mailPropertyKeys", this.mailPropertyKeyService.findAll());
        model.addAttribute("menuTitle", "mail property keys");
        return "mail_property_keys";
    }

    @RequestMapping(value = "/mail_property_keys/add", method = RequestMethod.POST)
    public String addMailPropertyKey(@Validated @ModelAttribute("mailPropertyKey") MailPropertyKey mailPropertyKey, BindingResult result, Model model, RedirectAttributes attr,
            HttpSession session) {
        model.addAttribute("mailPropertyKeys", this.mailPropertyKeyService.findAll());
        if (result.hasErrors()) {
            attr.addFlashAttribute("org.springframework.validation.BindingResult.mailPropertyKey", result);
            attr.addFlashAttribute("mailPropertyKey", mailPropertyKey);
            return "redirect:/mail_property_keys";
        } else {
            mailPropertyKeyValidator.validate(mailPropertyKey, result);
            if (result.hasErrors()) {
                attr.addFlashAttribute("org.springframework.validation.BindingResult.mailPropertyKey", result);
                attr.addFlashAttribute("mailPropertyKey", mailPropertyKey);
                return "redirect:/mail_property_keys";
            }
        }
        mailPropertyKeyService.add(mailPropertyKey);
        return "redirect:/mail_property_keys";
    }

    @RequestMapping(value = "/mail_property_keys/{id}/update", method = RequestMethod.GET)
    public String updateMailPropertyKey(@PathVariable("id") int id, Model model) {
        if (!model.containsAttribute("mailPropertyKey")) {
            model.addAttribute("mailPropertyKey", this.mailPropertyKeyService.findById(id));
        }
        model.addAttribute("menuTitle", "mail property keys");
        return "update_mail_property_key";
    }

    @RequestMapping(value = "/mail_property_keys/{id}/update", method = RequestMethod.POST)
    public String updateMailPropertyKey(@Validated @ModelAttribute("mailPropertyKey") MailPropertyKey mailPropertyKey, BindingResult result, Model model, RedirectAttributes attr,
            HttpSession session) {
        String name = mailPropertyKey.getName();
        int id = mailPropertyKey.getId();
        if (result.hasErrors()) {
            attr.addFlashAttribute("org.springframework.validation.BindingResult.mailPropertyKey", result);
            attr.addFlashAttribute("mailPropertyKey", mailPropertyKey);
            return "redirect:/mail_property_keys/{id}/update";
        } else if (mailPropertyKeyService.findById(id).getName().equals(name)) {
            mailPropertyKeyService.update(mailPropertyKey);
        } else {
            mailPropertyKeyValidator.validate(mailPropertyKey, result);
            if (result.hasErrors()) {
                attr.addFlashAttribute("org.springframework.validation.BindingResult.mailPropertyKey", result);
                attr.addFlashAttribute("mailPropertyKey", mailPropertyKey);
                return "redirect:/mail_property_keys/{id}/update";
            }
            mailPropertyKeyService.update(mailPropertyKey);
        }
        return "redirect:/mail_property_keys";
    }

    @RequestMapping(value = "/mail_property_keys/{id}/delete", method = RequestMethod.GET)
    public String deleteMailPropertyKey(@PathVariable("id") int id, Model model) {
        mailPropertySettingService.delete(id);
        mailPropertyKeyService.delete(id);
        return "redirect:/mail_property_keys";
    }
}
