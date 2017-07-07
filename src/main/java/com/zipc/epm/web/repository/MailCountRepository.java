package com.zipc.epm.web.repository;

import java.util.List;

import com.zipc.epm.web.entity.MailCount;

public interface MailCountRepository {

    List<MailCount> findAll();

    void delete(MailCount mailCount);

}
