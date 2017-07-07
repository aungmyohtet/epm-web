package com.zipc.epm.web.service;

import java.util.List;

import com.zipc.epm.web.entity.AlertWordCountListener;
import com.zipc.epm.web.entity.MailAddress;
public interface AlertWordCountListenerService {

    void add(AlertWordCountListener alertWordCountListener);

    List<AlertWordCountListener> findAll();

    AlertWordCountListener findById(int id);

    void add(int maillAddressId);

    AlertWordCountListener findByMailAddress(MailAddress mailAddress);

    void remove(int id);
}
