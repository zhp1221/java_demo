package com.zhanghp.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author: zhanghp
 * @version: 1.0
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Dept implements Serializable {
    private Integer id;
    private String name;
}
