package com.club1.studentclubmanager.controller;

import com.club1.studentclubmanager.model.Keyword;
import com.club1.studentclubmanager.service.KeywordService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/keywords")
@CrossOrigin("*")
public class KeywordController {
    private final KeywordService keywordService;

    public KeywordController(KeywordService keywordService) {
        this.keywordService = keywordService;
    }

    @GetMapping
    public ResponseEntity<List<Keyword>> getAllKeywords(){
        List<Keyword> keywords = keywordService.findAllKeywords();
        return new ResponseEntity<>(keywords, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Keyword> getKeywordById(@PathVariable("id") Long id){
        Keyword keyword = keywordService.findKeywordById(id);
        return new ResponseEntity<>(keyword, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Keyword> addKeyword(@RequestBody Keyword keyword){
        Keyword newKeyword = keywordService.addKeyword(keyword);
        return new ResponseEntity<>(newKeyword, HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<Keyword> updateKeyword(@PathVariable("id") Long id, @RequestBody Keyword keyword){
        Keyword updatedKeyword = keywordService.updateKeyword(keyword, id);
        return new ResponseEntity<>(updatedKeyword, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteKeyword(@PathVariable("id") Long id){
        keywordService.deleteKeywordById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
