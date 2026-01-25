package com.chico.chico.recommendation.scoring;

import java.util.Map;

public interface CourseScoringService {

    Map<Long, Double> scoreCourses(Map<String, Double> userProfile);

}
