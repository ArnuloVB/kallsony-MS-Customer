package co.com.pica.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import co.com.pica.customer.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	User findByDocumentNumber(String documentNumber);
	
}