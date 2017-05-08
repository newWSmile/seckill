package org.seckill.dao;

/**
 * Created by wyj on 2017/5/8.
 */
public interface SuccessSeckillDao {
    /**
     * 插入购买明细,可过滤重复
     * @param seckillId
     * @param userPhone
     * @return 插入的行数
     */
    int insertSuccessSeckilled(long seckillId,long userPhone);

    /**
     * 根据id查询SuccessKilled 并携带产品对象实体
     * @param seckillId
     * @return
     */
    SuccessSeckillDao queryByIdWithSeckill(long seckillId);

}
