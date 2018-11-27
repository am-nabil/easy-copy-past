package org.nynl.easycopypast.model;

import javax.persistence.*;

@Entity
@Table(name="COPY")
public class Copy {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    @Column(name = "MACHINE_IP", nullable = false)
    private String machineIP;
    @Column(name = "CONTENT", nullable = false)
    private String content;
    @Column(name = "USER_ID", nullable = false)
    private String userId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMachineIP() {
        return machineIP;
    }

    public void setMachineIP(String machineIP) {
        this.machineIP = machineIP;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
