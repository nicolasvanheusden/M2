package org.example;

import org.postgresql.ds.PGSimpleDataSource;
import redis.clients.jedis.Jedis;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DrugRepositoryPSQL {

    private final PGSimpleDataSource dataSource;
    private final RedisRepository redisRepository;

    public DrugRepositoryPSQL(Jedis jedis) {
        this.dataSource = new PGSimpleDataSource();
        dataSource.setDatabaseName("drug");
        this.redisRepository = new RedisRepository(jedis);
    }


    public List<Drug> getAll() throws SQLException {
        var conn = dataSource.getConnection();
        var stmt = conn.prepareStatement("SELECT * FROM DRUG");
        // Execute the query, and store the results in the ResultSet instance
        var rs = stmt.executeQuery();
        var res = new ArrayList<Drug>();
        while (rs.next()) {
            res.add(new Drug(rs.getInt("cip7"), rs.getString("name"), rs.getLong("cis")));

        }
        conn.close();
        return res;
    }


    public Drug getDrug(int cip7) throws SQLException {
        // cache fetch
        var optionalDrug = redisRepository.getCacheDrug(cip7);
        if (optionalDrug.isPresent()) {
            return optionalDrug.get();
        }
        // database fetch
        var conn = dataSource.getConnection();
        var stmt = conn.prepareStatement("SELECT * FROM DRUG WHERE cip7=?");
        stmt.setInt(1, cip7);
        var rs = stmt.executeQuery();
        conn.close();
        if (rs.next()) {
            var drug =  new Drug(rs.getInt("cip7"), rs.getString("name"), rs.getLong("cis"));
            redisRepository.addCacheDrug(drug); // cache drug for next time
            return drug;
        }
        throw new NoSuchFieldError("Drug cip7:" + cip7 + "is not found");
    }


    public void addDrug(Drug drug) throws SQLException {
        var conn = dataSource.getConnection();
        var stmt = conn.prepareStatement("INSERT INTO drug(cip7, name, cis) VALUES(?,?,?)");
        stmt.setInt(1, drug.cip7());
        stmt.setString(2, drug.name());
        stmt.setLong(3, drug.cisCode());
        stmt.executeUpdate();
        conn.close();
        redisRepository.addCacheDrug(drug); // cache drug
    }
}
