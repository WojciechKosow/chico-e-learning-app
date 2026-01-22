package com.chico.chico.service;

import com.chico.chico.dto.SearchHistoryDTO;
import com.chico.chico.entity.SearchHistory;
import com.chico.chico.entity.User;
import com.chico.chico.exception.UserNotFoundException;
import com.chico.chico.repository.SearchHistoryRepository;
import com.chico.chico.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SearchHistoryServiceImpl implements SearchHistoryService {

    private final SearchHistoryRepository searchHistoryRepository;
    private final UserRepository userRepository;

    @Override
    public List<SearchHistoryDTO> getSearchHistory() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String email = authentication.getName();

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("User not found"));

        //return only (5-10)  latest search queries
        return searchHistoryRepository
                .findTop10ByUserOrderByCreatedAtDesc(user)
                .stream()
                .map(this::mapToDTO)
                .toList();
    }


    private SearchHistoryDTO mapToDTO(SearchHistory searchHistory) {
        return new SearchHistoryDTO(
                searchHistory.getId(),
                searchHistory.getQueryContent(),
                searchHistory.getUser().getFirstName() + " " + searchHistory.getUser().getLastName(),
                searchHistory.getCreatedAt(),
                searchHistory.getCleanQuery()
        );
    }
}
