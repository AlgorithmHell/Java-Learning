package model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="enabling_status")
public class EnableStatus {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name="status")
    private String status;

    @ManyToMany(mappedBy = "enabling_status")
    private Set<User> users;

    public EnableStatus() {
    }

    public EnableStatus(int id, String status, Set<User> users) {
        this.id=id;
        this.status = status;
        this.users = users;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
