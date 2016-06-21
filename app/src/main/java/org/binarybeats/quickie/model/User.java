package org.binarybeats.quickie.model;

/**
 * Created by Leamsy on 4/6/2016.
 */
public class User {

    private String profileImage;
    private String username;
    private String status;

    public User() {
    }

    public User(String profileImage, String username, String status) {
        this.profileImage = profileImage;
        this.username = username;
        this.status = status;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
