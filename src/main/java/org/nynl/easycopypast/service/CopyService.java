package org.nynl.easycopypast.service;

import org.nynl.easycopypast.model.Copy;

import java.util.List;

public interface CopyService {

    List<Copy> getcopies();

    void copy(String username, String content, String machine_ip);

    String paste(String username);
}
