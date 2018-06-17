package in.co.userrole.dao;

import in.co.userrole.model.UserMaster;

public interface UserDao {

  UserMaster save(UserMaster userMaster);

  UserMaster findByUserId(String userId);
}
