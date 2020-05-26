package com.cloud.work.inventory.mapper;

import com.cloud.work.inventory.entity.InventoryEntity;
import org.springframework.stereotype.Repository;

/**
 * 描述：库存数据层
 *
 * @ClassName InventoryMapper
 * @Author 徐旭
 * @Date 2020-05-25 17:21
 * @Version 1.0
 */
@Repository
public interface InventoryMapper {

    int insert(InventoryEntity entity);
}
