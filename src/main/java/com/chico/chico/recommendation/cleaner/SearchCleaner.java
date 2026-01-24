package com.chico.chico.recommendation.cleaner;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class SearchCleaner {

    //clean whole sentence
    public List<String> clean(String query) {
        return Arrays.stream(query
                        .toLowerCase()
                        .replaceAll("[^a-z0-9ąćęłńóśżź ]", "")
                        .split("\\s+"))
                .filter(cleanQuery -> cleanQuery.length() >= 2)
                .filter(cleanQuery -> !DeleteWords.words.contains(cleanQuery))
                .toList();
    }

}
