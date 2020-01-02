package com.iquantex.tspweb.param;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
    private Long userId;
    private String userName;
    private String password;
    private String oldPassword;
    private String confirmPassword;
    private String clientVersion;
}
