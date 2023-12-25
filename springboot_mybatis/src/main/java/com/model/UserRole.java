package com.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserRole {

    private Integer userRoleId;

    private Integer userId;

    private Integer roleId;

}
