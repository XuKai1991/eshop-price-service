package com.eshop.eshoppriceservice.utils;

import lombok.Data;

/**
 * @author: Xukai
 * @description:
 * @createDate: 2018/7/23 17:00
 * @modified By:
 */
@Data
public class ResultVO {

    /**
     * 状态
     */
    private Integer status;

    /**
     * 提示信息.
     */
    private String message;

    /**
     * 具体内容.
     */
    private Object data;

    private ResultVO(Integer status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    private ResultVO(Object data) {
        this.status = 200;
        this.message = "success";
        this.data = data;
    }

    public ResultVO() {
    }

    public static ResultVO build(Integer status, String message, Object data) {
        return new ResultVO(status, message, data);
    }

    public static ResultVO build(Integer status, String message) {
        return new ResultVO(status, message, null);
    }

    public static ResultVO success(Object data) {
        return new ResultVO(data);
    }

    public static ResultVO success() {
        return new ResultVO(null);
    }

    public static ResultVO failure() {
        return ResultVO.build(500, "failure");
    }
}
