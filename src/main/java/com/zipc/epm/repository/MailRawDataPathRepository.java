package com.zipc.epm.repository;

import java.util.List;

import com.zipc.epm.entity.MailRawDataPath;

public interface MailRawDataPathRepository {

    void save(MailRawDataPath mailRawDataPath);

    List<MailRawDataPath> findAll();

    MailRawDataPath findById(int id);

    void delete(MailRawDataPath path);
}
