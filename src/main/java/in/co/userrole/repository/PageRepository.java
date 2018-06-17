package in.co.userrole.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.co.userrole.model.PageMaster;

public interface PageRepository extends JpaRepository<PageMaster, String> {
}
