package com.zipc.epm.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zipc.epm.web.entity.Mail;
import com.zipc.epm.web.repository.MailRepository;

@Service("mailService")
public class MailServiceImpl implements MailService {

    @Autowired
    private MailRepository mailRepo;

    public void setMailRepo(MailRepository mailRepo) {
        this.mailRepo = mailRepo;
    }

    @Override
    @Transactional
    public List<Mail> findAll() {
        return mailRepo.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Mail> findAllByFetchingSubEntities() {
        return mailRepo.findAllByFetchingSubEntities();
    }

}
