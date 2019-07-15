package zxc.pd.pd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zxc.pd.pd.service.QuotationSheetService;
import zxc.pd.pd.vo.QuotationSheetVo;

import java.util.List;


@RestController
@RequestMapping("/quotationSheetDate")
public class QuotationDateController {

    @Autowired
    private QuotationSheetService quotationSheetService;

    @GetMapping("/getProvince")
    public List<String> getProvince(){
        return quotationSheetService.getProvice();
    }

    @GetMapping("/getCountyByProvince")
    public List<String> getCountyByProvince(String province){
        return quotationSheetService.getCountyByProvince(province);
    }

    @GetMapping("/getDistrictByCounty")
    public List<String> getDistrictByCounty(String county){
        return quotationSheetService.getDistrictByCounty(county);
    }

    @GetMapping("/findByAreaName")
    public List<QuotationSheetVo> findByAreaName(String areaName){
        return quotationSheetService.findByAreaName(areaName);
    }

}
