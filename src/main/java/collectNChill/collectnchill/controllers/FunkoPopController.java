package collectNChill.collectnchill.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import collectNChill.collectnchill.entity.FunkoPop;

import collectNChill.collectnchill.service.funkoPopService;

@RestController
@RequestMapping("/users/{userId}/collection")
public class FunkoPopController {
	
	@Autowired
	funkoPopService service;
	
	@RequestMapping(method=RequestMethod.POST) 
	public ResponseEntity<Object> createFunkoPop(@RequestBody FunkoPop funkoPop) {
		try {
			return new ResponseEntity<Object>(service.createFunkoPop(funkoPop), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
}
