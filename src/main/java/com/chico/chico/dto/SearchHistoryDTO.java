package com.chico.chico.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchHistoryDTO {
    private Long id;
    private String queryContent;
    private String username;
}
