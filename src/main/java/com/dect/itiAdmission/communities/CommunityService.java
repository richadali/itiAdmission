package com.dect.itiAdmission.communities;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommunityService {

    private CommunityRepository communityRepository;

    public CommunityService(CommunityRepository communityRepository) {
        this.communityRepository = communityRepository;
    }

    public List<Communities> getCommunities() {
        return communityRepository.findAll();
    }
}
