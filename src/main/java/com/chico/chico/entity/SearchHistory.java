package com.chico.chico.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Table(name = "search_history")
@NoArgsConstructor
@AllArgsConstructor
public class SearchHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    private String queryContent;

    @Column(name = "clean_queries")
    @ElementCollection
    @CollectionTable(
            name = "search_history_clean_queries",
            joinColumns = @JoinColumn(name = "search_history_id")
    )
    private List<String> cleanQuery;

    private LocalDateTime createdAt;
}
