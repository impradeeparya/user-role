package in.co.userrole.model;


import java.util.Set;
import javax.management.relation.Role;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "permission")
public class Permission {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  long id;

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "module_id", nullable = false)
  private ModuleMaster module;

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "page_id", nullable = false)
  private PageMaster page;

  @Column(name = "read_allowed")
  private boolean readAllowed;
  @Column(name = "write_allowed")
  private boolean writeAllowed;
  @Column(name = "edit_allowed")
  private boolean editAllowed;
  @Column(name = "delete_allowed")
  private boolean deleteAllowed;

  @ManyToMany(mappedBy = "permissions")
  private Set<RoleMaster> roles;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public ModuleMaster getModule() {
    return module;
  }

  public void setModule(ModuleMaster module) {
    this.module = module;
  }

  public PageMaster getPage() {
    return page;
  }

  public void setPage(PageMaster page) {
    this.page = page;
  }

  public boolean isReadAllowed() {
    return readAllowed;
  }

  public void setReadAllowed(boolean readAllowed) {
    this.readAllowed = readAllowed;
  }

  public boolean isWriteAllowed() {
    return writeAllowed;
  }

  public void setWriteAllowed(boolean writeAllowed) {
    this.writeAllowed = writeAllowed;
  }

  public boolean isEditAllowed() {
    return editAllowed;
  }

  public void setEditAllowed(boolean editAllowed) {
    this.editAllowed = editAllowed;
  }

  public boolean isDeleteAllowed() {
    return deleteAllowed;
  }

  public void setDeleteAllowed(boolean deleteAllowed) {
    this.deleteAllowed = deleteAllowed;
  }

  public Set<RoleMaster> getRoles() {
    return roles;
  }

  public void setRoles(Set<RoleMaster> roles) {
    this.roles = roles;
  }
}
