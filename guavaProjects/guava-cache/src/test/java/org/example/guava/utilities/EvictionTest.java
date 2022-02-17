package org.example.guava.utilities;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.LoadingCache;
import org.example.cache.source.MockDataSource;
import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * 缓存驱逐 缓存元素因为策略而被移除
 * 失效 缓存元素被手动移除
 * 移除 由于驱逐或者失效而最终导致的结果
 *
 * @author dragon
 * @date 2021/10/28
 */
public class EvictionTest {

    private static final MockDataSource DATA_SOURCE = new MockDataSource();

    @Test
    public void size_based_eviction_test() throws InterruptedException {
        LoadingCache<Integer, MockDataSource.Person> cache = Caffeine.newBuilder()
                .maximumSize(1L)
                .build(DATA_SOURCE::get);

        cache.get(1);

        Assert.assertEquals(1, cache.estimatedSize());

        cache.get(2);
        // caffeine删除元素,是通过在重新开一个异步线程,然后执行删除操作,所以这里需要暂停2秒
        TimeUnit.SECONDS.sleep(2);

        Assert.assertEquals(1, cache.estimatedSize());
    }

    @Test
    public void weight_based_eviction_test() throws InterruptedException {
        LoadingCache<Integer, MockDataSource.Person> cache = Caffeine.newBuilder()
                .maximumWeight(100)
                .weigher((Integer key, MockDataSource.Person value) -> value.getId())
                .build(DATA_SOURCE::get);

        cache.get(2);
        cache.get(1);
        cache.get(101);
        cache.get(102);
        cache.get(100);

        Assert.assertEquals(5, cache.estimatedSize());
        // 当缓存中所有元素的权重之和 > 最大权重时,在进行驱逐操作,异步线程进行
        TimeUnit.SECONDS.sleep(2);

//        Assert.assertEquals(3, cache.estimatedSize());
        display(cache);

    }

    @Test
    public void time_based_after_access_eviction_test() throws InterruptedException {
        LoadingCache<Integer, MockDataSource.Person> cache = Caffeine.newBuilder()
                .removalListener((key, value, cause) ->
                        System.out.printf("Key %s was evicted (%s)%n", key, cause))
                .expireAfterAccess(4, TimeUnit.SECONDS)
                .build(DATA_SOURCE::get);

        cache.get(1);

        cache.get(2);

        TimeUnit.SECONDS.sleep(2);
        cache.get(1);

        Assert.assertEquals(2, cache.estimatedSize());

        TimeUnit.SECONDS.sleep(3);

        System.out.println(cache.getIfPresent(1));
        System.out.println(cache.getIfPresent(2));

//        display(cache);

    }

    @Test
    public void time_based_after_write_eviction_test() throws InterruptedException {
        LoadingCache<Integer, MockDataSource.Person> cache = Caffeine.newBuilder()
                .expireAfterWrite(5, TimeUnit.SECONDS)
                .build(DATA_SOURCE::get);

        cache.get(1);

        cache.get(2);

        TimeUnit.SECONDS.sleep(2);
        cache.put(1, new MockDataSource.Person());

        Assert.assertEquals(2, cache.estimatedSize());

        TimeUnit.SECONDS.sleep(4);

        System.out.println(cache.getIfPresent(1));
        System.out.println(cache.getIfPresent(2));

        display(cache);

    }

    @Test
    public void weak_reference_based_eviction_test() throws InterruptedException {
        LoadingCache<Integer, MockDataSource.Person> cache = Caffeine.newBuilder()
                .weakKeys()
                .weakValues()
                .build(DATA_SOURCE::get);

        cache.get(1);

        cache.put(2, new MockDataSource.Person());

        display(cache);

        TimeUnit.SECONDS.sleep(2);

        System.out.println("=======");
        display(cache);
    }


    public void display(Cache cache) {
        cache.asMap().forEach((key, value) -> System.out.println(key + ":" + value));
    }

}
