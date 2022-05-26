package co.com.pica.customer.service;

import co.com.pica.customer.domain.UserDTO;

public interface IUserService {
	
	UserDTO addUser(UserDTO userCreationDTO) throws Exception;
	UserDTO getUser(String documentNumber);
	UserDTO updateUser(String documentNumber, UserDTO userCreationDTO);
	UserDTO deleteUser(String documentNumber);	

}