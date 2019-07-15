package zxc.pd.pd.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import zxc.pd.pd.model.QuotationSheet;
import zxc.pd.pd.mapper.QuotationSheetMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import zxc.pd.pd.util.Money;
import zxc.pd.pd.vo.QuotationSheetVo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 物流报价表 服务实现类
 * </p>
 *
 * @author zxccong
 * @since 2019-07-02
 */
@Service
public class QuotationSheetService extends ServiceImpl<QuotationSheetMapper, QuotationSheet>  {

    public List<QuotationSheetVo> findByAreaName(String areaName){
        QueryWrapper<QuotationSheet> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotBlank(areaName)) {
            queryWrapper.or().like("province","%"+areaName+"%");
        }
        if (StringUtils.isNotBlank(areaName)) {
            queryWrapper.or().like("county","%"+areaName+"%");
        }
        if (StringUtils.isNotBlank(areaName)) {
            queryWrapper.or().like("district","%"+areaName+"%");
        }
        List<QuotationSheet> list = this.list(queryWrapper);
        return changToVoList(list);
    }

    /**
     * 获得所有的省份列表
     * @return
     */
    public List<String> getProvice(){
        QueryWrapper<QuotationSheet> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("province").groupBy("province");
        List<QuotationSheet> list = this.list(queryWrapper);
        List<String> collect = list.stream().map(QuotationSheet::getProvince).collect(Collectors.toList());
        return collect;

    }

    /**
     * 根据省名获得市名列表
     * @param province
     * @return
     */
    public List<String> getCountyByProvince(String province){
        QueryWrapper<QuotationSheet> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("county").eq("province",province).groupBy("province","county");
        List<QuotationSheet> list = this.list(queryWrapper);
        List<String> collect = list.stream().map(QuotationSheet::getCounty).collect(Collectors.toList());
        return collect;
    }

    /**
     * 根据市获得区名列表
     * @param county
     * @return
     */
    public List<String> getDistrictByCounty(String county){
        QueryWrapper<QuotationSheet> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("district").eq("county",county).groupBy("province","county","district");
        List<QuotationSheet> list = this.list(queryWrapper);
        List<String> collect = list.stream().map(QuotationSheet::getCounty).collect(Collectors.toList());
        return collect;
    }

    /**
     * 转换列表为pojo
     * @param quotationSheetVos
     * @return
     */
    public List<QuotationSheet> changToPojoList(List<QuotationSheetVo> quotationSheetVos){
        ArrayList<QuotationSheet> quotationSheets = new ArrayList<>();
        for (QuotationSheetVo quotationSheetVo : quotationSheetVos) {
            quotationSheets.add(changToPojo(quotationSheetVo));
        }
        return quotationSheets;
    }

    /**
     * 将Vo转换为pojo
     * @param quotationSheetVo
     * @return
     */
    public QuotationSheet changToPojo(QuotationSheetVo quotationSheetVo){
        QuotationSheet quotationSheet = new QuotationSheet();
        BeanUtils.copyProperties(quotationSheetVo,quotationSheet);
        if (quotationSheetVo.getSoftPrice()!=null){
            quotationSheet.setSoftPrice(Money.YuanToCent(quotationSheetVo.getSoftPrice()));
        }
        if (quotationSheetVo.getPlankPrice()!=null) {
            quotationSheet.setPlankPrice(Money.YuanToCent(quotationSheetVo.getPlankPrice()));
        }
        if (quotationSheetVo.getTeaTablePrice()!=null) {
            quotationSheet.setTeaTablePrice(Money.YuanToCent(quotationSheetVo.getTeaTablePrice()));
        }
        if (quotationSheetVo.getTelevisionPrice()!=null) {
            quotationSheet.setTelevisionPrice(Money.YuanToCent(quotationSheetVo.getTelevisionPrice()));
        }
        if (quotationSheetVo.getDiningTablePrice()!=null) {
            quotationSheet.setDiningTablePrice(Money.YuanToCent(quotationSheetVo.getDiningTablePrice()));
        }
        if (quotationSheetVo.getDownstairsPrice()!=null) {
            quotationSheet.setDownstairsPrice(Money.YuanToCent(quotationSheetVo.getDownstairsPrice()));
        }
        return quotationSheet;
    }

    /**
     * 转换列表为vo
     * @param quotationSheets
     * @return
     */
    public List<QuotationSheetVo> changToVoList(List<QuotationSheet> quotationSheets){
        ArrayList<QuotationSheetVo> quotationSheetVos = new ArrayList<>();
        for (QuotationSheet quotationSheet : quotationSheets) {
            quotationSheetVos.add(changeToVo(quotationSheet));
        }
        return quotationSheetVos;
    }

    /**
     * 转换单个实体类为VO
     * @param quotationSheet
     * @return
     */
    public QuotationSheetVo changeToVo(QuotationSheet quotationSheet){
        QuotationSheetVo quotationSheetVo = new QuotationSheetVo();
        BeanUtils.copyProperties(quotationSheet,quotationSheetVo);
        if (quotationSheet.getSoftPrice()!=null){
            quotationSheetVo.setSoftPrice(Money.CentToYuan(quotationSheet.getSoftPrice()).getAmount());
        }
        if (quotationSheet.getPlankPrice()!=null) {
            quotationSheetVo.setPlankPrice(Money.CentToYuan(quotationSheet.getPlankPrice()).getAmount());
        }
        if (quotationSheet.getTeaTablePrice()!=null) {
            quotationSheetVo.setTeaTablePrice(Money.CentToYuan(quotationSheet.getTeaTablePrice()).getAmount());
        }
        if (quotationSheet.getTelevisionPrice()!=null) {
            quotationSheetVo.setTelevisionPrice(Money.CentToYuan(quotationSheet.getTelevisionPrice()).getAmount());
        }
        if (quotationSheet.getDiningTablePrice()!=null) {
            quotationSheetVo.setDiningTablePrice(Money.CentToYuan(quotationSheet.getDiningTablePrice()).getAmount());
        }
        if (quotationSheet.getDownstairsPrice()!=null) {
            quotationSheetVo.setDownstairsPrice(Money.CentToYuan(quotationSheet.getDownstairsPrice()).getAmount());
        }
        return quotationSheetVo;
    }

}
