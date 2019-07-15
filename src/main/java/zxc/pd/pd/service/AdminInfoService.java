package zxc.pd.pd.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import zxc.pd.pd.model.AdminInfo;
import zxc.pd.pd.mapper.AdminInfoMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import zxc.pd.pd.model.QuotationSheet;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zxccong
 * @since 2019-07-11
 */
@Service
public class AdminInfoService extends ServiceImpl<AdminInfoMapper, AdminInfo> implements IService<AdminInfo> {

    public AdminInfo getByUserName(String username){
        QueryWrapper<AdminInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",username);
        return getOne(queryWrapper);

    }



}
