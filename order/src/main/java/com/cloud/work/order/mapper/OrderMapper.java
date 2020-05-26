package com.cloud.work.order.mapper;

import com.cloud.work.order.entity.OrderEntity;
import org.springframework.stereotype.Repository;

/**
 * 描述：订单数据层
 *
 * @ClassName OrderMapper
 * @Author 徐旭
 * @Date 2020-05-25 16:50
 * @Version 1.0
 */
@Repository
public interface OrderMapper {

    int insert(OrderEntity entity);
}
