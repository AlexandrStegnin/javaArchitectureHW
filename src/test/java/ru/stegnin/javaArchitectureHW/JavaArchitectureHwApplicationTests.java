package ru.stegnin.javaArchitectureHW;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.stegnin.javaArchitectureHW.HW1.builder.Builder;
import ru.stegnin.javaArchitectureHW.HW1.entity.User;
import ru.stegnin.javaArchitectureHW.HW3.*;

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

    @Test
    public void testCheckUser() {
        Server server = new Server();
        server.register("admin@example.com", "admin_pass");
        server.register("user@example.com", "user_pass");
        Middleware middleware = new UserExistsMiddleware(server);
        middleware.linkWith(new RoleCheckMiddleware());
        server.setMiddleware(middleware);
        Assert.assertTrue(server.logIn("admin@example.com", "admin_pass"));
    }

}
