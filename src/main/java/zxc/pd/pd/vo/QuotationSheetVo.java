package zxc.pd.pd.vo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 * 物流报价表
 * </p>
 *
 * @author zxccong
 * @since 2019-07-02
 */
@Data
public class QuotationSheetVo extends Model<QuotationSheetVo> {

    @ApiModelProperty("主键id")
    private String id;

    /**
     * 省份
     */
    @ApiModelProperty("省份")
    @NotNull
    private String province;

    /**
     * 市/县
     */

    @ApiModelProperty("市/县")
    private String county;

    /**
     * 区
     */
    @ApiModelProperty("区")
    private String district;

    /**
     * 预计到达时间
     */
    @ApiModelProperty("预计到达时间")
    private String getTime;

    /**
     * 软体价格
     */
    @Min(value = 0,message = "不能小于零")
    @ApiModelProperty("软体价格")
    private BigDecimal softPrice;

    /**
     * 板式
     */
    @Min(value = 0,message = "不能小于零")
    @ApiModelProperty("板式")
    private BigDecimal plankPrice;

    /**
     * 茶几/大理石块
     */
    @Min(value = 0,message = "不能小于零")
    @ApiModelProperty("茶几/大理石块")
    private BigDecimal teaTablePrice;

    /**
     * 电视柜
     */
    @Min(value = 0,message = "不能小于零")
    @ApiModelProperty("电视柜")
    private BigDecimal televisionPrice;

    /**
     * 餐桌/大理石块
     */
    @Min(value = 0,message = "不能小于零")
    @ApiModelProperty("餐桌/大理石块")
    private BigDecimal diningTablePrice;

    /**
     * 送货费到楼下
     */
    @Min(value = 0,message = "不能小于零")
    @ApiModelProperty("送货费到楼下")
    private BigDecimal downstairsPrice;



}
