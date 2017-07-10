package com.zipc.epm.repository;

import java.util.List;

import com.zipc.epm.entity.AlertWordCountListener;
import com.zipc.epm.entity.MailAddress;
public interface AlertWordCountListenerRepository {

    void add(AlertWordCountListener alertWordCountListener);

    List<AlertWordCountListener> findAll();

    AlertWordCountListener findById(int id);

    AlertWordCountListener findByMailAddress(MailAddress mailAddress);

    void delete(AlertWordCountListener alertWordCountListener);
}
