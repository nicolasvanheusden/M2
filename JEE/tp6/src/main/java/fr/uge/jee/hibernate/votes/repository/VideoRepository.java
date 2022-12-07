package fr.uge.jee.hibernate.votes.repository;

import fr.uge.jee.hibernate.utils.PersistenceUtils;
import fr.uge.jee.hibernate.votes.model.User;
import fr.uge.jee.hibernate.votes.model.Video;

import javax.persistence.EntityManagerFactory;
import java.util.Objects;
import java.util.Optional;

public class VideoRepository {
    private final EntityManagerFactory entityManagerFactory = PersistenceUtils.getEntityManagerFactory();

    /**
     * Create a video with the given information
     * @param name the video's name
     * @return the id of the newly created video
     */
    public long create(String name) {
        return PersistenceUtils.inTransaction((em) -> {
            var video = new Video(name);
            em.persist(video);
            return video.getId();
        });
    }

    /**
     * Remove the video with the given id from the DB
     * @param id
     * @return true if the removal was successful
     */
    public boolean delete(long id) {
        return PersistenceUtils.inTransaction((em) -> {
            var video = em.find(Video.class, id);
            if (video == null) {
                return false;
            }
            em.remove(video);
            return true;
        });
    }


    /**
     * update the video when the user downVote a video
     * @param id video id
     * @param user the voter
     * @return true if the update was successful
     */
    public boolean downVote(long id, User user) {
        Objects.requireNonNull(user);
        return PersistenceUtils.inTransaction((em) -> {
            var video = em.find(Video.class, id);
            if (video == null) {
                return false;
            }
            video.incrementScore(false, user);
            return true;
        });
    }

    /**
     * update the video when the user upVote a video
     * @param id video id
     * @param user the voter
     * @return true if the update was successful
     */
    public boolean upVote(long id, User user) {
        Objects.requireNonNull(user);
        return PersistenceUtils.inTransaction((em) -> {
            var video = em.find(Video.class, id);
            if (video == null) {
                return false;
            }
            video.incrementScore(true, user);
            return true;
        });
    }


    /**
     * update the video when the user cancels a Vote a
     * @param id video id
     * @param user the voter
     * @return true if the removal was successful
     */
    public boolean cancelVote(long id, User user) {
        Objects.requireNonNull(user);
        return PersistenceUtils.inTransaction((em) -> {
            var video = em.find(Video.class, id);
            if (video == null) {
                return false;
            }
            video.cancelUpVote(user);
            return true;
        });
    }


    /**
     * Retrieve the video with the given id
     * @param id
     * @return the video wrapped in an {@link Optional}
     */
    public Optional<Video> get(long id) {
        return PersistenceUtils.inTransaction((em) -> {
            var video = em.find(Video.class, id);
            return video == null ? Optional.empty() : Optional.of(video);
        });
    }
}
