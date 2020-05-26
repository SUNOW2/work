package com.cloud.work.order.service;

import com.cloud.work.core.R;
import com.cloud.work.order.common.feign.InventoryFeign;
import com.cloud.work.order.entity.OrderEntity;
import com.cloud.work.order.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import static javax.servlet.http.HttpServletResponse.SC_INTERNAL_SERVER_ERROR;

/**
 * 描述：订单实现层
 *
 * @ClassName OrderServiceImpl
 * @Author 徐旭
 * @Date 2020-05-26 10:50
 * @Version 1.0
 */
@Service
public class OrderServiceImpl {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private InventoryFeign feign;

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
    public void insert() throws Exception {
        OrderEntity entity = new OrderEntity();
        orderMapper.insert(entity);
        R result = feign.insert();
        if (result.get("code").equals(SC_INTERNAL_SERVER_ERROR)) {
            throw new Exception();
        }
    }
}
