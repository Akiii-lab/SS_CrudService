package Stay.sure.Entitys.DAO;

import Stay.sure.Entitys.ServicesOfRoom;
import Stay.sure.DataBase.DatabaseConfig;
import Stay.sure.DataBase.QueryParam;
import Stay.sure.Entitys.Factories.ServiciesOfRoomFactory;

import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServicesOfRoomDao implements DaoBase<ServicesOfRoom> {
    @Autowired
    private final DatabaseConfig databaseConfig;

    private final String tableName = "services_of_rooms";
    private final String params = "id_room, id_service";

    private ArrayList<QueryParam> getDataParams(ServicesOfRoom data) {
        ArrayList<QueryParam> res = new ArrayList<>();

        res.add(new QueryParam("long", data.getId_room()));
        res.add(new QueryParam("long", data.getId_service()));

        return res;
    }

    private ServicesOfRoom getData(ResultSet res) {
        try {
            return ServiciesOfRoomFactory.createServiciesOfRoom(
                    res.getLong("id"),
                    res.getLong("id_room"),
                    res.getLong("id_service"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public ServicesOfRoomDao(DatabaseConfig databaseConfig) {
        this.databaseConfig = databaseConfig;
    }

    @Override
    public ServicesOfRoom save(ServicesOfRoom data) {

        try {
            long res = new DaoUtils().save(databaseConfig, getDataParams(data).toArray(new QueryParam[0]),
                    tableName, params);
            if (res > 0) {
                ServicesOfRoom resRoom = data;
                resRoom.setId(res);
                return resRoom;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    @Override
    public ServicesOfRoom update(ServicesOfRoom data) {
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

    public ArrayList<ServicesOfRoom> findByIdRoom(Long id) {
        ArrayList<ServicesOfRoom> servicesOfRooms = new ArrayList<>();
        try {
            ResultSet res = new DaoUtils().getByLongColumn(databaseConfig, tableName, "id_room", id);
            while (res.next()) {
                servicesOfRooms.add(getData(res));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return servicesOfRooms;
    }

    public ArrayList<ServicesOfRoom> findByIDService(Long id) {
        ArrayList<ServicesOfRoom> servicesOfRooms = new ArrayList<>();
        try {
            ResultSet res = new DaoUtils().getByLongColumn(databaseConfig, tableName, "id_service", id);
            while (res.next()) {
                servicesOfRooms.add(getData(res));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return servicesOfRooms;
    }

    @Override
    public ServicesOfRoom findById(Long id) {
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