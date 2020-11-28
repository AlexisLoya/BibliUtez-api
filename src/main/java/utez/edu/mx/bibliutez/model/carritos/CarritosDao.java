package utez.edu.mx.bibliutez.model.carritos;

import utez.edu.mx.bibliutez.model.Dao;
import utez.edu.mx.bibliutez.model.DaoInterface;
import utez.edu.mx.bibliutez.model.categorias.CategoriaDao;
import utez.edu.mx.bibliutez.model.usuarios.UsuariosDao;

import java.sql.SQLException;
import java.util.ArrayList;

public class CarritosDao extends Dao implements DaoInterface<CarritosBean> {
    @Override
    public int add(CarritosBean obj) {
        mySQLRepository("insert into carritos (usuaios_id) values ?");
        try {
            preparedStatement.setInt(1, obj.getUsuarios_id().getId());
            preparedStatement.executeUpdate();
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
        mySQLRepository("delete from carritos where id = ?");
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
    public boolean update(CarritosBean obj) {
        mySQLRepository("update carritos set usuarios_id = ? where id = ?");
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
    public ArrayList<CarritosBean> findAll() {
        mySQLRepository("select * from carritos");
        ArrayList<CarritosBean> list = new ArrayList<>();
        try {
            resultSet = preparedStatement.executeQuery();
            CarritosDao dao = new CarritosDao();
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
    public CarritosBean findOne(int id) {
        mySQLRepository("select * from carritos where id = ?");
        CarritosBean carrito = null;
        try {
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                carrito = new CarritosBean(
                        resultSet.getInt("id"),
                        new UsuariosDao().findOne(resultSet.getInt("usuario_id"))
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAllConnections();
        }
        return carrito;
    }
}
