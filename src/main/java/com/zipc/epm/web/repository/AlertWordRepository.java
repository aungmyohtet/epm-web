package com.zipc.epm.web.repository;

import java.util.List;

import com.zipc.epm.web.entity.AlertWord;
import com.zipc.epm.web.entity.AlertWord.Language;

public interface AlertWordRepository {

    void save(AlertWord alertWord);

    List<AlertWord> findAll();

    AlertWord findById(int id);

    AlertWord findByWordAndLanguage(String word, Language language);

    void update(AlertWord alertWord);

    void delete(int id);
}
