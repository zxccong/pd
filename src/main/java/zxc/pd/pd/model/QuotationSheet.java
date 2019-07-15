package zxc.pd.pd.model;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.Version;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 物流报价表
 * </p>
 *
 * @author zxccong
 * @since 2019-07-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class QuotationSheet extends Model<QuotationSheet> {

    private static final long serialVersionUID = 1L;

    private String id;

    /**
     * 省份
     */
    private String province;

    /**
     * 市/西安
     */
    private String county;

    /**
     * 区
     */
    private String district;

    /**
     * 预计到达时间
     */
    private String getTime;

    /**
     * 软体价格
     */
    private Long softPrice;

    /**
     * 板式
     */
    private Long plankPrice;

    /**
     * 茶几/大理石块
     */
    private Long teaTablePrice;

    /**
     * 电视柜
     */
    private Long televisionPrice;

    /**
     * 餐桌/大理石块
     */
    private Long diningTablePrice;

    /**
     * 送货费到楼下
     */
    private Long downstairsPrice;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    @TableField(fill = FieldFill.INSERT)
    @TableLogic
    private Integer deleted;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
