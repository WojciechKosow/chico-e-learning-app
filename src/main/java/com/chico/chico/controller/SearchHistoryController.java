package com.chico.chico.controller;

import com.chico.chico.dto.SearchHistoryDTO;
import com.chico.chico.service.SearchHistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/history")
public class SearchHistoryController {

    private final SearchHistoryService searchHistoryService;

    @GetMapping("/latest")
    public List<SearchHistoryDTO> getLatestSearchHistory() {
        return searchHistoryService.getSearchHistory();
    }

}
