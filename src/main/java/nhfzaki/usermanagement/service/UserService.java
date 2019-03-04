package nhfzaki.usermanagement.service;

import nhfzaki.usermanagement.model.User;
import nhfzaki.usermanagement.model.details.UserDetails;
import nhfzaki.usermanagement.model.identification.UserIdentification;
import nhfzaki.usermanagement.repository.details.UserDetailsRepository;
import nhfzaki.usermanagement.repository.identification.UserIdentificationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author nhf-zaki on 3/3/19
 */
@Service
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    UserIdentificationRepository identificationRepository;

    @Autowired
    UserDetailsRepository detailsRepository;

    public List<User> getUsersByUsername(String username) {

        List<User> users = new ArrayList<>();
        UserIdentification userIdentification = identificationRepository.findByUsername(username);
        users.add(getCompleteUserByUserIdentification(userIdentification));

        return users;
    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        identificationRepository.findAll().forEach(userIdentification ->
                users.add(getCompleteUserByUserIdentification(userIdentification))
        );

        return users;
    }

    public boolean createUser(User user) {
        if (null == identificationRepository.findByUsername(user.getUsername())) {
            UserIdentification identification = new UserIdentification();
            identification.setUsername(user.getUsername());
            identification.setEmail(user.getEmail());
            UserDetails details = new UserDetails();
            details.setUsername(identification.getUsername());
            details.setFirstName(user.getFirstName());
            details.setLastName(user.getLastName());
            details.setAge(user.getAge());
            details.setAddress(user.getAddress());

            identificationRepository.save(identification);
            detailsRepository.save(details);

            return true;
        } else {
            return false;
        }
    }

    private User getCompleteUserByUserIdentification(UserIdentification userIdentification) {
        if (userIdentification != null) {
            UserDetails userDetails = detailsRepository.findByUsername(userIdentification.getUsername());

            return new User(
                    userIdentification.getId(),
                    userIdentification.getUsername(),
                    userIdentification.getEmail(),
                    userDetails.getFirstName(),
                    userDetails.getLastName(),
                    userDetails.getAge(),
                    userDetails.getAddress()
            );
        } else {
            return null;
        }
    }

}
