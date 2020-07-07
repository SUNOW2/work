package com.cloud.work.order.service;

import com.cloud.work.core.R;
import com.cloud.work.order.common.feign.InventoryFeign;
import com.cloud.work.order.entity.OrderEntity;
import com.cloud.work.order.mapper.OrderMapper;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.netflix.hystrix.contrib.javanica.conf.HystrixPropertiesManager.EXECUTION_ISOLATION_THREAD_TIMEOUT_IN_MILLISECONDS;

/**
 * 描述：订单实现层
 *
 * @ClassName OrderService
 * @Author 徐旭
 * @Date 2020-05-25 16:50
 * @Version 1.0
 */
@Slf4j
@Service
public class OrderService {

    @Autowired
    private OrderServiceImpl serviceImpl;

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private InventoryFeign feign;

    @HystrixCommand(fallbackMethod = "insertFallback", commandProperties = {
            @HystrixProperty(name = EXECUTION_ISOLATION_THREAD_TIMEOUT_IN_MILLISECONDS, value = "8000")
    })
    public R insert() throws Exception {
        log.info("新增订单");
        serviceImpl.insert();
        return R.ok();
    }

    public R insertFallback() {
        log.info("我是hystrix");
        log.info("新增订单失败");
        return R.error();
    }

    @GlobalTransactional
    public R insertBySeaTa() {
        log.info("新增订单");
        OrderEntity entity = new OrderEntity();
        orderMapper.insert(entity);
        feign.insertBySeaTa();
        return R.ok();
    }
}
