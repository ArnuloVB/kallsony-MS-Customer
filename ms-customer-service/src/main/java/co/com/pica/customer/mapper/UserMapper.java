package co.com.pica.customer.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import co.com.pica.customer.domain.UserDTO;
import co.com.pica.customer.entity.User;

@Mapper(componentModel = "spring")
public interface UserMapper {

	@Mappings({
		@Mapping(target = "dob", source = "dateOfBirth")
	})
	
	User userDTOtoUser(UserDTO userCreationDTO);
	
	@Mappings({
		@Mapping(target = "dateOfBirth", source = "dob")
	})
	UserDTO usertoUserDTO(User user);
}