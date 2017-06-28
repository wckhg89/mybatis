package com.guppy.mybatis.repository.entity;

import lombok.*;

/**
 * Created by kanghonggu on 2017. 6. 25..
 */

@Data
@ToString
@EqualsAndHashCode(of = {"id"})
@NoArgsConstructor
public class User {
    private Long id;

    private String userName;

}
