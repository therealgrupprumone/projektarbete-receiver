package se.iths.projektarbete.dto;

import java.io.Serializable;

public class EmailNotification implements Serializable {
    private String username;
    private String email;

    public EmailNotification(String username, String email) {
        this.username = username;
        this.email = email;
    }

    public EmailNotification() {
    }

    @Override
    public String toString() {
        return "EmailNotification{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }
}
