package com.dect.itiAdmission.languages;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanguageService {

    private LanguageRepository languageRepository;

    public LanguageService(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    public List<Languages> getLanguages() {
        return languageRepository.findAll();
    }
}
