package com.zipc.epm.service;

import java.util.List;

import com.zipc.epm.entity.AlertWordCountListener;
import com.zipc.epm.entity.MailAddress;
public interface AlertWordCountListenerService {

    void add(AlertWordCountListener alertWordCountListener);

    List<AlertWordCountListener> findAll();

    AlertWordCountListener findById(int id);

    void add(int maillAddressId);

    AlertWordCountListener findByMailAddress(MailAddress mailAddress);

    void remove(int id);
}
