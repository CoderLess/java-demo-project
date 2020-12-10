package com.ibn.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.ibn.demo.common.ResultInfo;
import com.ibn.demo.domain.UserBaseDTO;
import com.ibn.demo.service.UserBaseService;
import com.ibn.demo.util.BeanUtils;
import com.ibn.demo.vo.UserBaseVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @version 1.0
 * @description:
 * @projectName：demo
 * @see: com.ibn.demo.controller
 * @author： RenBin
 * @createTime：2020/12/10 12:37
 */
@RestController
@RequestMapping("userBase")
public class UserBaseController {

    private static final Logger logger = LoggerFactory.getLogger(UserBaseController.class);

    @Autowired
    private UserBaseService userBaseService;

    @PostMapping("save")
    public ResultInfo save(@RequestBody UserBaseVO userBaseVO) {
        if (null == userBaseVO) {
            return new ResultInfo().error("参数不能为空");
        }
        UserBaseDTO userBaseDTO = new UserBaseDTO();
        BeanUtils.copyProperties(userBaseVO, userBaseDTO);
        Long userId = userBaseService.save(userBaseDTO);
        return new ResultInfo().success(userId);
    }

    @PostMapping("saveBatch")
    public ResultInfo save(@RequestBody List<UserBaseVO> userBaseVOList) {
        if (CollectionUtils.isEmpty(userBaseVOList)) {
            return new ResultInfo().error("参数不能为空");
        }
        List<UserBaseDTO> userBaseDTOList = null;
        try {
            userBaseDTOList = BeanUtils.convertList(userBaseVOList, UserBaseDTO.class);
        } catch (Exception e) {
            String msg = String.format("UserBaseController.save中list转换失败：%s", JSONObject.toJSONString(userBaseDTOList));
            logger.error(msg, e);
        }
        Long userId = userBaseService.saveBatch(userBaseDTOList);
        return new ResultInfo().success(userId);
    }

    @PostMapping("updateById")
    public ResultInfo updateById(@RequestBody UserBaseVO userBaseVO) {
        if (null == userBaseVO) {
            return new ResultInfo().error("参数不能为空");
        }
        UserBaseDTO userBaseDTO = new UserBaseDTO();
        BeanUtils.copyProperties(userBaseVO, userBaseDTO);
        userBaseService.updateById(userBaseDTO);
        return new ResultInfo().success();
    }

    @PostMapping("deleteById")
    public ResultInfo deleteById(Long id) {
        if (null == id) {
            return new ResultInfo().error("参数不能为空");
        }
        userBaseService.deleteById(id);
        return new ResultInfo().success();
    }

    @GetMapping("queryById")
    public ResultInfo queryById(Long id) {
        if (null == id) {
            return new ResultInfo().error("参数不能为空");
        }
        UserBaseDTO userBaseDTO = userBaseService.queryById(id);
        return new ResultInfo().success(userBaseDTO);
    }

    @GetMapping("queryList")
    public ResultInfo queryList(@RequestBody UserBaseVO userBaseVO) {
        if (null == userBaseVO) {
            return new ResultInfo().error("参数不能为空");
        }
        UserBaseDTO userBaseDTO = new UserBaseDTO();
        BeanUtils.copyProperties(userBaseVO, userBaseDTO);
        List<UserBaseDTO> userBaseDTOList = userBaseService.queryList(userBaseDTO);
        return new ResultInfo().success(userBaseDTOList);
    }

}
