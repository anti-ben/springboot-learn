package com.anti.springbootsql.domain;

import com.sun.istack.NotNull;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;


@Entity
@Table(name = "user")
@Data
@NoArgsConstructor
@ApiModel(description = "用户实体")
public class User implements Serializable {

    @Column(name = "id")
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty(value = "用户编号", position = 1)
    private Integer id;

    @NotNull
    @Size(min = 2, max = 18)
    @ApiModelProperty(value = "用户姓名", position = 2)
    private String name;

    @NotNull
    @Min(0)
    @Max(50)
    @ApiModelProperty(value = "用户年龄", position = 3)
    private Integer age;

}
