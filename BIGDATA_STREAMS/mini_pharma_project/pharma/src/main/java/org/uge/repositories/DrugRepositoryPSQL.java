package org.uge.repositories;

import org.postgresql.ds.PGSimpleDataSource;
import org.uge.models.Drug;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

public class DrugRepositoryPSQL {
    private final PGSimpleDataSource dataSource;
    private final Random random;

    public DrugRepositoryPSQL() {
        this.dataSource = new PGSimpleDataSource();
        dataSource.setDatabaseName("drug");
        this.random = new Random();
    }

    public Drug getRandom() throws SQLException {
        var conn = dataSource.getConnection();
        var stmt = conn.prepareStatement("SELECT cip, prix FROM DRUGS4PROJET");
        var rs = stmt.executeQuery();
        var tmp = new ArrayList<Drug>();
        while (rs.next()) {
            var isReduction = random.nextBoolean();
            tmp.add(new Drug(rs.getLong("cip"), rs.getInt("prix") * (1 + (isReduction ? -0.1 : 0.1))));
        }
        return tmp.get(random.nextInt(0, tmp.size()));

    }
}
