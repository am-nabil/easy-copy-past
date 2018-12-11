package org.nynl.easycopypast.model;

import javax.persistence.*;

@Entity
@Table(name="USER")
public class User {

    @Id
    @Column(name = "USERNAME")
    private String username;
    @Column(name = "PASSWORD", nullable = false)
    private String password;
    @Column(name = "ROLE", nullable = false)
    private String role;


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
