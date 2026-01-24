package com.chico.chico.repository;

import com.chico.chico.dto.SearchHistoryDTO;
import com.chico.chico.entity.SearchHistory;
import com.chico.chico.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SearchHistoryRepository extends JpaRepository<SearchHistory, Long> {
    List<SearchHistory> findTop10ByUserOrderByCreatedAtDesc(User user);
    List<SearchHistory> findTop20ByUserOrderByCreatedAtDesc(User user);
}
