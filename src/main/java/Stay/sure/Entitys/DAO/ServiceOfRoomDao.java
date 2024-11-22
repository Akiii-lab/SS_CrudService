package Stay.sure.Entitys.DAO;

import Stay.sure.Entitys.ServiceOfRoom;
import Stay.sure.DataBase.DatabaseConfig;
import Stay.sure.DataBase.QueryParam;
import Stay.sure.Entitys.Factories.ServiceOfRoomFactory;

import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServiceOfRoomDao implements DaoBase<ServiceOfRoom> {
    @Autowired
    private final DatabaseConfig databaseConfig;

    private final String tableName = "services_of_room";
    private final String params = "name";

    private ArrayList<QueryParam> getDataParams(ServiceOfRoom data) {
        ArrayList<QueryParam> res = new ArrayList<>();

        res.add(new QueryParam("string", data.getName()));

        return res;
    }

    private ServiceOfRoom getData(ResultSet res) {
        try {
            return ServiceOfRoomFactory.createServiceOfRoom(
                    res.getLong("id"),
                    res.getString("name"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public ServiceOfRoomDao(DatabaseConfig databaseConfig) {
        this.databaseConfig = databaseConfig;
    }

    @Override
    public ServiceOfRoom save(ServiceOfRoom data) {

        try {
            long res = new DaoUtils().save(databaseConfig, getDataParams(data).toArray(new QueryParam[0]),
                    tableName, params);
            if (res > 0) {
                ServiceOfRoom resRoom = data;
                resRoom.setId(res);
                return resRoom;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    @Override
    public ServiceOfRoom update(ServiceOfRoom data) {
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

    public ServiceOfRoom findByName(String name) {
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
    public ServiceOfRoom findById(Long id) {
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