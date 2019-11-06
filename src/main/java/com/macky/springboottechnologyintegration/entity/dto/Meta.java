package com.macky.springboottechnologyintegration.entity.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author Macky
 * @Title class Meta
 * @Description: TODO
 * @date 2019/11/6 10:09
 */
@Data
@ApiModel(value = "返回结果详情")
public class Meta {
    @ApiModelProperty(value = "返回状态", notes = "ok 成功，error 失败")
    private boolean success;
    @ApiModelProperty(value = "返回说明", notes = "返回状态对应说明")
    private String message;
    @ApiModelProperty(value = "执行时间", notes = "当前执行时间")
    private String timestamp;

    public Meta(boolean success) {
        this.success = success;
        this.message = "成功";
        this.timestamp = LocalDateTime.now().toString();
    }

    public Meta(boolean success, String message) {
        this.success = success;
        this.message = message;
        this.timestamp = LocalDateTime.now().toString();
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }
}