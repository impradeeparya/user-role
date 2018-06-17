package in.co.userrole.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.co.userrole.model.RoleMaster;

public interface RoleRepository extends JpaRepository<RoleMaster, String> {
}
