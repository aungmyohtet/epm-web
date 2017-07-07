package com.zipc.epm.web.repository;

import java.util.List;

import com.zipc.epm.web.entity.Mail;

public interface MailRepository {

    List<Mail> findAll();

    List<Mail> findAllByFetchingSubEntities();

    void delete(Mail mail);
}
