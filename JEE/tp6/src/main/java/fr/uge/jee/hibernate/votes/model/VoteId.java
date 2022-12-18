package fr.uge.jee.hibernate.votes.model;


import java.io.Serializable;
import java.util.Objects;

public class VoteId implements Serializable {
    private final String username;
    private final String video;


    public VoteId(String username, String video) {
        super();
        this.username = username;
        this.video = video;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VoteId voteId = (VoteId) o;
        return username.equals(voteId.username) && video.equals(voteId.video);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, video);
    }
}
