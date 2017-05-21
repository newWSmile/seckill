package org.seckill.exception;

/**
 * 秒杀关闭异常(运行期异常)
 * Created by wyj on 2017/5/21.
 */
public class SeckillCloseException extends SeckillException {
    public SeckillCloseException(String message) {
        super(message);
    }

    public SeckillCloseException(String message, Throwable cause) {
        super(message, cause);
    }
}
