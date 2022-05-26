package co.com.pica.customer.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

import co.com.pica.customer.domain.UserDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "User")
public interface IUserController {

	@ApiOperation(value = "Create a new User", notes = "This method adds a new User")
	ResponseEntity<UserDTO> addUser(UserDTO userCreationDTO, HttpHeaders httpHeaders) throws Exception;
	
	@ApiOperation(value = "Find a User", notes = "This method adds a new User")
	ResponseEntity<UserDTO> getUser(String documentNumber, HttpHeaders httpHeaders);
	
	@ApiOperation(value = "Update a user", notes = "This method updates a user")
	ResponseEntity<UserDTO> updateUser(String documentNumber, UserDTO userCreationDTO, HttpHeaders httpHeaders);
	
	@ApiOperation(value = "Delete a user", notes = "This method deletes a user")
	ResponseEntity<String> deleteUser(String documentNumber, HttpHeaders httpHeaders);
	
}