package com.ibn.demo.util;

import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0
 * @description:
 * @projectName：demo
 * @see: com.ibn.demo.util
 * @author： RenBin
 * @createTime：2020/12/10 13:09
 */
public class BeanUtils {

    private static final Logger logger = LoggerFactory.getLogger(BeanUtils.class);

    /**
     * @description: 属性拷贝
     * @author：RenBin
     * @createTime：2020/12/10 13:10
     */
    public static void copyProperties(Object source, Object target) {
        org.springframework.beans.BeanUtils.copyProperties(source, target);
    }

    /**
     * @description: 集合复制
     * @author：RenBin
     * @createTime：2020/12/10 13:11
     */
    public static <T> List<T> convertList(List<? extends Object> sourceList, Class<T> targetClazz) throws IllegalAccessException, InstantiationException {
        if (sourceList == null) {
            return Lists.newArrayList();
        }
        List<T> targetList = new ArrayList<>();
        for (Object sourceObject : sourceList) {
            T t = targetClazz.newInstance();
            copyProperties(sourceObject, t);
            targetList.add(t);
        }
        return targetList;
    }
}
