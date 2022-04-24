package org.anti.springbootdemo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

    private Integer id;

    @NotNull
    @Size(min = 2, max = 18)
    private String name;

    @NotNull
    @Min(0)
    @Max(50)
    private Integer age;

}
