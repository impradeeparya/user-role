package in.co.userrole.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.co.userrole.model.ModuleMaster;
import in.co.userrole.repository.ModuleRepository;

@Repository
public class ModuleMasterDaoImpl implements ModuleMasterDao {

  @Autowired
  private ModuleRepository moduleRepository;


  @Override
  public List<ModuleMaster> fetchAll() {
    return moduleRepository.findAll();
  }
}
