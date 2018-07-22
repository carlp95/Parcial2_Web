package entities;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Image {
    @Id
    @GeneratedValue
    private long id;

    private String path;

    private String description;

    private User user;

    public Image() {
    }

    public Image(String path, String description, User user) {
        this.path = path;
        this.description = description;
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
