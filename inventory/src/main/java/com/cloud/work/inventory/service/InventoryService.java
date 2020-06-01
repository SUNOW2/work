package com.cloud.work.inventory.service;

import com.cloud.work.core.R;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.netflix.hystrix.contrib.javanica.conf.HystrixPropertiesManager.EXECUTION_ISOLATION_THREAD_TIMEOUT_IN_MILLISECONDS;

/**
 * 描述：库存实现类
 *
 * @ClassName InventoryService
 * @Author 徐旭
 * @Date 2020-05-25 17:21
 * @Version 1.0
 */
@Slf4j
@Service
public class InventoryService {

    @Autowired
    private InventoryServiceImpl serviceImpl;

    /**
     * 注意：@HystrixCommand和@Transactional共用的时候，事务会失效
     * 原因：HystrixCommand使用的不是同一个线程，不在一个connection中
     *
     * @return
     * @throws Exception
     */
    @HystrixCommand(fallbackMethod = "insertFallback", commandProperties = {
            @HystrixProperty(name = EXECUTION_ISOLATION_THREAD_TIMEOUT_IN_MILLISECONDS, value = "8000")
    })
    public R insert() throws Exception {
        log.info("新增库存");
//        Thread.sleep(7000);
        serviceImpl.insert();
        return R.ok();
    }

    public R insertFallback() {
        log.info("我是Hystrix");
        log.info("新增库存失败");
        return R.error();
    }
}
