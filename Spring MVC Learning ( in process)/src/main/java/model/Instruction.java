package model;

import com.sun.javafx.beans.IDProperty;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name="instruction")
public class Instruction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private int userId;

    @Column
    private String name;

    @Column
    private Date date;

    @Column
    private String description;

    @Column
    private String body;

    // Join
    private Set<Comment> comments;

    public Instruction() {
    }

    public Instruction(int userId, String name, Date date, String description, String body) {

        this.userId = userId;
        this.name = name;
        this.date = date;
        this.description = description;
        this.body = body;
    }

    @Override
    public String toString() {
        return "Instruction{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date=" + date +
                ", description='" + description + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
