package org.uge.repositories;

import org.postgresql.ds.PGSimpleDataSource;
import org.uge.models.Drug;
import org.uge.models.Pharma;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

public class PharmaRepositoryPSQL {
    private final PGSimpleDataSource dataSource;
    private final Random random;

    public PharmaRepositoryPSQL() {
        this.dataSource = new PGSimpleDataSource();
        dataSource.setDatabaseName("drug");
        this.random = new Random();
    }

    public Pharma getRandom() throws SQLException {
        var conn = dataSource.getConnection();
        var stmt = conn.prepareStatement("SELECT id, nom, adresse, depart, region FROM PHARM4PROJET");
        var rs = stmt.executeQuery();
        var tmp = new ArrayList<Pharma>();
        while (rs.next()) {
            tmp.add(new Pharma(
                rs.getLong("id"),
                rs.getString("nom"),
                rs.getString("adresse"),
                rs.getString("depart"),
                rs.getString("region")
            ));
        }
        return tmp.get(random.nextInt(0, tmp.size()));
    }
}
