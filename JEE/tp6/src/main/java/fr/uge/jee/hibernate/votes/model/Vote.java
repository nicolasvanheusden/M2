package fr.uge.jee.hibernate.votes.model;

import javax.persistence.*;

@Entity
@IdClass(VoteId.class)
public class Vote {

    @Id
    @ManyToOne(fetch= FetchType.LAZY)
    private String name;

    @Id
    @ManyToOne(fetch=FetchType.LAZY)
    private String video;

    private VoteType voteType;

    public Vote() {
    }

    public Vote(String name, String video) {
        this.name = name;
        this.video = video;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }
}
