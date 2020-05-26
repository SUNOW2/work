package com.cloud.work.inventory.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 描述：库存实体类
 *
 * @ClassName InventoryEntity
 * @Author 徐旭
 * @Date 2020-05-25 17:21
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class InventoryEntity {

    private Long id;

    private Long count;
}
