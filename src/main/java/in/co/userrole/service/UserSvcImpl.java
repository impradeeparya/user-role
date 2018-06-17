package in.co.userrole.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.co.userrole.dao.ModuleDao;
import in.co.userrole.dao.RoleDao;
import in.co.userrole.dao.UserDao;
import in.co.userrole.dto.ModuleInfo;
import in.co.userrole.dto.PageInfo;
import in.co.userrole.dto.PermissionInfo;
import in.co.userrole.dto.RoleInfo;
import in.co.userrole.dto.UserInfo;
import in.co.userrole.model.ModuleMaster;
import in.co.userrole.model.PageMaster;
import in.co.userrole.model.Permission;
import in.co.userrole.model.RoleMaster;
import in.co.userrole.model.UserMaster;

@Service
public class UserSvcImpl implements UserSvc {

  @Autowired
  private ModuleDao moduleDao;

  @Autowired
  private RoleDao roleDao;

  @Autowired
  private UserDao userDao;


  private Function<PageMaster, PageInfo> pageInfo = (page) -> {

    PageInfo pageInfo = new PageInfo();
    pageInfo.setDescription(page.getDescription());
    pageInfo.setCode(page.getCode());
    return pageInfo;

  };

  private Function<ModuleMaster, ModuleInfo> moduleInfo = (module) -> {

    ModuleInfo moduleInfo = new ModuleInfo();
    moduleInfo.setDescription(module.getDescription());
    moduleInfo.setCode(module.getCode());
    return moduleInfo;

  };


  private Function<Set<PageMaster>, Set<PageInfo>> pageInfos = (pages) -> {

    Set<PageInfo> pageInfos = new HashSet<>();

    pages.forEach(page -> {
      PageInfo pageInfo = new PageInfo();
      pageInfo.setCode(page.getCode()).setDescription(page.getDescription());
      pageInfos.add(pageInfo);
    });

    return pageInfos;

  };

  private Function<List<ModuleMaster>, List<ModuleInfo>> moduleInfos = (modules) -> {

    List<ModuleInfo> moduleInfos = new ArrayList<>();

    modules.forEach(module -> {
      ModuleInfo moduleInfo = new ModuleInfo();
      moduleInfo.setCode(module.getCode()).setDescription(module.getDescription())
          .setPages(pageInfos.apply(module.getPages()));

      moduleInfos.add(moduleInfo);
    });


    return moduleInfos;
  };

  private Function<RoleMaster, RoleInfo> fetchRoleInfo = (roleMaster) -> {
    RoleInfo roleInfo = new RoleInfo();
    roleInfo.setCode(roleMaster.getCode()).setDescription(roleMaster.getDescription());

    Set<PermissionInfo> permissionInfos = new HashSet<>();
    roleMaster.getPermissions().forEach(permission -> {

      PermissionInfo permissionInfo = new PermissionInfo();
      permissionInfo.setModuleInfo(moduleInfo.apply(permission.getModule()))
          .setPageInfo(pageInfo.apply(permission.getPage()));

      permissionInfos.add(permissionInfo);

    });


    roleInfo.setPermission(permissionInfos);
    return roleInfo;
  };


  private Function<UserMaster, UserInfo> fetchUserInfo = (userMaster) -> {

    UserInfo userInfo = new UserInfo();
    userInfo.setFirstName(userMaster.getFirstName()).setLastName(userMaster.getFirstName())
        .setRoleInfo(fetchRoleInfo.apply(userMaster.getRoleMaster()));

    return userInfo;
  };

  @Override
  public List<ModuleInfo> modules() {
    List<ModuleMaster> modules = moduleDao.fetchAll();
    return moduleInfos.apply(modules);
  }

  @Override
  public RoleInfo createRole(String name) {

    RoleMaster roleMaster = roleDao.findByCode(name);

    RoleInfo roleInfo = null;
    if (roleMaster == null) {

      List<ModuleMaster> modules = moduleDao.fetchAll();
      Set<Permission> permissions = new HashSet<>();

      modules.forEach(module -> {

        module.getPages().forEach(page -> {
          Permission permission = new Permission();
          permission.setModule(module);
          permission.setPage(page);
          permissions.add(permission);
        });

      });

      roleMaster = new RoleMaster();
      roleMaster.setCode(name).setDescription(name).setPermissions(permissions);

      roleMaster = roleDao.save(roleMaster);

      roleInfo = fetchRoleInfo.apply(roleMaster);
    }

    return roleInfo;
  }

  @Override
  public RoleInfo roleByName(String name) {
    RoleMaster roleMaster = roleDao.findByCode(name);

    RoleInfo roleInfo = null;
    if (roleMaster != null) {
      roleInfo = fetchRoleInfo.apply(roleMaster);
    }

    return roleInfo;

  }

  @Override
  public UserInfo createUser(UserInfo userInfo) {

    RoleMaster roleMaster = roleDao.findByCode(userInfo.getRoleInfo().getCode());

    if (roleMaster != null) {
      UserMaster userMaster = new UserMaster();
      userMaster.setFirstName(userInfo.getFirstName()).setLastName(userInfo.getLastName())
          .setUserId(userInfo.getUserId()).setRoleMaster(roleMaster);

      userMaster = userDao.save(userMaster);
      return fetchUserInfo.apply(userMaster);
    }

    return null;
  }
}
