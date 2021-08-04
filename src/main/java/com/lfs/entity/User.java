package com.lfs.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

/**
 * user
 * @author 
 */
@ApiModel(value="com.lfs.entity.User")
@Data
public class User implements Serializable {
    private Integer id;

    private String name;

    private Integer age;

    private String remark;

    private Integer sex;

    private static final long serialVersionUID = 1L;
}