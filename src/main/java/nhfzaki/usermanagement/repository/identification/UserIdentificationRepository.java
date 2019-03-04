package nhfzaki.usermanagement.repository.identification;

import nhfzaki.usermanagement.model.identification.UserIdentification;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author nhf-zaki on 3/3/19
 */
public interface UserIdentificationRepository extends JpaRepository<UserIdentification, Long> {

    UserIdentification findByUsername(String username);
}
