package zxc.pd.pd.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import zxc.pd.pd.model.AdminInfo;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminInfoServiceTest {

    @Autowired
    private AdminInfoService adminInfoService;

    @Test
    public void getByUserName() {
        AdminInfo adminInfo = new AdminInfo();
        adminInfo.setUsername("admin");
        adminInfo.setPassword("admin");
        adminInfoService.save(adminInfo);
    }
}