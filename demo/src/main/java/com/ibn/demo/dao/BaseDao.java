package com.ibn.demo.dao;

import java.util.List;

/**
 * @version 1.0
 * @description:
 * @projectName：demo
 * @see: com.ibn.demo.dao
 * @author： RenBin
 * @createTime：2020/12/10 12:40
 */
public interface BaseDao<T> {
    /**
     * @description: 保存数据
     * @author：RenBin
     * @createTime：2020/12/10 12:43
     */
    Long save(T t);
    /**
     * @description: 批量保存数据
     * @author：RenBin
     * @createTime：2020/12/10 12:43
     */
    Long saveBatch(List<T> list);
    /**
     * @description: 通过id更新数据
     * @author：RenBin
     * @createTime：2020/12/10 12:44
     */
    Integer updateById(T t);
    /**
     * @description: 根据id删除数据
     * @author：RenBin
     * @createTime：2020/12/10 12:44
     */
    Integer deleteById(Long id);
    /**
     * @description: 通过id查询数据
     * @author：RenBin
     * @createTime：2020/12/10 12:44
     */
    T queryById(Long id);
    /**
     * @description: 通过条件查询数据
     * @author：RenBin
     * @createTime：2020/12/10 12:44
     */
    List<T> queryList(T t);

}
