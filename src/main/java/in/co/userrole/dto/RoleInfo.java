package in.co.userrole.dto;

import java.util.Set;

public class RoleInfo {

  private String code;
  private String description;
  private Set<PermissionInfo> permission;

  public String getCode() {
    return code;
  }

  public RoleInfo setCode(String code) {
    this.code = code;
    return this;
  }

  public String getDescription() {
    return description;
  }

  public RoleInfo setDescription(String description) {
    this.description = description;
    return this;
  }

  public Set<PermissionInfo> getPermission() {
    return permission;
  }

  public RoleInfo setPermission(Set<PermissionInfo> permission) {
    this.permission = permission;
    return this;
  }
}
