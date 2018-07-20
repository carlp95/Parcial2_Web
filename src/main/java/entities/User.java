package entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class User implements Serializable {

    @Id
    private String username;

    /*private String name;

    private String lastname;

    private Date borndate;

    private String placeborn;

    private String cityborn;

    private String password;

    private boolean isAdministrator;

    private boolean isFriend;

    @OneToMany
    private List<EstudyPlace> estudyPlace;

    @OneToMany
    private List<WorkPLace> workPlace;

    private List<String> interests;

    @OneToMany
    private List<Notification> notificationList;

    @OneToMany(mappedBy = "user")
    private List<Comment> commentList;

    @OneToMany(mappedBy = "user")
    private List<UserPost> userPostList;

    @OneToMany(mappedBy = "user")
    private List<CommentVote> commentVoteList;
*/
    public User() {
    }


}
