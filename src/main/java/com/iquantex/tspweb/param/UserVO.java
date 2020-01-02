package com.iquantex.tspweb.param;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserVO {
    private Long id;
    private String token;
    private String code;
    private String userId;
    //private String roleId;
}
