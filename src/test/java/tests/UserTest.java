package tests;

import models.User;
import org.testng.annotations.Test;

public class UserTest {

    @Test
    public void userTest(){
        User user = new User.Builder()
                .withEmail("email")
                .withPassword("password")
                .build();

        System.out.println(user.getEmail());
        System.out.println(user.getPassword());
    }
}
