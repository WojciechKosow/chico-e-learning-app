package com.chico.chico.recommendation.profile;

import com.chico.chico.entity.User;

import java.util.Map;

public interface UserInterestProfileService {

    Map<String, Double> buildProfile(User user);

}
