package in.co.userrole.model;


import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "module_master")
public class ModuleMaster {

  @Id
  @Column(name = "code")
  private String code;
  @Column(name = "description")
  private String description;


  @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
  @JoinTable(name = "module_page", joinColumns = @JoinColumn(name = "module_id"),
      inverseJoinColumns = @JoinColumn(name = "page_id"))
  private Set<PageMaster> pages;

  public String getCode() {
    return code;
  }

  public ModuleMaster setCode(String code) {
    this.code = code;
    return this;
  }

  public String getDescription() {
    return description;
  }

  public ModuleMaster setDescription(String description) {
    this.description = description;
    return this;
  }

  public Set<PageMaster> getPages() {
    return pages;
  }

  public ModuleMaster setPages(Set<PageMaster> pages) {
    this.pages = pages;
    return this;
  }

}
