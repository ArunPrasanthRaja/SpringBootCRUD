package com.intellect.springbootcud.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

/**
 * This service class saves {@link com.intellect.springbootcud.repository.User} objects
 * to MongoDB database.
 * @author Arun
 */
@Service
final class MongoDBUserService implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MongoDBUserService.class);

    private final UserRepository repository;

    @Autowired
    MongoDBUserService(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDTO create(UserDTO user) {
        LOGGER.info("Creating a new User entry with information: {}", user);

        User persisted = User.getBuilder(user.getfName(),user.getEmail())
                .birthDate(user.getBirthDate()).lastName(user.getlName()).pinCode(user.getPinCode()).isActive(user.getIsActive())
                .build();
       
        persisted = repository.save(persisted);
        LOGGER.info("Created a new user entry with information: {}", persisted);

        return convertToDTO(persisted);
    }
    
    @Override
    public Boolean checkUserALreadyExist(String email){
    	User usr=repository.findByEmailAndIsActive(email, true);
    	if(usr!=null){
    		return true;
    	}
    	return false;
    	
    }

    @Override
    public UserDTO delete(String id) {
        LOGGER.info("Deleting a user entry with id: {}", id);

        User deleted = findUserById(id);
        repository.delete(deleted);

        LOGGER.info("Deleted user entry with informtation: {}", deleted);

        return convertToDTO(deleted);
    }

    @Override
    public List<UserDTO> findAll() {
        LOGGER.info("Finding all user entries.");

        List<User> userEntries = repository.findAll();

        LOGGER.info("Found {} user entries", userEntries.size());

        return convertToDTOs(userEntries);
    }

    private List<UserDTO> convertToDTOs(List<User> models) {
        return models.stream()
                .map(this::convertToDTO)
                .collect(toList());
    }

    @Override
    public UserDTO findById(String id) {
        LOGGER.info("Finding user entry with id: {}", id);

        User found = findUserById(id);

        LOGGER.info("Found user entry: {}", found);

        return convertToDTO(found);
    }

    @Override
    public UserDTO update(UserDTO user) {
        LOGGER.info("Updating user entry with information: {}", user);

        User updated = findUserById(user.getId());
        updated.update(user.getPinCode(),user.getBirthDate());
        updated = repository.save(updated);

        LOGGER.info("Updated user entry with information: {}", updated);

        return convertToDTO(updated);
    }

    private User findUserById(String id) {
        Optional<User> result = repository.findOne(id);
        return result.orElseThrow(() -> new UserNotFoundException(id));

    }

    private UserDTO convertToDTO(User model) {
        UserDTO dto = new UserDTO();

        dto.setId(model.getId());
        dto.setfName(model.getfName());
        dto.setlName(model.getlName());
        dto.setEmail(model.getEmail());
        dto.setBirthDate(model.getBirthDate());
        dto.setPinCode(model.getPinCode());
        dto.setIsActive(model.getIsActive());

        return dto;
    }
}
