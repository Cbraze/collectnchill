package collectNChill.collectnchill.service;

import javax.naming.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import collectNChill.collectnchill.entity.Admin;
import collectNChill.collectnchill.entity.AdminCredentials;
import collectNChill.collectnchill.repository.AdminRepository;


@Service
public class AuthServiceAdmin {

	@Autowired
	private AdminRepository adminRepository;

	public Admin register(AdminCredentials cred) throws AuthenticationException {
		Admin admin = new Admin();
		admin.setAdminUsername(cred.getAdminUsername());
		admin.setAdminHash(BCrypt.hashpw(cred.getAdminPassword(), BCrypt.gensalt()));
		try {
			adminRepository.save(admin);
			return admin;
		} catch (DataIntegrityViolationException e) {
			throw new AuthenticationException("Username not available.");
		}
	}

	public Admin login(AdminCredentials cred) throws AuthenticationException {
		Admin foundAdmin = adminRepository.findByAdminUsername(cred.getAdminUsername());
		if (foundAdmin != null && BCrypt.checkpw(cred.getAdminPassword(), foundAdmin.getAdminHash())) {
			return foundAdmin;
		}
		throw new AuthenticationException("Incorrect username or password.");
		
	}

}