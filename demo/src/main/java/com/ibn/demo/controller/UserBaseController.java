package com.ibn.demo.controller;

import com.ibn.demo.common.ResultInfo;
import com.ibn.demo.domain.UserBaseDTO;
import com.ibn.demo.service.UserBaseService;
import com.ibn.demo.vo.UserBaseVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
