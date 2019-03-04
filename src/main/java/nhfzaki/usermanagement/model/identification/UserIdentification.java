package nhfzaki.usermanagement.model.identification;

import javax.persistence.*;

/**
 * @author nhf-zaki on 3/3/19
 */
@Entity
@Table(name = "user_identification", schema = "db1")
public class UserIdentification {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @Column(name = "username")
    private String username;

    @Column(name = "email")
    private String email;

    public UserIdentification() {
    }

    public UserIdentification(String username, String email) {
        this.username = username;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "UserIdentification{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
