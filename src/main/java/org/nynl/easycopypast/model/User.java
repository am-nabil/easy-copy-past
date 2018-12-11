package org.nynl.easycopypast.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="USERS")
public class User {

    @Id
    @Column(name = "USERNAME")
    private String username;
    @Column(name = "PASSWORD", nullable = false)
    private String password;
    @Column(name = "ENABLED", nullable = false)
    private boolean enabled;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private Set<Roles> roles = new HashSet<>();

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Set<Roles> getRoles() {
        return roles;
    }

    public void setRoles(Set<Roles> roles) {
        this.roles = roles;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
