package com.club1.studentclubmanager.service;

import com.club1.studentclubmanager.exception.UserNotFoundException;
import com.club1.studentclubmanager.model.Keyword;
import com.club1.studentclubmanager.repo.KeywordRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KeywordService {
    private final KeywordRepository keywordRepository;

    public KeywordService(KeywordRepository keywordRepository) {
        this.keywordRepository = keywordRepository;
    }

    public List<Keyword> findAllKeywords(){
        return keywordRepository.findAll();
    }

    public Keyword updateKeyword(Keyword keyword){
        return keywordRepository.save(keyword);
    }

    public Keyword addKeyword(Keyword keyword){
        return keywordRepository.save(keyword);
    }

    public Keyword findKeywordById(Long id){
        return keywordRepository.findById(id).
                orElseThrow(() -> new UserNotFoundException("keyword by id "+ id + " was not found"));
    }
    public void deleteKeywordById(Long id){
        boolean exists = keywordRepository.existsById(id);
        if (!exists){
            throw new UserNotFoundException("keyword by id " + id + " was not found");
        }
        keywordRepository.deleteById(id);
    }
}
