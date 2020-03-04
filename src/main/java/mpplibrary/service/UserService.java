package mpplibrary.service;

import mpplibrary.exception.InvalidLoginException;
import mpplibrary.model.Role;
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

	public User checkLogin(String userId, String password) throws Exception {
		try {
			Long userIdValue = Long.valueOf(userId);
			return userRepository.findById(userIdValue).orElseThrow(InvalidLoginException::new);
		} catch (NumberFormatException ex){
			throw new InvalidLoginException("UserId must be a number");
		}
	}

}


