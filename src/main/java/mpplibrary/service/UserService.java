package mpplibrary.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mpplibrary.model.User;
import mpplibrary.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public User createUser(String firstName, String lastName, String password) {
		User user = new User();
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setPassword(password);
		return userRepository.save(user);
	}
}
