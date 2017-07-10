package com.zipc.epm.repository;

import java.util.List;

import com.zipc.epm.entity.MailCount;

public interface MailCountRepository {

    List<MailCount> findAll();

    void delete(MailCount mailCount);

}
