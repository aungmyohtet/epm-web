package com.zipc.epm.web.repository;

import java.util.List;

import com.zipc.epm.web.entity.AlertWordCountListener;
import com.zipc.epm.web.entity.MailAddress;
public interface AlertWordCountListenerRepository {

    void add(AlertWordCountListener alertWordCountListener);

    List<AlertWordCountListener> findAll();

    AlertWordCountListener findById(int id);

    AlertWordCountListener findByMailAddress(MailAddress mailAddress);

    void delete(AlertWordCountListener alertWordCountListener);
}
