package com.redfish.rule.exp.common.util.middleware.distributionlock;

import java.util.concurrent.locks.Lock;

public interface DistributeLockGetter {


    /**
     * 根据资源标识，获取对应的锁
     *
     * @param resourceTag
     * @return
     */
    Lock getLock(String resourceTag);
}
