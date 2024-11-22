package Stay.sure.Entitys.DAO;

import Stay.sure.Entitys.State;
import Stay.sure.DataBase.DatabaseConfig;
import Stay.sure.DataBase.QueryParam;
import Stay.sure.Entitys.Factories.StateFactory;

import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StateDao implements DaoBase<State> {
    @Autowired
    private final DatabaseConfig databaseConfig;

    private final String tableName = "states";
    private final String params = "state";

    private ArrayList<QueryParam> getDataParams(State data) {
        ArrayList<QueryParam> res = new ArrayList<>();

        res.add(new QueryParam("long", data.getState()));

        return res;
    }

    private State getData(ResultSet res) {
        try {
            return StateFactory.createState(
                    res.getLong("id"),
                    res.getString("state"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public StateDao(DatabaseConfig databaseConfig) {
        this.databaseConfig = databaseConfig;
    }

    @Override
    public State save(State data) {

        try {
            long res = new DaoUtils().save(databaseConfig, getDataParams(data).toArray(new QueryParam[0]),
                    tableName, params);
            if (res > 0) {
                State resRoom = data;
                resRoom.setId(res);
                return resRoom;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    @Override
    public State update(State data) {
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

    public State findByName(String name) {
        try {
            ResultSet res = new DaoUtils().getByStringColumn(databaseConfig, tableName, "state", name);
            if (res.next()) {
                return getData(res);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public State findById(Long id) {
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