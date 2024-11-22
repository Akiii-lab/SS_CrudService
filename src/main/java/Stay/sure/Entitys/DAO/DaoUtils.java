package Stay.sure.Entitys.DAO;

import Stay.sure.DataBase.DatabaseConfig;
import Stay.sure.DataBase.QueryParam;
import java.util.ArrayList;
import java.util.Date;
import java.sql.ResultSet;

public class DaoUtils {

    public long save(DatabaseConfig databaseConfig, QueryParam[] queryParams, String params, String tableName)
            throws Exception {
        String paramToPrepare = "";
        for (int i = 0; i < params.split(", ").length; i++) {
            if (i == 0) {
                paramToPrepare += "?";
            } else {
                paramToPrepare += ", ?";
            }
        }
        return databaseConfig
                .executeUpdate(
                        "INSERT INTO " + tableName + " (" + params + ") VALUES (" + paramToPrepare + ")",
                        queryParams);
    }

    public long update(DatabaseConfig databaseConfig, ArrayList<QueryParam> valuesSplited, String params,
            String tableName, Long id)
            throws Exception {
        String paramsSplited[] = params.split(", ");
        String query = "";
        query += "UPDATE " + tableName + " SET ";
        for (int i = 0; i < paramsSplited.length; i++) {
            if (i == 0) {
                query += paramsSplited[i] + " = ?";
            } else {
                query += ", " + paramsSplited[i] + " = ?";
            }
        }
        valuesSplited.add(new QueryParam("long", id));
        query += " WHERE id = ? ";
        return databaseConfig
                .executeUpdate(query, valuesSplited.toArray(new QueryParam[0]));
    }

    public long detele(DatabaseConfig databaseConfig, String tableName, Long id)
            throws Exception {
        return databaseConfig
                .executeUpdate("DELETE FROM " + tableName + " WHERE id = ?", new QueryParam("long", id));
    }

    public ResultSet getByID(DatabaseConfig databaseConfig, String tableName, Long id) throws Exception {
        return databaseConfig
                .executeQuery("SELECT * FROM " + tableName + " WHERE id = ?", new QueryParam("long", id));
    }

    public ResultSet getByStringColumn(DatabaseConfig databaseConfig, String tableName, String column_name,
            String search) throws Exception {
        return databaseConfig
                .executeQuery("SELECT * FROM " + tableName + " WHERE " + column_name + " = ?",
                        new QueryParam("string", search));
    }

    public ResultSet getByLongColumn(DatabaseConfig databaseConfig, String tableName, String column_name,
            Long search) throws Exception {
        return databaseConfig
                .executeQuery("SELECT * FROM " + tableName + " WHERE " + column_name + " = ?",
                        new QueryParam("long", search));
    }

    public ResultSet getByIntColumn(DatabaseConfig databaseConfig, String tableName, String column_name,
            Integer search) throws Exception {
        return databaseConfig
                .executeQuery("SELECT * FROM " + tableName + " WHERE " + column_name + " = ?",
                        new QueryParam("int", search));
    }

    public ResultSet getByDateColumn(DatabaseConfig databaseConfig, String tableName, String column_name,
            Date search) throws Exception {
        return databaseConfig
                .executeQuery("SELECT * FROM " + tableName + " WHERE " + column_name + " = ?",
                        new QueryParam("date", search));
    }

    public ResultSet getAll(DatabaseConfig databaseConfig, String tableName) throws Exception {
        return databaseConfig.executeQuery("SELECT * FROM " + tableName);
    }

    public ResultSet getByDateRange(DatabaseConfig databaseConfig, String tableName, String column_name,
            Date rangeFrom, Date rangeTo) throws Exception {
        return databaseConfig
                .executeQuery("SELECT * FROM " + tableName + " WHERE " + column_name + " >= ? AND " + column_name
                        + " <= ?", new QueryParam("date", rangeFrom), new QueryParam("date", rangeTo));
    }
}