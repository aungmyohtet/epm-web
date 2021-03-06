package com.zipc.epm.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zipc.epm.entity.Mail;
import com.zipc.epm.service.AlertWordCountService;
import com.zipc.epm.service.MailCountService;
import com.zipc.epm.service.MailService;

@Controller
public class ResultController {

    @Autowired
    @Qualifier("mailService")
    private MailService mailService;

    @Autowired
    @Qualifier("mailCountService")
    private MailCountService mailCountService;

    @Autowired
    @Qualifier("alertWordCountService")
    private AlertWordCountService alertWordCountService;

    public void setMailService(MailService mailService) {
        this.mailService = mailService;
    }

    public void setMailCountService(MailCountService mailCountService) {
        this.mailCountService = mailCountService;
    }

    public void setAlertWordCountService(AlertWordCountService alertWordCountService) {
        this.alertWordCountService = alertWordCountService;
    }

    @RequestMapping(value = "/mails", method = RequestMethod.GET)
    public String showMailsResult(Model model) {
        model.addAttribute("mails", mailService.findAll());
        model.addAttribute("menuTitle", "results");
        return "mails";
    }

    @RequestMapping(value = "/mail_counts", method = RequestMethod.GET)
    public String ShowMailCount(Model model) {
        model.addAttribute("mailCounts", mailCountService.findAll());
        model.addAttribute("menuTitle", "results");
        return "mail_counts";
    }

    @RequestMapping(value = "/alert_word_counts", method = RequestMethod.GET)
    public String ShowAlertWordCount(Model model) {
        List<Mail> mails = mailService.findAllByFetchingSubEntities();
        List<Mail> mailsWithAlertWordCount = new ArrayList<>();
        for (Mail mail : mails) {
            if (mail.getAlertWordCount() != null) {
                mailsWithAlertWordCount.add(mail);
            }
        }
        model.addAttribute("mails", mailsWithAlertWordCount);
        model.addAttribute("menuTitle", "results");
        return "alert_word_counts";
    }
}
