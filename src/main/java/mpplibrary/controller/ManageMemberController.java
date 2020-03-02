package mpplibrary.controller;

import mpplibrary.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ManageMemberController {

    @Autowired
    private UserService userService;

}
