package zxc.pd.pd.controller;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.ModelAndView;
import zxc.pd.pd.model.QuotationSheet;
import zxc.pd.pd.service.QuotationSheetService;
import zxc.pd.pd.vo.QuotationSheetVo;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 物流报价表 前端控制器
 * </p>
 *
 * @author zxccong
 * @since 2019-07-02
 */
@Api(description = "用户接口")
@Controller
@RequestMapping("/quotationSheet")
public class QuotationSheetController {

    @Autowired
    private QuotationSheetService quotationSheetService;

    @GetMapping("/list")
    public ModelAndView list(Map<String, Object> map) {


        List<QuotationSheet> list = quotationSheetService.list();
        List<String> provinces = quotationSheetService.getProvice();
        map.put("quotationSheetList", list);
        map.put("provinces", provinces);
        return new ModelAndView("category/list", map);
    }

    @GetMapping("/getByProvince")
    public ModelAndView getByProvince(@RequestParam(defaultValue = "广东省",value = "province") String province, Map<String, Object> map) {
        QueryWrapper<QuotationSheet> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("province",province).orderBy(true,true,"county","district");
        List<QuotationSheet> list = quotationSheetService.list(queryWrapper);
        List<QuotationSheetVo> quotationSheetVos = quotationSheetService.changToVoList(list);
        List<String> provinces = quotationSheetService.getProvice();
        map.put("quotationSheetList", quotationSheetVos);
        map.put("provinces", provinces);

        return new ModelAndView("category/list", map);
    }

    /**
     * 保存/更新
     * @param quotationSheetVo
     * @param bindingResult
     * @param map
     * @return
     */
    @ApiOperation(value = "新增用户" ,  notes="新增注册")
    @PostMapping("/save")
    public ModelAndView save(@Valid QuotationSheetVo quotationSheetVo,
                             BindingResult bindingResult,
                             Map<String, Object> map) {

        @NotNull String province = quotationSheetVo.getProvince();

        if (bindingResult.hasErrors()) {
            map.put("msg", bindingResult.getFieldError().getDefaultMessage());
            map.put("url", "/quotationSheet/getByProvince?province="+province);
            return new ModelAndView("common/error", map);
        }
        QuotationSheet quotationSheet = quotationSheetService.changToPojo(quotationSheetVo);



        QuotationSheet productInfo = new QuotationSheet();
        try {
            //如果productId为空, 说明是新增
            if (!StringUtils.isEmpty(quotationSheet.getId())) {
                quotationSheetService.updateById(quotationSheet);
            } else {
                quotationSheetService.save(quotationSheet);
            }

        } catch (Exception e) {
            map.put("msg", e.getMessage());
            map.put("url", "/quotationSheet/getByProvince?province="+province);
            return new ModelAndView("common/error", map);
        }

        map.put("url", "/quotationSheet/getByProvince?province="+province);
        return new ModelAndView("common/success", map);
    }

    @GetMapping("/index")
    public ModelAndView index(@RequestParam(value = "id", required = false) String id,
                              Map<String, Object> map) {
        if (id != null) {
            QuotationSheet quotationSheet = quotationSheetService.getById(id);
            QuotationSheetVo quotationSheetVo = quotationSheetService.changeToVo(quotationSheet);
            map.put("category", quotationSheetVo);
        }

        return new ModelAndView("category/index", map);
    }


}
