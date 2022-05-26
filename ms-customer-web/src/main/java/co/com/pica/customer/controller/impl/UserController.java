package co.com.pica.customer.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import co.com.pica.customer.controller.IUserController;
import co.com.pica.customer.domain.UserDTO;
import co.com.pica.customer.service.IUserService;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController implements IUserController {
	@Autowired
	private IUserService iUserService;
	
	
	@Override
	@PostMapping(value = "/user")
	public ResponseEntity<UserDTO> addUser(
			@RequestBody UserDTO userCreationDTO, 
			@RequestHeader HttpHeaders httpHeaders) throws Exception {
		return ResponseEntity.status(HttpStatus.OK).body(iUserService.addUser(userCreationDTO));
	}
	
	@Override
	@GetMapping(value = "/user")
	public ResponseEntity<UserDTO> getUser(
			@RequestParam("documentNumber") String documentNumber, 
			@RequestHeader HttpHeaders httpHeaders) {
		return ResponseEntity.status(HttpStatus.OK).body(iUserService.getUser(documentNumber));
	}	
	
	@Override
	@PutMapping(value = "/user")
	public ResponseEntity<UserDTO> updateUser(
			@RequestParam("documentNumber") String documentNumber,
			@RequestBody UserDTO userCreationDTO, 
			@RequestHeader HttpHeaders httpHeaders) {
		return ResponseEntity.status(HttpStatus.OK).body(iUserService.updateUser(documentNumber, userCreationDTO));
	}	
	
	@Override
	@DeleteMapping(value = "/user")
	public ResponseEntity<String> deleteUser(
			@RequestParam("documentNumber") String documentNumber, 
			@RequestHeader HttpHeaders httpHeaders) {
		iUserService.deleteUser(documentNumber);
		return ResponseEntity.status(HttpStatus.OK).body("Ok");
	}
}