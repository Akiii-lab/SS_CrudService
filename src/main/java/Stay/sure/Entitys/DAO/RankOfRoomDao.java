package Stay.sure.Entitys.DAO;

import Stay.sure.Entitys.RankOfRoom;
import Stay.sure.DataBase.DatabaseConfig;
import Stay.sure.DataBase.QueryParam;
import Stay.sure.Entitys.Factories.RankOfRoomFactory;

import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RankOfRoomDao implements DaoBase<RankOfRoom> {
    @Autowired
    private final DatabaseConfig databaseConfig;

    private final String tableName = "ranks_of_room";
    private final String params = "id_room, id_rank, idChecker";

    private ArrayList<QueryParam> getDataParams(RankOfRoom data) {
        ArrayList<QueryParam> res = new ArrayList<>();

        res.add(new QueryParam("long", data.getId_room()));
        res.add(new QueryParam("long", data.getId_rank()));
        res.add(new QueryParam("long", data.getIdChecker()));

        return res;
    }

    private RankOfRoom getData(ResultSet res) {
        try {
            return RankOfRoomFactory.createRankOfRoom(
                    res.getLong("id"),
                    res.getLong("id_room"),
                    res.getLong("id_rank"),
                    res.getLong("idChecker"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public RankOfRoomDao(DatabaseConfig databaseConfig) {
        this.databaseConfig = databaseConfig;
    }

    @Override
    public RankOfRoom save(RankOfRoom data) {

        try {
            long res = new DaoUtils().save(databaseConfig, getDataParams(data).toArray(new QueryParam[0]),
                    tableName, params);
            if (res > 0) {
                RankOfRoom resRoom = data;
                resRoom.setId(res);
                return resRoom;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    @Override
    public RankOfRoom update(RankOfRoom data) {
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

    public RankOfRoom findByIds(Long id_room, Long id_checker, Long id_rank) {
        try {
            ResultSet res = databaseConfig.executeQuery("SELECT * FROM ", tableName, " WHERE id_room = ? AND idChecker = ? AND id_rank = ?", new QueryParam("long", id_room), new QueryParam("long", id_checker), new QueryParam("long", id_rank));
            if (res.next()) {
                return getData(res);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public RankOfRoom findById(Long id) {
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