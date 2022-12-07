package fr.uge.jee.hibernate.votes.model;

import java.util.Set;

public class Video {

    private long upVotes;
    private long downVotes;

    private Set<User> users;
}
