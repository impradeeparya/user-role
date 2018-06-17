package in.co.userrole.dto;

public class UserInfo {

  private String firstName;
  private String lastName;
  private String userId;
  private RoleInfo roleInfo;

  public String getFirstName() {
    return firstName;
  }

  public UserInfo setFirstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  public String getLastName() {
    return lastName;
  }

  public UserInfo setLastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  public String getUserId() {
    return userId;
  }

  public UserInfo setUserId(String userId) {
    this.userId = userId;
    return this;
  }

  public RoleInfo getRoleInfo() {
    return roleInfo;
  }

  public UserInfo setRoleInfo(RoleInfo roleInfo) {
    this.roleInfo = roleInfo;
    return this;
  }
}
