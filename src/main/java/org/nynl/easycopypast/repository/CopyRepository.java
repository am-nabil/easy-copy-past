package org.nynl.easycopypast.repository;

import org.nynl.easycopypast.model.Copy;

import java.util.List;

public interface CopyRepository {

    List<Copy> getCopies();

    void updateOrInsertCopy(String username, String content, String machine_ip);

    Copy paste(String username);
}
