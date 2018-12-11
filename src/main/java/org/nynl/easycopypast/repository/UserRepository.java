package org.nynl.easycopypast.repository;

import org.nynl.easycopypast.model.User;

public interface UserRepository {

    User getUserByUsername(String username);
}
