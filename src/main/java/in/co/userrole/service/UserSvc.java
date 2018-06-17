package in.co.userrole.service;

import java.util.List;

import in.co.userrole.dto.ModuleInfo;
import in.co.userrole.dto.RoleInfo;

public interface UserSvc {

  List<ModuleInfo> modules();

  RoleInfo createRole(String name);
}
