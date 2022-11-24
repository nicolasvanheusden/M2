package org.example;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.sql.SQLException;

public class Main {


    public static void main(String[] args) throws SQLException {
        final JedisPool pool = new JedisPool(new JedisPoolConfig(), "localhost");
        var jedis = pool.getResource();

        var drug1= new Drug(1, "meganbio", 123);
        var drug2= new Drug(2, "ymola", 456);
        var drug3= new Drug(3, "ehtml", 789);
        var drug4= new Drug(4, "ebolo", 101);
        var drug5= new Drug(5, "raviolo", 121);

        var repo = new DrugRepositoryPSQL(jedis);

        repo.addDrug(drug1);
        repo.addDrug(drug2);
        repo.addDrug(drug3);

        boostDrug(drug1.cip7(),repo, 10);
        boostDrug(drug3.cip7(), repo, 5);

        repo.addDrug(drug4); // should remove id 2
        boostDrug(drug4.cip7(), repo, 7);

        repo.addDrug(drug5); // should remove id 3

        repo.getAll().forEach(System.out::println);

        boostDrug(drug2.cip7(), repo, 2); // should remove drug5

    }

    public static void boostDrug(int drugId, DrugRepositoryPSQL repo, int boost) throws SQLException {
        for (var i = 0; i < boost; i++) {
            repo.getDrug(drugId);
        }
    }
}
