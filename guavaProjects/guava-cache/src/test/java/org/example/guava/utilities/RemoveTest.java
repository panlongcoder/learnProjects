package org.example.guava.utilities;

import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.LoadingCache;
import org.example.cache.source.MockDataSource;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

/**
 * 缓存移除
 *
 * @author dragon
 * @date 2021/10/29
 */
public class RemoveTest {


    private static final MockDataSource DATA_SOURCE = new MockDataSource();

    /**
     * 显示移除
     */
    @Test
    public void explicit_removal() throws InterruptedException {
        LoadingCache<Integer, MockDataSource.Person> cache = Caffeine.newBuilder()
                .removalListener((key, value , cause) ->
                    System.out.printf("Key %s was evicted (%s)%n", key, cause))
                .recordStats()
                .build(DATA_SOURCE::get);

        MockDataSource.Person person = cache.get(1);
        System.out.println(person);

        cache.invalidate(1);

        System.out.println(cache.getIfPresent(1));

        cache.getAll(Arrays.asList(1, 2, 3, 2, 3, 4));

        Assert.assertEquals(4, cache.estimatedSize());
        cache.invalidateAll();

        Assert.assertEquals(0, cache.estimatedSize());

        TimeUnit.SECONDS.sleep(20);

    }
}
