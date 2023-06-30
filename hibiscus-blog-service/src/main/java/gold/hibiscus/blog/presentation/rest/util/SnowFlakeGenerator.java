package gold.hibiscus.blog.presentation.rest.util;


import cn.hutool.core.lang.Snowflake;

/**
 * Id generator by SnowFlake
 *
 * @author YangJinyang
 */
public class SnowFlakeGenerator {
    private static final long WORKER_ID = 1L;
    private static final long DATA_CENTER_ID = 1L;
    private static volatile Snowflake snowflake;

    private SnowFlakeGenerator() {
    }

    public static long nextId() {
        return getSnowflake().nextId();
    }

    private static Snowflake getSnowflake() {
        if (snowflake == null) {
            synchronized (SnowFlakeGenerator.class) {
                if (snowflake == null) {
                    snowflake = new Snowflake(WORKER_ID, DATA_CENTER_ID);
                }
            }
        }
        return snowflake;
    }
}
