package com.chico.chico.service;

import com.chico.chico.dto.SearchHistoryDTO;
import com.chico.chico.entity.SearchHistory;

import java.util.List;

public interface SearchHistoryService {
    List<SearchHistoryDTO> getSearchHistory();
}
