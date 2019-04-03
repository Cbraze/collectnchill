package collectNChill.collectnchill.controllers;

import javax.naming.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import collectNChill.collectnchill.entity.AdminCredentials;
import collectNChill.collectnchill.service.AuthServiceAdmin;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private AuthServiceAdmin authServiceAdmin;
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
		public ResponseEntity<Object> login(@RequestBody AdminCredentials cred) {
			try {
				return new ResponseEntity<Object>(authServiceAdmin.login(cred), HttpStatus.OK);
		}catch (AuthenticationException e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.UNAUTHORIZED);
		}
	}
	
//	@RequestMapping(value="/user/{id}", method=RequestMethod.DELETE)
//	public void deleteUser(@PathVariable Long id) {
//		service.deleteUser(id);
//	}
}

