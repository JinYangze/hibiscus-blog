package gold.hibiscus.blog.domain.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SnowFlakeGeneratorTest {
    @Test
    void nextIdInvalidValue() {
        // The ID range is from 0 to Long.MAX_VALUE.
        assertTrue(SnowFlakeGenerator.nextId() >= 0);
    }
}