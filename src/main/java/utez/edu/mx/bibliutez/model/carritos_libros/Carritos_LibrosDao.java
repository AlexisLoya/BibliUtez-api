package utez.edu.mx.bibliutez.model.carritos_libros;

import utez.edu.mx.bibliutez.model.Dao;
import utez.edu.mx.bibliutez.model.DaoInterface;

import java.sql.SQLException;
import java.util.ArrayList;

public class Carritos_LibrosDao extends Dao implements DaoInterface<Carritos_LibrosBean> {
    @Override
    public int add(Carritos_LibrosBean obj) {
        mySQLRepository("insert into carritos_libros (carritos_id, libros_id, cantidad) values (?,?,?)");
        try {
            preparedStatement.setInt(1, obj.getCarritos_id().getId());
            preparedStatement.setInt(2, obj.getLibros_id().getId());
            preparedStatement.setInt(3, obj.getCantidad());
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
        mySQLRepository("delete from carritos_libros where id = ?");
        try {
            preparedStatement.setInt(1, id);
            status = preparedStatement.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAllConnections();
        }
        return false;
    }

    @Override
    public boolean update(Carritos_LibrosBean obj) {
        mySQLRepository("update carritos_libros libros_id= ?, cantidad= ?");
        try {
            preparedStatement.setInt(1, obj.getLibros_id().getId());
            preparedStatement.setInt(2, obj.getLibros_id().getId());
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
    public ArrayList<Carritos_LibrosBean> findAll() {
        return null;
    }

    @Override
    public Carritos_LibrosBean findOne(int id) {
        mySQLRepository("select * from carritos");
        return null;
    }
}
