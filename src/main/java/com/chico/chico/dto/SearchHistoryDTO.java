package com.chico.chico.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchHistoryDTO {
    private Long id;
    private String queryContent;
    private String username;
    private LocalDateTime searchedAt;

    //just checking if it works (in postman)
    private List<String> cleanQuery;
}
