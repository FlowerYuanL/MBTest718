package com.lsxp.pojo;

import com.lsxp.annotation.Updatable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Post  implements Serializable {
    private int id;

    private int userId;

    @Updatable
    private String content;
}

