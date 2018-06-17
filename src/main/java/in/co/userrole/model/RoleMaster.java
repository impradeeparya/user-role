package in.co.userrole.model;


import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "role_master")
public class RoleMaster {


  @Id
  @Column(name = "code")
  private String code;
  @Column(name = "description")
  private String description;

  @ManyToMany(cascade = {CascadeType.MERGE})
  @JoinTable(name = "role_permission_jn", joinColumns = @JoinColumn(name = "role_id"),
      inverseJoinColumns = @JoinColumn(name = "permission_id"))
  private Set<Permission> permissions;

  public String getCode() {
    return code;
  }

  public RoleMaster setCode(String code) {
    this.code = code;
    return this;
  }

  public String getDescription() {
    return description;
  }

  public RoleMaster setDescription(String description) {
    this.description = description;
    return this;
  }

  public Set<Permission> getPermissions() {
    return permissions;
  }

  public RoleMaster setPermissions(Set<Permission> permissions) {
    this.permissions = permissions;
    return this;
  }
}
