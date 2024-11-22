package Stay.sure.Entitys.DAO;

import Stay.sure.Entitys.VisitTransition;
import Stay.sure.DataBase.DatabaseConfig;
import Stay.sure.DataBase.QueryParam;
import Stay.sure.Entitys.Factories.VisitTransitionFactory;

import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VisitTransitionDao implements DaoBase<VisitTransition> {
    @Autowired
    private final DatabaseConfig databaseConfig;

    private final String tableName = "visit_transition";
    private final String params = "id_visit, id_visitstate, date";

    private ArrayList<QueryParam> getDataParams(VisitTransition data) {
        ArrayList<QueryParam> res = new ArrayList<>();

        res.add(new QueryParam("Lomg", data.getId_visit()));
        res.add(new QueryParam("Lomg", data.getId_visitState()));
        res.add(new QueryParam("Date", data.getDate()));

        return res;
    }

    private VisitTransition getData(ResultSet res) {
        try {
            return VisitTransitionFactory.createVisitTransition(
                    res.getLong("id"),
                    res.getLong("id_visit"),
                    res.getLong("id_visitstate"),
                    res.getDate("date"));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public VisitTransitionDao(DatabaseConfig databaseConfig) {
        this.databaseConfig = databaseConfig;
    }

    @Override
    public VisitTransition save(VisitTransition data) {

        try {
            long res = new DaoUtils().save(databaseConfig, getDataParams(data).toArray(new QueryParam[0]),
                    tableName, params);
            if (res > 0) {
                VisitTransition resRoom = data;
                resRoom.setId(res);
                return resRoom;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    @Override
    public VisitTransition update(VisitTransition data) {
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

    public VisitTransition findByEmail(String email) {
        try {
            ResultSet res = new DaoUtils().getByStringColumn(databaseConfig, tableName, "email", email);
            if (res.next()) {
                return getData(res);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public VisitTransition findById(Long id) {
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