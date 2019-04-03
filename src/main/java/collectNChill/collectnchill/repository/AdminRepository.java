package collectNChill.collectnchill.repository;

import org.springframework.data.repository.CrudRepository;

import collectNChill.collectnchill.entity.Admin;


public interface AdminRepository extends CrudRepository<Admin, Long> {
	
	public Admin findByAdminUsername(String username);

}