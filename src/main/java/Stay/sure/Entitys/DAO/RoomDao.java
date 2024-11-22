package Stay.sure.Entitys.DAO;

import Stay.sure.Entitys.Room;
import Stay.sure.DataBase.DatabaseConfig;
import Stay.sure.DataBase.QueryParam;
import Stay.sure.Entitys.Factories.RoomFactory;

import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RoomDao implements DaoBase<Room> {
    @Autowired
    private final DatabaseConfig databaseConfig;
    private final String tableName = "rooms";
    private final String params = "lugar, tamano, id_lessee";

    private ArrayList<QueryParam> getDataParams(Room data) {
        ArrayList<QueryParam> res = new ArrayList<>();

        res.add(new QueryParam("string", data.getLugar()));
        res.add(new QueryParam("int", data.getTamaño()));
        res.add(new QueryParam("long", data.getId_Lesse()));

        return res;
    }

    private Room getData(ResultSet res) {
        try {
            return RoomFactory.createRoom(
                    res.getLong("id"),
                    res.getString("lugar"),
                    res.getInt("tamano"),
                    res.getLong("id_lessee"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public RoomDao(DatabaseConfig databaseConfig) {
        this.databaseConfig = databaseConfig;
    }

    @Override
    public Room save(Room data) {

        try {
            long res = new DaoUtils().save(databaseConfig, getDataParams(data).toArray(new QueryParam[0]),
                    tableName, params);
            if (res > 0) {
                Room resRoom = data;
                resRoom.setId(res);
                return resRoom;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    @Override
    public Room update(Room data) {
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

    public Room findByIdLesse(Long id_lesse) {
        try {
            ResultSet res = new DaoUtils().getByLongColumn(databaseConfig, tableName, "id_lessee", id_lesse);
            if (res.next()) {
                return getData(res);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Room findById(Long id) {
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