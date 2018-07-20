package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class FriendRequest implements Serializable {

    @Id
    @GeneratedValue
    private long id;

    private String userFrom;

    private String userRequested;

    private boolean isAccepted;

    public FriendRequest() {
    }

    public FriendRequest(long id, String userFrom, String userRequested, boolean isAccepted) {
        this.id = id;
        this.userFrom = userFrom;
        this.userRequested = userRequested;
        this.isAccepted = isAccepted;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserFrom() {
        return userFrom;
    }

    public void setUserFrom(String userFrom) {
        this.userFrom = userFrom;
    }

    public String getUserRequested() {
        return userRequested;
    }

    public void setUserRequested(String userRequested) {
        this.userRequested = userRequested;
    }

    public boolean isAccepted() {
        return isAccepted;
    }

    public void setAccepted(boolean accepted) {
        isAccepted = accepted;
    }
}
