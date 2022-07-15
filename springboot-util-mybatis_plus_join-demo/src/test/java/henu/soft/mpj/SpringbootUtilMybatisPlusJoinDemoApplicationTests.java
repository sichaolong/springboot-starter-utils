package henu.soft.mpj;

import henu.soft.mpj.service.DemoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@SpringBootTest
class SpringbootUtilMybatisPlusJoinDemoApplicationTests {

    @Test
    void contextLoads() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection m_connection = DriverManager.getConnection("jdbc:mysql://localhost","root","720720");
    }

    @Autowired
    DemoService demoService;

    @Test
    void test1(){
        demoService.getOrder();
    }
}
