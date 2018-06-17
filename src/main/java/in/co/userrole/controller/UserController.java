package in.co.userrole.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.co.userrole.dto.ModuleInfo;
import in.co.userrole.service.UserSvc;

@RestController
@RequestMapping(name = "/user")
public class UserController {

  @Autowired
  private UserSvc userSvc;

  @GetMapping(value = "/modules", produces = MediaType.APPLICATION_JSON_VALUE)
  public List<ModuleInfo> modules() {
    return userSvc.modules();
  }
}
