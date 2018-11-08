package ru.stegnin.javaArchitectureHW;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.stegnin.javaArchitectureHW.HW1.builder.Builder;
import ru.stegnin.javaArchitectureHW.HW1.entity.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JavaArchitectureHwApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Test
    public void buildUserWithGenericBuilder() {
        User user = Builder.get(User.class)
                .with(u -> u.setLogin("Admin"))
                .with(u -> u.setPassword("admin"))
                .get();
        Assert.assertEquals(user.getLogin(), "Admin");
    }

}
