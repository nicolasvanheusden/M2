package org.example;

import redis.clients.jedis.Jedis;

import java.util.Optional;

public class RedisRepository {

    private final Jedis jedis;

    public RedisRepository(Jedis jedis) {
        this.jedis = jedis;
    }

    public void addCacheDrug(Drug drug) {
        if (jedis.zcard("counter") >= 3) {
            // remove less used drug
            var drugLessViewed = jedis.zrange("counter", 0, 2).stream().findFirst().get();
            jedis.zrem("counter", drugLessViewed);
            jedis.del(drugLessViewed);
            System.out.println("Removed drug id : " + drugLessViewed);
        }
        // add new drug
        jedis.zadd("counter", 1, "cip7:"+drug.cip7());
        jedis.hset("cip7:"+drug.cip7(), drug.toMap());

    }

    public Optional<Drug> getCacheDrug(int drugId) {
        var res = jedis.hgetAll("cip7:"+drugId);
        if (res.isEmpty()) {
            return Optional.empty();
        }
        jedis.zincrby("counter", 1, "cip7:"+drugId);
        return Optional.of(Drug.fromMap(drugId, res));
    }
}
