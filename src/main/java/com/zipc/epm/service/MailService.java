package com.zipc.epm.service;

import java.util.List;

import com.zipc.epm.entity.Mail;

public interface MailService {

    List<Mail> findAll();

    List<Mail> findAllByFetchingSubEntities();

}
