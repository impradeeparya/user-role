package in.co.userrole.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.co.userrole.model.RoleMaster;
import in.co.userrole.repository.RoleRepository;

@Repository
public class RoleDaoImpl implements RoleDao {

  @Autowired
  private RoleRepository roleRepository;

  @Override
  public RoleMaster findByCode(String code) {
    return roleRepository.findById(code).orElse(null);
  }

  @Override
  public RoleMaster save(RoleMaster roleMaster) {
    return roleRepository.save(roleMaster);
  }
}
