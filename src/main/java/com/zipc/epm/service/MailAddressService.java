package com.zipc.epm.service;

import java.util.List;

import com.zipc.epm.entity.MailAddress;

public interface MailAddressService {

    void save(MailAddress mailAddress);

    List<MailAddress> findAll();

    MailAddress findById(int id);

    MailAddress findByAddress(String address);

    MailAddress findByName(String name);

    void update(MailAddress mailAddress);

    void delete(int id);

}
