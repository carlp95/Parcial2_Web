package Entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

enum notificationTypeEnum{
    FriendRequest,
    Message,
    Tagged
}

@Entity
public class Notification implements Serializable {

    @Id
    @GeneratedValue
    private long id;

    private notificationTypeEnum notiType;

    private String description;

    private boolean seen;

    @ManyToOne
    private User user;

    private Date dateNotified;

    public Notification() {
    }

    public Notification(long id, notificationTypeEnum notiType, String description, boolean seen, User user, Date dateNotified) {
        this.id = id;
        this.notiType = notiType;
        this.description = description;
        this.seen = seen;
        this.user = user;
        this.dateNotified = dateNotified;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public notificationTypeEnum getNotiType() {
        return notiType;
    }

    public void setNotiType(notificationTypeEnum notiType) {
        this.notiType = notiType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isSeen() {
        return seen;
    }

    public void setSeen(boolean seen) {
        this.seen = seen;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getDateNotified() {
        return dateNotified;
    }

    public void setDateNotified(Date dateNotified) {
        this.dateNotified = dateNotified;
    }
}
