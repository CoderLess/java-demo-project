package com.ibn.demo.common;

import lombok.Data;
import org.springframework.http.HttpStatus;

/**
 * @version 1.0
 * @description:
 * @projectName：demo
 * @see: com.ibn.demo.common
 * @author： RenBin
 * @createTime：2020/12/10 13:37
 */
@Data
public class ResultInfo {
    /**
     * @description: 状态码
     * @author：RenBin
     * @createTime：2020/12/10 13:39
     */
    private Integer status;
    /**
     * @description: 提示信息
     * @author：RenBin
     * @createTime：2020/12/10 13:39
     */
    private String message;
    /**
     * @description: 返回数据
     * @author：RenBin
     * @createTime：2020/12/10 13:39
     */
    private Object data;

    public ResultInfo success() {
        this.status = HttpStatus.OK.value();
        this.message = HttpStatus.OK.getReasonPhrase();
        return this;
    }

    public ResultInfo success(Object data) {
        this.status = HttpStatus.OK.value();
        this.message = HttpStatus.OK.getReasonPhrase();
        this.data = data;
        return this;
    }

    public ResultInfo error() {
        this.status = HttpStatus.INTERNAL_SERVER_ERROR.value();
        this.message = HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase();
        return this;
    }

    public ResultInfo error(String message) {
        this.status = HttpStatus.INTERNAL_SERVER_ERROR.value();
        this.message = message;
        return this;
    }
}
