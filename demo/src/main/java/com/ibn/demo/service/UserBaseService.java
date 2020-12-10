package com.ibn.demo.service;

import com.ibn.demo.domain.UserBaseDTO;

import java.util.List;

/**
 * @version 1.0
 * @description:
 * @projectName：demo
 * @see: com.ibn.demo.service
 * @author： RenBin
 * @createTime：2020/12/10 12:36
 */
public interface UserBaseService {

    /**
     * @description: 保存用户信息
     * @author：RenBin
     * @createTime：2020/12/10 12:59
     */
    Long save(UserBaseDTO userBaseDTO);

    /**
     * @description: 批量保存用户信息
     * @author：RenBin
     * @createTime：2020/12/10 13:00
     */
    Long saveBatch(List<UserBaseDTO> userBaseDTOList);

    /**
     * @description: 更新用户信息
     * @author：RenBin
     * @createTime：2020/12/10 13:01
     */
    Integer updateById(UserBaseDTO userBaseDTO);

    /**
     * @description: 根据Id删除用户信息
     * @author：RenBin
     * @createTime：2020/12/10 13:02
     */
    Integer deleteById(Long id);

    /**
     * @description: 通过id查询用户信息
     * @author：RenBin
     * @createTime：2020/12/10 13:03
     */
    UserBaseDTO queryById(Long id);

    /**
     * @description: 通过条件查询用户信息
     * @author：RenBin
     * @createTime：2020/12/10 13:04
     */
    List<UserBaseDTO> queryList(UserBaseDTO userBaseDTO);
}
