package Stay.sure.Entitys.DAO;

import Stay.sure.Entitys.Rank;
import Stay.sure.DataBase.DatabaseConfig;
import Stay.sure.DataBase.QueryParam;
import Stay.sure.Entitys.Factories.RankFactory;

import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RankDao implements DaoBase<Rank> {
    @Autowired
    private final DatabaseConfig databaseConfig;
    private final String tableName = "ranks";
    private final String params = "name, assessment";

    private ArrayList<QueryParam> getDataParams(Rank data) {
        ArrayList<QueryParam> res = new ArrayList<>();

        res.add(new QueryParam("string", data.getName()));
        res.add(new QueryParam("float", data.getAssessment()));

        return res;
    }

    private Rank getData(ResultSet res) {
        try {
            return RankFactory.createRank(
                    res.getLong("id"),
                    res.getString("name"),
                    res.getFloat("assessment"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public RankDao(DatabaseConfig databaseConfig) {
        this.databaseConfig = databaseConfig;
    }

    @Override
    public Rank save(Rank data) {

        try {
            long res = new DaoUtils().save(databaseConfig, getDataParams(data).toArray(new QueryParam[0]),
                    tableName, params);
            if (res > 0) {
                Rank resRoom = data;
                resRoom.setId(res);
                return resRoom;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    @Override
    public Rank update(Rank data) {
        try {
            long res = new DaoUtils().update(databaseConfig, getDataParams(data), tableName, params,
                    data.getId());
            if (res > 0) {
                return findById(data.getId());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public boolean delete(Long id) {
        try {
            long res = new DaoUtils().detele(databaseConfig, tableName, id);
            return res > 0;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public Rank findByName(String name) {
        try {
            ResultSet res = new DaoUtils().getByStringColumn(databaseConfig, tableName, "name", name);
            if (res.next()) {
                return getData(res);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Rank findById(Long id) {
        try {
            ResultSet res = new DaoUtils().getByID(databaseConfig, tableName, id);
            if (res.next()) {
                return getData(res);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}