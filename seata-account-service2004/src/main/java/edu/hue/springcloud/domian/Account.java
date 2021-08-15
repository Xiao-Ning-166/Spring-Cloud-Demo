package edu.hue.springcloud.domian;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 47552
 * @date 2021/08/15
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    private Long id;
    /**
     * 用户 id
     */
    private Long userId;
    /**
     * 用户 总金额
     */
    private Integer total;
    /**
     * 用户 已用金额
     */
    private Integer used;
    /**
     * 用户 剩余金额
     */
    private Integer residue;
}
