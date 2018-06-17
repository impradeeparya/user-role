package in.co.userrole.dao;

import in.co.userrole.model.RoleMaster;

public interface RoleDao {

  RoleMaster findByCode(String code);

  RoleMaster save(RoleMaster roleMaster);
}
