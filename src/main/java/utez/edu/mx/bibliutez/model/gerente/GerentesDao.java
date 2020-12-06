package utez.edu.mx.bibliutez.model.gerente;

import utez.edu.mx.bibliutez.model.Dao;
import utez.edu.mx.bibliutez.model.DaoInterface;
import utez.edu.mx.bibliutez.model.usuarios.UsuariosDao;

import java.sql.SQLException;
import java.util.ArrayList;

public class GerentesDao extends Dao implements DaoInterface<GerentesBean> {
    @Override
    public int add(GerentesBean obj) {
        mySQLRepository("insert into gerentes (usuarios_id) values (?)");
        try {
            preparedStatement.setInt(1, obj.getUsuarios_id().getId());
            preparedStatement.executeUpdate();
            resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) return resultSet.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAllConnections();
        }
        return 0;
    }

    @Override
    public boolean delete(int id) {
        mySQLRepository("delete from gerentes where id = ?");
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
    public boolean update(GerentesBean obj) {
        mySQLRepository("update gerentes SET usuario_id = ?");
        try {
            preparedStatement.setInt(1, obj.getUsuarios_id().getId());
            preparedStatement.setInt(2, obj.getId());
            status = preparedStatement.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAllConnections();
        }
        return status;
    }

    @Override
    public ArrayList<GerentesBean> findAll() {
        mySQLRepository("select * from gerentes");
        ArrayList<GerentesBean> list = new ArrayList<>();
        try {
            resultSet = preparedStatement.executeQuery();
            GerentesDao dao = new GerentesDao();
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
    public GerentesBean findOne(int id) {
        mySQLRepository("select * from gerentes where id=?");
        GerentesBean gerente = null;
        try {
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                UsuariosDao dao = new UsuariosDao();
                gerente = new GerentesBean(
                        resultSet.getInt("id"),
                        dao.findOne(resultSet.getInt("usuarios_id"))
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAllConnections();
        }
        return gerente;
    }
}
