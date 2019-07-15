package zxc.pd.pd.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;
public class CustomMetaObjectHandler implements MetaObjectHandler {
    private Logger logger = LoggerFactory.getLogger(CustomMetaObjectHandler.class);

    @Override
    public void insertFill(MetaObject metaObject) {
        try {
            Object createTime = getFieldValByName("createTime", metaObject);
            Object updateTime = getFieldValByName("updateTime", metaObject);
            Object delTag = getFieldValByName("deleted", metaObject);

            LocalDateTime time = LocalDateTime.now();
            if (null == createTime) {
                setFieldValByName("createTime", time, metaObject);
            }
            if (null == updateTime) {
                setFieldValByName("updateTime", time, metaObject);
            }
            if (null == delTag) {
                setFieldValByName("deleted", 0, metaObject);
            }
        } catch (Exception e) {
            logger.warn(e.getMessage(), e);
        }
    }
    @Override
    public void updateFill(MetaObject metaObject) {
        try {
            Object updateTime = getFieldValByName("updateTime", metaObject);
            if (null == updateTime) {
                setFieldValByName("updateTime", LocalDateTime.now(), metaObject);
            }
        } catch (Exception e) {
            logger.warn(e.getMessage(), e);
        }
    }


}
