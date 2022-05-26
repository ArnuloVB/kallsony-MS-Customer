package co.com.pica.customer.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.pica.customer.RSA.RSA;
import co.com.pica.customer.domain.UserDTO;
import co.com.pica.customer.entity.User;
import co.com.pica.customer.mapper.UserMapper;
import co.com.pica.customer.repository.UserRepository;
import co.com.pica.customer.service.IUserService;
import static co.com.pica.customer.util.Utility.copyPropertiesIgnoreNull;


@Service
public class UserService implements IUserService{
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public UserDTO addUser(UserDTO userCreationDTO) throws Exception {		
		String password = userCreationDTO.getPassword();
		RSA rsaEncryption = new RSA();
		rsaEncryption.genKeyPair(512);      
		rsaEncryption.saveToDiskPrivateKey("/tmp/rsa.pri");
        rsaEncryption.saveToDiskPublicKey("/tmp/rsa.pri");
	
        String secure = rsaEncryption.Encrypt(password);       
        userCreationDTO.setPassword(secure);
               
		User user = userMapper.userDTOtoUser(userCreationDTO);		
		userRepository.save(user);		
		return userCreationDTO;
	}
	
	@Override
	public UserDTO getUser(String documentNumber) {			
		return userMapper.usertoUserDTO(userRepository.findByDocumentNumber(documentNumber));
	}
	
	@Override
	public UserDTO updateUser(String documentNumber, UserDTO userCreationDTO) {		
		User user = userRepository.findByDocumentNumber(documentNumber);
		User userDetail = userMapper.userDTOtoUser(userCreationDTO);
		copyPropertiesIgnoreNull(userDetail, user);
		User userUpdated = userRepository.save(user);
		return userMapper.usertoUserDTO(userUpdated);		
	}
	
	@Override
	public UserDTO deleteUser(String documentNumber) {
		User user = userRepository.findByDocumentNumber(documentNumber);
		userRepository.delete(user);
		return null;
	}
	
}