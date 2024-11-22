package Stay.sure.Entitys.DAO;

import Stay.sure.Entitys.StockPile;
import Stay.sure.DataBase.DatabaseConfig;
import Stay.sure.DataBase.QueryParam;
import Stay.sure.Entitys.Factories.StockPileFactory;

import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StockPileDao implements DaoBase<StockPile> {
    @Autowired
    private final DatabaseConfig databaseConfig;

    private final String tableName = "stockpile";
    private final String params = "id_room, id_user, date_stockpile";

    private ArrayList<QueryParam> getDataParams(StockPile data) {
        ArrayList<QueryParam> res = new ArrayList<>();

        res.add(new QueryParam("long", data.getId_room()));
        res.add(new QueryParam("long", data.getId_user()));
        res.add(new QueryParam("date", data.getDate_stockpile()));

        return res;
    }

    private StockPile getData(ResultSet res) {
        try {
            return StockPileFactory.createStockPile(
                    res.getLong("id"),
                    res.getLong("id_room"),
                    res.getLong("id_user"),
                    res.getDate("date_stockpile"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public StockPileDao(DatabaseConfig databaseConfig) {
        this.databaseConfig = databaseConfig;
    }

    @Override
    public StockPile save(StockPile data) {

        try {
            long res = new DaoUtils().save(databaseConfig, getDataParams(data).toArray(new QueryParam[0]),
                    tableName, params);
            if (res > 0) {
                StockPile resRoom = data;
                resRoom.setId(res);
                return resRoom;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    @Override
    public StockPile update(StockPile data) {
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

    public StockPile findByEmail(String email) {
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
    public StockPile findById(Long id) {
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