package model;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private int instruction_id;

    @Column
    private Date date;

    @Column
    private String body;

    @ManyToMany(mappedBy = "comment")
    private Set<Instruction> instructions;
}
