package in.co.userrole.model;


import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "page_master")
public class PageMaster {

  @Id
  @Column(name = "code")
  private String code;

  @Column(name = "description")
  private String description;

  @ManyToMany(mappedBy = "pages")
  private Set<ModuleMaster> modules;

  @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE, mappedBy = "page")
  private Permission permission;

  public String getCode() {
    return code;
  }

  public PageMaster setCode(String code) {
    this.code = code;
    return this;
  }

  public String getDescription() {
    return description;
  }

  public PageMaster setDescription(String description) {
    this.description = description;
    return this;
  }

  public Set<ModuleMaster> getModules() {
    return modules;
  }

  public PageMaster setModules(Set<ModuleMaster> modules) {
    this.modules = modules;
    return this;
  }

  public Permission getPermission() {
    return permission;
  }

  public void setPermission(Permission permission) {
    this.permission = permission;
  }
}
