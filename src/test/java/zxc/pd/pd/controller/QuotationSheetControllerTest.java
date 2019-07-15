package zxc.pd.pd.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import zxc.pd.pd.service.QuotationSheetService;
import zxc.pd.pd.vo.QuotationSheetVo;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QuotationSheetControllerTest {

    @Autowired
    private QuotationSheetService quotationSheetService;

    @Test
    public void save() {
        List<QuotationSheetVo> quotationSheetVos = quotationSheetService.findByAreaName("乌鲁木齐县");
        System.out.println("quotationSheetVos = " + quotationSheetVos);
    }
}