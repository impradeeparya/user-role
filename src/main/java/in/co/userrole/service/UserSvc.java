package in.co.userrole.service;

import in.co.userrole.dto.UserInfo;
import java.util.List;

import in.co.userrole.dto.ModuleInfo;
import in.co.userrole.dto.RoleInfo;

public interface UserSvc {

  List<ModuleInfo> modules();

  RoleInfo createRole(String name);

  RoleInfo roleByName(String name);

  UserInfo createUser(UserInfo userInfo);
}
