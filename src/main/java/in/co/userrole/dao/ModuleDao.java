package in.co.userrole.dao;

import java.util.List;

import in.co.userrole.model.ModuleMaster;

public interface ModuleDao {

  List<ModuleMaster> fetchAll();
}
