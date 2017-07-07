package com.zipc.epm.web.service;

import java.util.List;

import com.zipc.epm.web.entity.Mail;

public interface MailService {

    List<Mail> findAll();

    List<Mail> findAllByFetchingSubEntities();

}
