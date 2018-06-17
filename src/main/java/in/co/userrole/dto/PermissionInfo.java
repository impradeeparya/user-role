package in.co.userrole.dto;

public class PermissionInfo {

  private ModuleInfo module;
  private PageInfo page;
  private boolean readAllowed;
  private boolean writeAllowed;
  private boolean editAllowed;
  private boolean deleteAllowed;

  public ModuleInfo getModuleInfo() {
    return module;
  }

  public PermissionInfo setModuleInfo(ModuleInfo module) {
    this.module = module;
    return this;
  }

  public PageInfo getPageInfo() {
    return page;
  }

  public PermissionInfo setPageInfo(PageInfo page) {
    this.page = page;
    return this;
  }

  public boolean isReadAllowed() {
    return readAllowed;
  }

  public PermissionInfo setReadAllowed(boolean readAllowed) {
    this.readAllowed = readAllowed;
    return this;
  }

  public boolean isWriteAllowed() {
    return writeAllowed;
  }

  public PermissionInfo setWriteAllowed(boolean writeAllowed) {
    this.writeAllowed = writeAllowed;
    return this;
  }

  public boolean isEditAllowed() {
    return editAllowed;
  }

  public PermissionInfo setEditAllowed(boolean editAllowed) {
    this.editAllowed = editAllowed;
    return this;
  }

  public boolean isDeleteAllowed() {
    return deleteAllowed;
  }

  public PermissionInfo setDeleteAllowed(boolean deleteAllowed) {
    this.deleteAllowed = deleteAllowed;
    return this;
  }
}
