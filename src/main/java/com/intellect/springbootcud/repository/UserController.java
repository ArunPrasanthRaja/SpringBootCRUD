package com.intellect.springbootcud.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;



import javax.validation.Valid;
import java.util.List;

/**
 * This controller provides the public API that is used to manage the information
 * of user entries.
 * @author Arun
 */
@RestController
@RequestMapping("/api/todo")
final class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    private final UserService service;

    @Autowired
    UserController(UserService service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    UserDTO create(@RequestBody @Valid UserDTO userEntry) {
        LOGGER.info("Creating a new user entry with information: {}", userEntry);
        UserDTO created;
        if(!service.checkUserALreadyExist(userEntry.getEmail())){
        	created= service.create(userEntry);
        LOGGER.info("Created a new user entry with information: {}", created);
        }
        else{
        	throw new IllegalArgumentException("The 'eamil' has already registered with another user");
        }
        return created;
    }

   
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    UserDTO delete(@PathVariable("id") String id) {
        LOGGER.info("Deleting user entry with id: {}", id);

        UserDTO deleted = service.delete(id);
        LOGGER.info("Deleted user entry with information: {}", deleted);

        return deleted;
    }

    @RequestMapping(method = RequestMethod.GET)
    List<UserDTO> findAll() {
        LOGGER.info("Finding all user entries");

        List<UserDTO> userEntries = service.findAll();
        LOGGER.info("Found {} user entries", userEntries.size());

        return userEntries;
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    UserDTO findById(@PathVariable("id") String id) {
        LOGGER.info("Finding user entry with id: {}", id);

        UserDTO userEntry = service.findById(id);
        LOGGER.info("Found user entry with information: {}", userEntry);

        return userEntry;
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    UserDTO update(@RequestBody @Valid UserDTO userEntry) {
        LOGGER.info("Updating user entry with information: {}", userEntry);

        UserDTO updated = service.update(userEntry);
        LOGGER.info("Updated user entry with information: {}", updated);

        return updated;
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void handleUserNotFound(UserNotFoundException ex) {
        LOGGER.error("Handling error with message: {}", ex.getMessage());
    }
}
