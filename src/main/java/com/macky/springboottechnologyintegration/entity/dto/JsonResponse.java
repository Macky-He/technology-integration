package com.macky.springboottechnologyintegration.entity.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Macky
 * @Title class JsonResponse
 * @Description: TODO
 * @date 2019/11/6 10:21
 */
@Data
@ApiModel(value = "返回结果")
public class JsonResponse<T> {
    private static final String SUCCESS = "ok";
    private static final String ERROR = "error";
    @ApiModelProperty(value = "返回状态和信息", name = "meta")
    private Meta meta;
    @ApiModelProperty(value = "返回数据", name = "data")
    private T data;

    public JsonResponse success() {
        this.meta = new Meta(true, SUCCESS);
        return this;
    }

    public JsonResponse success(T data) {
        this.meta = new Meta(true, SUCCESS);
        this.data = data;
        return this;
    }

    public JsonResponse failure() {
        this.meta = new Meta(false, ERROR);
        return this;
    }

    public JsonResponse failure(String message) {
        this.meta = new Meta(false, message);
        return this;
    }

}
