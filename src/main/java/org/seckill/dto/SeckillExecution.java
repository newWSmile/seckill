package org.seckill.dto;

import org.seckill.entity.SuccessSeckilled;
import org.seckill.enums.SeckillStateEnum;

/**
 * 封装秒杀执行后的结果
 * Created by wyj on 2017/5/21.
 */
public class SeckillExecution {

    //秒杀单
    private long seckillId;

    //执行秒杀结果状态
    private int state;

    //状态表示
    private String stateInfo;

    //秒杀成功对象
    private SuccessSeckilled successSeckilled;


    public SeckillExecution(long seckillId, SeckillStateEnum stateEnum) {
        this.seckillId = seckillId;
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
    }

    public SeckillExecution(long seckillId, SeckillStateEnum stateEnum, SuccessSeckilled successSeckilled) {
        this.seckillId = seckillId;
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
        this.successSeckilled = successSeckilled;
    }

    public long getSeckillId() {
        return seckillId;
    }

    public void setSeckillId(long seckillId) {
        this.seckillId = seckillId;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    public SuccessSeckilled getSuccessSeckilled() {
        return successSeckilled;
    }

    public void setSuccessSeckilled(SuccessSeckilled successSeckilled) {
        this.successSeckilled = successSeckilled;
    }
}
