package org.anti.springbootdemo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

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

    @NotBlank
    @Length(min = 6, max = 20)
    private String password;

    @NotNull
    @Min(0)
    @Max(50)
    private Integer age;

    @NotNull
    @Email
    private String email;

}
