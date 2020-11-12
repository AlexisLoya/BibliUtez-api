package utez.edu.mx.bibliutez.model.roles;

import utez.edu.mx.bibliutez.model.Dao;
import utez.edu.mx.bibliutez.model.DaoInterface;

import java.sql.SQLException;
import java.util.ArrayList;

public class RolesDao extends Dao implements DaoInterface<RolesBean> {
    @Override
    public int add(RolesBean obj) {
        mySQLRepository("insert into roles (nombre) values(?)");
        try {
            preparedStatement.setString(1, obj.getNombre());
            preparedStatement.executeQuery();
            resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) return resultSet.getInt("id");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAllConnections();
        }
        return 0;
    }

    @Override
    public boolean delete(int id) {
        mySQLRepository("delete from roles where id = ?");
        try {
            preparedStatement.setInt(1, id);
            status = preparedStatement.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAllConnections();
        }
        return status;
    }

    @Override
    public boolean update(RolesBean obj) {
        mySQLRepository("update roles nombre = ? where id = ?");
        try {
            preparedStatement.setString(1, obj.getNombre());
            preparedStatement.setInt(2, obj.getId());
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) return true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAllConnections();
        }
        return false;
    }

    @Override
    public ArrayList<RolesBean> findAll() {
        mySQLRepository("select * from roles");
        ArrayList<RolesBean> list = new ArrayList<>();
        try {
            resultSet = preparedStatement.executeQuery();
            RolesDao dao = new RolesDao();
            while (resultSet.next()) {
                list.add(dao.findOne(resultSet.getInt("id")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAllConnections();
        }
        return list;
    }

    @Override
    public RolesBean findOne(int id) {
        mySQLRepository("select * from roles where id = ?");
        RolesBean rol = null;
        try {
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                rol = new RolesBean(
                        resultSet.getInt("id"),
                        resultSet.getString("nombre")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAllConnections();
        }
        return rol;
    }
}
