package com.ferhatbedir.apply_for_a_job.repository;

import com.ferhatbedir.apply_for_a_job.entity.UserInfo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserInfoRepository extends MongoRepository<UserInfo, String> {
    UserInfo findByUserVatNum(String userVatNum);
}
