package org.example.guava.utilities;

import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.LoadingCache;
import org.example.cache.source.MockDataSource;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * @author dragon
 * @date 2021/10/29
 */
public class RefreshTest {

    private static final MockDataSource DATA_SOURCE = new MockDataSource();

    @Test
    public void refresh_test() throws InterruptedException {
        LoadingCache<Integer, MockDataSource.Person> cache =
                Caffeine.newBuilder()
                .expireAfterWrite(5, TimeUnit.SECONDS)
                .refreshAfterWrite(5, TimeUnit.SECONDS)
                .build(DATA_SOURCE::get);

        System.out.println(cache.get(1));

        DATA_SOURCE.set(1, new MockDataSource.Person("dragon11111", 12, 1));

        // 异步的
        cache.refresh(1);

        System.out.println(cache.getIfPresent(1));

        TimeUnit.SECONDS.sleep(2);

        System.out.println(cache.getIfPresent(1));

    }
}
