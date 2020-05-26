package com.cloud.work.order.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 描述：订单实体类
 *
 * @ClassName OrderEntity
 * @Author 徐旭
 * @Date 2020-05-25 16:53
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class OrderEntity {
    /**
     * 编号
     */
    private Long id = 1L;

    /**
     * 商品名称
     */
    private String name = "快餐";
}
