package nhfzaki.usermanagement.repository.details;

import nhfzaki.usermanagement.model.details.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author nhf-zaki on 3/3/19
 */
public interface UserDetailsRepository extends JpaRepository<UserDetails, String> {
    UserDetails findByUsername(String username);
}
