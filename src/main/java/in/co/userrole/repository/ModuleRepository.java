package in.co.userrole.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.co.userrole.model.ModuleMaster;

public interface ModuleRepository extends JpaRepository<ModuleMaster, String> {
}
