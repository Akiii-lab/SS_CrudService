package Stay.sure.Entitys.DAO;

import Stay.sure.Entitys.StateTransitions;
import Stay.sure.DataBase.DatabaseConfig;
import Stay.sure.DataBase.QueryParam;
import Stay.sure.Entitys.Factories.StateTransitionsFactory;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StateTransitionsDao implements DaoBase<StateTransitions> {
    @Autowired
    private final DatabaseConfig databaseConfig;

    private final String tableName = "state_transitions";
    private final String params = "id_state, id_stockpile, date_transition";

    private ArrayList<QueryParam> getDataParams(StateTransitions data) {
        ArrayList<QueryParam> res = new ArrayList<>();

        res.add(new QueryParam("long", data.getId_State()));
        res.add(new QueryParam("long", data.getId_StockPile()));
        res.add(new QueryParam("date", data.getDate_transition()));

        return res;
    }

    private StateTransitions getData(ResultSet res) {
        try {
            return StateTransitionsFactory.createStateTransitions(
                    res.getLong("id"),
                    res.getLong("id_state"),
                    res.getLong("id_stockpile"),
                    res.getDate("date_transition"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public StateTransitionsDao(DatabaseConfig databaseConfig) {
        this.databaseConfig = databaseConfig;
    }

    @Override
    public StateTransitions save(StateTransitions data) {

        try {
            long res = new DaoUtils().save(databaseConfig, getDataParams(data).toArray(new QueryParam[0]),
                    tableName, params);
            if (res > 0) {
                StateTransitions resRoom = data;
                resRoom.setId(res);
                return resRoom;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    @Override
    public StateTransitions update(StateTransitions data) {
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

    public StateTransitions findByEmail(String email) {
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
    public StateTransitions findById(Long id) {
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

    public ArrayList<StateTransitions> findByIdState(Long id) {
        try {
            ArrayList<StateTransitions> data = new ArrayList<>();
            ResultSet res = new DaoUtils().getByLongColumn(databaseConfig, tableName, "id_state", id);
            while (res.next()) {
                data.add(getData(res));
            }
            return data;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public ArrayList<StateTransitions> findByIdStockpile(Long id) {
        try {
            ArrayList<StateTransitions> data = new ArrayList<>();
            ResultSet res = new DaoUtils().getByLongColumn(databaseConfig, tableName, "id_stockpile", id);
            while (res.next()) {
                data.add(getData(res));
            }
            return data;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public ArrayList<StateTransitions> findByDate(Date date) {
        ArrayList<StateTransitions> rooms = new ArrayList<StateTransitions>();
        try {
            ResultSet res = new DaoUtils().getByDateColumn(databaseConfig, tableName, "date_transition", date);
            while (res.next()) {
                rooms.add(getData(res));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return rooms;
    }
}