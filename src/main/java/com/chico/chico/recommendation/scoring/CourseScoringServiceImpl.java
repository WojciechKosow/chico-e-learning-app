package com.chico.chico.recommendation.scoring;

import com.chico.chico.entity.Course;
import com.chico.chico.recommendation.cleaner.SearchCleaner;
import com.chico.chico.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CourseScoringServiceImpl implements CourseScoringService {

    private final CourseRepository courseRepository;
    private final SearchCleaner searchCleaner;

    @Override
    public Map<Long, Double> scoreCourses(Map<String, Double> userProfile) {

        List<Course> courses = courseRepository.findByIsPublicTrue();

        Map<Long, Double> courseScores = new HashMap<>();

        for (Course course : courses) {

            List<String> cleanCourseContent = searchCleaner.clean(course.getTitle() + " " + course.getDescription());

            double score = 0;

            for (String cleanContent : cleanCourseContent) {
                if (userProfile.containsKey(cleanContent)) {
                    score += userProfile.get(cleanContent);
                }
            }

            if (score > 0) {
                courseScores.put(course.getId(), score);
            }
        }

        return courseScores;
    }
}
