package com.chico.chico.recommendation.profile;

import com.chico.chico.entity.SearchHistory;
import com.chico.chico.entity.User;
import com.chico.chico.exception.UserNotFoundException;
import com.chico.chico.repository.SearchHistoryRepository;
import com.chico.chico.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class UserInterestProfileServiceImpl implements UserInterestProfileService {

    private final SearchHistoryRepository searchHistoryRepository;

    @Override
    public Map<String, Double> buildProfile(User user) {

        List<SearchHistory> latestSearchHistory = searchHistoryRepository
                .findTop20ByUserOrderByCreatedAtDesc(user);

        Map<String, Double> profile = new HashMap<>();
        for (SearchHistory history : latestSearchHistory) {
            for (String cleanQuery : history.getCleanQuery()) {
                double score = profile.getOrDefault(cleanQuery, 0.0);

                score += 1;
                profile.put(cleanQuery, score);
            }
        }
        return profile;
    }
}
