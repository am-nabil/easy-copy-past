package service;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BcryptTest {

    @Test
    public void encode () {
        String encoded=new BCryptPasswordEncoder().encode("test");
        System.out.println(encoded);
    }


}


