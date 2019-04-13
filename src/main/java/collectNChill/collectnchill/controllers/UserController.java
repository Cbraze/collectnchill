package collectNChill.collectnchill.controllers;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.naming.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import collectNChill.collectnchill.entity.Credentials;
import collectNChill.collectnchill.entity.User;
import collectNChill.collectnchill.service.AuthService;
import collectNChill.collectnchill.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	private static String UPLOADED_FOLDER = "./pictures/";
	@Autowired
	private UserService service;
	@Autowired
	private AuthService authService;

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<Object> register(@RequestBody Credentials cred) {
		try {
			return new ResponseEntity<Object>(authService.register(cred), HttpStatus.CREATED);
		} catch (AuthenticationException e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<Object> login(@RequestBody Credentials cred) {
		try {
			return new ResponseEntity<Object>(authService.login(cred), HttpStatus.OK);
		} catch (AuthenticationException e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.UNAUTHORIZED);
		}
	}

	@RequestMapping(value = "/{id}/follows")
	public ResponseEntity<Object> showFollowedUsers(@PathVariable Long id) {
		try {
			return new ResponseEntity<Object>(service.getFollowedUsers(id), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

	}

	@RequestMapping(value = "/{id}/follows/{followId}", method = RequestMethod.POST)
	public ResponseEntity<Object> follow(@PathVariable long id, @PathVariable long followId) {
		try {
			return new ResponseEntity<Object>(service.follow(id, followId), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);

		}
	}

	@RequestMapping(value = "/{id}/profilePicture", method = RequestMethod.POST)
	public ResponseEntity<Object> singleFileUpload(@PathVariable Long id, @RequestParam("file") MultipartFile file) {
		if (file.isEmpty()) {
			return new ResponseEntity<Object>("Please select profile image.", HttpStatus.BAD_REQUEST);
		}

		try {
			String url = UPLOADED_FOLDER + file.getOriginalFilename();
			byte[] bytes = file.getBytes();
			Path path = Paths.get(url);
			Files.write(path, bytes);
			return new ResponseEntity<Object>(service.updateProfilePicture(id, url), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public User updateUser(@PathVariable Long id, @RequestBody User user) {
		return service.updateUser(id, user);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteUser(@PathVariable Long id) {
		service.deleteUser(id);
	}

	@RequestMapping("/all")
	public Iterable<User> getUsers() {
		return service.getUsers();
	}
}
