package in.co.userrole.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.co.userrole.dao.ModuleMasterDao;
import in.co.userrole.dto.ModuleInfo;
import in.co.userrole.dto.PageInfo;
import in.co.userrole.model.ModuleMaster;
import in.co.userrole.model.PageMaster;

@Service
public class UserSvcImpl implements UserSvc {

  @Autowired
  private ModuleMasterDao moduleMasterDao;


  @Override
  public List<ModuleInfo> modules() {
    List<ModuleMaster> modules = moduleMasterDao.fetchAll();
    return moduleInfos.apply(modules);
  }


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
}
