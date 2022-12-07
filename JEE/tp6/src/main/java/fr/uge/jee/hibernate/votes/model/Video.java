package fr.uge.jee.hibernate.votes.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table
public class Video {


    @Id
    @GeneratedValue
    private long id;

    private String name;

    private long upVotes;
    private long downVotes;

    @ManyToMany
    private Set<User> voters;

    public Video() {
    }

    public Video(String name) {
        this.name = name;
        this.voters = new HashSet<>();
        this.downVotes = 0;
        this.upVotes = 0;
    }

    public long getId() {
        return id;
    }

    public Video setId(long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Video setName(String name) {
        this.name = name;
        return this;
    }

    public long getUpVotes() {
        return upVotes;
    }

    public Video setUpVotes(long upVotes) {
        this.upVotes = upVotes;
        return this;
    }

    public long getDownVotes() {
        return downVotes;
    }

    public Video setDownVotes(long downVotes) {
        this.downVotes = downVotes;
        return this;
    }

    public void incrementScore(boolean isUp, User user) {
        Objects.requireNonNull(user);
        if (voters.add(user)) {
            if (isUp) {
                this.upVotes++;
            } else {
                this.downVotes++;
            }
        }
    }

    public void cancelUpVote(User user) {
        Objects.requireNonNull(user);
        if (voters.remove(user)) {
            this.upVotes--;
        }
    }

    public long score() {
        return upVotes - downVotes;
    }
}

