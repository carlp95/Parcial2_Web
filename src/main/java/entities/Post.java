package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
public class Post {
    @Id
    @GeneratedValue
    private long id;

    private String content;

    private Date date;

    @ManyToOne
    private User user;

}
