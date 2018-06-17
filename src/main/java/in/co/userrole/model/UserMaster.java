package in.co.userrole.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user_master")
public class UserMaster {

  @Id
  @Column(name = "user_id")
  private String userId;
  @Column(name = "first_name")
  private String firstName;
  @Column(name = "last_name")
  private String lastName;

  @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
  @JoinColumn(name = "role_id")
  private RoleMaster roleMaster;

  public String getUserId() {
    return userId;
  }

  public UserMaster setUserId(String userId) {
    this.userId = userId;
    return this;
  }

  public String getFirstName() {
    return firstName;
  }

  public UserMaster setFirstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  public String getLastName() {
    return lastName;
  }

  public UserMaster setLastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  public RoleMaster getRoleMaster() {
    return roleMaster;
  }

  public UserMaster setRoleMaster(RoleMaster roleMaster) {
    this.roleMaster = roleMaster;
    return this;
  }
}

