package in.co.userrole.dto;

import java.util.Set;

public class ModuleInfo {

  private String code;
  private String description;
  private Set<PageInfo> pages;

  public String getCode() {
    return code;
  }

  public ModuleInfo setCode(String code) {
    this.code = code;
    return this;
  }

  public String getDescription() {
    return description;
  }

  public ModuleInfo setDescription(String description) {
    this.description = description;
    return this;
  }

  public Set<PageInfo> getPages() {
    return pages;
  }

  public ModuleInfo setPages(Set<PageInfo> pages) {
    this.pages = pages;
    return this;
  }

  @Override
  public String toString() {
    return "ModuleInfo{" + "code='" + code + '\'' + ", description='" + description + '\''
        + ", pages=" + pages + '}';
  }
}
