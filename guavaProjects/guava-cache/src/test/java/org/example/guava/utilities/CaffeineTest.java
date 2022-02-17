package org.example.guava.utilities;

import com.github.benmanes.caffeine.cache.*;
import com.github.benmanes.caffeine.cache.stats.CacheStats;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.example.cache.source.MockDataSource;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author dragon
 * @date 2021/10/28
 */
public class CaffeineTest {

    private static final MockDataSource DATA_SOURCE = new MockDataSource();

    /**
     * 手动加载
     */
    @Test
    public void manual_load() {
        Cache<Integer, MockDataSource.Person> cache = Caffeine.newBuilder()
                .expireAfterWrite(10, TimeUnit.MINUTES)
                .maximumSize(10_000)
                .build();

        ConcurrentMap<@NonNull Integer, MockDataSource.@NonNull Person> map = cache.asMap();

        // 如果有缓存,则返回;没有,则返回null
        System.out.println(cache.getIfPresent(1));

        // 如果有缓存,则返回,没有,则执行function,缓存,返回
        System.out.println(cache.get(2, key -> new MockDataSource.Person("dragon", 12, 2)));
        System.out.println(map);

        // 如果有缓存,则更新新的value; 否则创建新的缓存,则直接返回
        cache.put(1, new MockDataSource.Person("hero", 11, 1));

        cache.invalidate(2);

        CacheStats stats = cache.stats();
        System.out.println(stats);


        System.out.println(map);
    }

    /**
     * 自动加载
     */
    @Test
    public void auto_load() {
        LoadingCache<Integer, MockDataSource.Person> cache = Caffeine.newBuilder()
                .build(DATA_SOURCE::get);

        System.out.println(cache.get(1));

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 100000);

        Map<@NonNull Integer, MockDataSource.@NonNull Person> map = cache.getAll(list);
        System.out.println(map);
    }

    /**
     * 手动异步 加载
     *
     * @throws ExecutionException
     * @throws InterruptedException
     */
    @Test
    public void manual_async_load() throws ExecutionException, InterruptedException {
        AsyncCache<Integer, MockDataSource.Person> cache = Caffeine.newBuilder()
                .buildAsync();

        CompletableFuture<MockDataSource.Person> personCompletableFuture = cache.getIfPresent(1);

        CompletableFuture<MockDataSource.Person> personCompletableFuture1 = cache.get(1, key -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return new MockDataSource.Person("test", 12, key);
        });

        personCompletableFuture1.thenAccept(result -> System.out.println(result.getName()));

        personCompletableFuture1.exceptionally(exception -> {
            exception.printStackTrace();
            return null;
        });
        System.out.println(cache.synchronous().getIfPresent(1));


        Thread.sleep(50000000);
    }


    @Test
    public void auto_async_load() throws ExecutionException, InterruptedException {
        AsyncLoadingCache<Integer, MockDataSource.Person> cache = Caffeine.newBuilder()
                .buildAsync(DATA_SOURCE::get);

        CompletableFuture<MockDataSource.Person> future = cache.get(2);

        MockDataSource.Person person = future.get();

        System.out.println(person);

    }

}
