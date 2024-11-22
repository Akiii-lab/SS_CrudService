package Stay.sure.Entitys.DAO;

import Stay.sure.Entitys.Visit;
import Stay.sure.DataBase.DatabaseConfig;
import Stay.sure.DataBase.QueryParam;
import Stay.sure.Entitys.Factories.VisitFactory;

import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VisitDao implements DaoBase<Visit> {
    @Autowired
    private final DatabaseConfig databaseConfig;

    private final String tableName = "visits";
    private final String params = "id_checker, id_room";

    private ArrayList<QueryParam> getDataParams(Visit data) {
        ArrayList<QueryParam> res = new ArrayList<>();

        res.add(new QueryParam("long", data.getId_checker()));
        res.add(new QueryParam("long", data.getId_room()));

        return res;
    }

    private Visit getData(ResultSet res) {
        try {
            return VisitFactory.createVisit(
                    res.getLong("id"),
                    res.getLong("id_checker"),
                    res.getLong("id_room"));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public VisitDao(DatabaseConfig databaseConfig) {
        this.databaseConfig = databaseConfig;
    }

    @Override
    public Visit save(Visit data) {

        try {
            long res = new DaoUtils().save(databaseConfig, getDataParams(data).toArray(new QueryParam[0]),
                    tableName, params);
            if (res > 0) {
                Visit resRoom = data;
                resRoom.setId(res);
                return resRoom;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    @Override
    public Visit update(Visit data) {
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

    public Visit findByEmail(String email) {
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
    public Visit findById(Long id) {
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

    public ArrayList<Visit> findByChecker(Long id) {
        ArrayList<Visit> rooms = new ArrayList<Visit>();
        try {
            ResultSet res = new DaoUtils().getByLongColumn(databaseConfig, tableName, "id_checker", id);
            while (res.next()) {
                rooms.add(getData(res));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return rooms;
    }

    public ArrayList<Visit> findByRoom(Long id) {
        ArrayList<Visit> rooms = new ArrayList<Visit>();
        try {
            ResultSet res = new DaoUtils().getByLongColumn(databaseConfig, tableName, "id_room", id);
            while (res.next()) {
                rooms.add(getData(res));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return rooms;
    }
}