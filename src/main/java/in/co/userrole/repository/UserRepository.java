package in.co.userrole.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.co.userrole.model.UserMaster;

public interface UserRepository extends JpaRepository<UserMaster, String> {
}
