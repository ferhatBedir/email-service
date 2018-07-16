package com.ferhatbedir.apply_for_a_job.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;

@Data
public class UserInfo {

    @Id
    private String userId;

    @NotNull
    private String userFirstName;

    @NotNull
    private String userLastName;

    @NotNull
    private String userVatNum;

    @NotNull
    private Integer userAge;

    @NotNull
    private String userEmail;

    @NotNull
    private String userUniversity;

    @NotNull
    private String userAddress;

}
