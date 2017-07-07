package com.zipc.epm.web.repository;

import java.util.List;

import com.zipc.epm.web.entity.MailRawDataPath;

public interface MailRawDataPathRepository {

    void save(MailRawDataPath mailRawDataPath);

    List<MailRawDataPath> findAll();

    MailRawDataPath findById(int id);

    void delete(MailRawDataPath path);
}
