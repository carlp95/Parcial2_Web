package entities;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

public class Album {
    @Id
    @GeneratedValue
    private long id;

    private Date date;

    private User user;

    private String description;

    private Image image;

}
