package es.santalucia.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import es.santalucia.api.model.User;
import es.santalucia.api.repository.UserRepository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<User> findAll() {
		return userRepository.findAll();
	}

	public User findOne(Integer id) {
		return userRepository.findById(id).get();
	}
	
	@Transactional(readOnly = false)
	public User save(User entity) {
		return userRepository.save(entity);
	}

	@Transactional(readOnly = false)
	public void delete(User entity) {
		userRepository.delete(entity);
	}

}
	
