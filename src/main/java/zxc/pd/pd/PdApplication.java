package zxc.pd.pd;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("zxc.pd.pd.mapper")//指向你的mapper接口类
public class PdApplication {

    public static void main(String[] args) {
        SpringApplication.run(PdApplication.class, args);
    }

}
