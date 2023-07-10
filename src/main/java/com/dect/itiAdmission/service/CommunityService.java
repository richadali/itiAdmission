package com.dect.itiAdmission.service;

import com.dect.itiAdmission.domain.Communities;
import com.dect.itiAdmission.repository.CommunityRepository;
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
