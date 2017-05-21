package org.seckill.dto;

/**
 * 暴露秒杀地址DTO
 * Created by wyj on 2017/5/21.
 */
public class Exposer {
    //是否开启秒杀
    private boolean exposed;

    //一种加密错输
    private String md5;

    //秒杀id
    private long seckillId;

    //系统当前时间(毫秒)
    private long now;

    //开启秒杀时间(毫秒)
    private long start;

    //结束秒杀时间(毫秒)
    private long end;

    public Exposer(boolean exposed, String md5, long seckillId) {
        this.exposed = exposed;
        this.md5 = md5;
        this.seckillId = seckillId;
    }

    public Exposer(long now, long start, long end, boolean exposed) {
        this.now = now;
        this.start = start;
        this.end = end;
        this.exposed = exposed;
    }

    public Exposer(boolean exposed, long seckillId) {
        this.exposed = exposed;
        this.seckillId = seckillId;
    }

    public boolean isExposed() {
        return exposed;
    }

    public void setExposed(boolean exposed) {
        this.exposed = exposed;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public long getSeckillId() {
        return seckillId;
    }

    public void setSeckillId(long seckillId) {
        this.seckillId = seckillId;
    }

    public long getNow() {
        return now;
    }

    public void setNow(long now) {
        this.now = now;
    }

    public long getStart() {
        return start;
    }

    public void setStart(long start) {
        this.start = start;
    }

    public long getEnd() {
        return end;
    }

    public void setEnd(long end) {
        this.end = end;
    }
}