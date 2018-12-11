package org.nynl.easycopypast.model;

import javax.persistence.*;

@Entity
@Table(name="ROLES")
public class Roles {

    @Id
    @Column(name = "ROLE", nullable = false)
    private String role;

    @ManyToOne
    @JoinColumn(name = "USERNAME")
    private User user;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
