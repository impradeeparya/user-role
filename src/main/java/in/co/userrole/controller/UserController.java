package in.co.userrole.controller;


import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.co.userrole.dto.ModuleInfo;
import in.co.userrole.dto.RoleInfo;
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

  @PostMapping(value = "/role/default/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
  public RoleInfo role(@PathVariable("name") String name) {
    return userSvc.createRole(name);
  }
}
