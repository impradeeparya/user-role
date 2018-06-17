package in.co.userrole.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.co.userrole.model.UserMaster;
import in.co.userrole.repository.UserRepository;

@Repository
public class UserDaoImpl implements UserDao {

  @Autowired
  private UserRepository userRepository;

  @Override
  public UserMaster save(UserMaster userMaster) {
    return userRepository.save(userMaster);
  }

  @Override
  public UserMaster findByUserId(String userId) {
    return userRepository.findById(userId).orElse(null);
  }
}
