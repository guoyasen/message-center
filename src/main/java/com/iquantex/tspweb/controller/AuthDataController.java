package com.iquantex.tspweb.controller;

import com.iquantex.tspweb.common.AuthData;
import com.iquantex.tspweb.service.AuthDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/authData")
public class AuthDataController extends BaseController{
    @Autowired
    private AuthDataService authDataService;

    @PutMapping("/update")
    public void update(){
        authDataService.updateAuthData();
    }

    @GetMapping("/rule")
    public String getRuleToMenuitemMap(){
        return successReturn(AuthData.ruleToMenuitemMap);
    }

    @GetMapping("/menu")
    public String getMenuitemToUserMap(){
        return successReturn(AuthData.menuitemToUserMap);
    }
}
