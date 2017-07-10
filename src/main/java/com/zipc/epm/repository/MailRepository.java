package com.zipc.epm.repository;

import java.util.List;

import com.zipc.epm.entity.Mail;

public interface MailRepository {

    List<Mail> findAll();

    List<Mail> findAllByFetchingSubEntities();

    void delete(Mail mail);
}
