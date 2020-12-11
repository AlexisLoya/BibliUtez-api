package utez.edu.mx.bibliutez.model.carritos_libros;

import utez.edu.mx.bibliutez.model.Dao;
import utez.edu.mx.bibliutez.model.DaoInterface;
import utez.edu.mx.bibliutez.model.carritos.CarritosDao;
import utez.edu.mx.bibliutez.model.libros.LibrosBean;
import utez.edu.mx.bibliutez.model.libros.LibrosDao;

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
        mySQLRepository("delete from carritos_libros where id = ?");
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
    public boolean update(Carritos_LibrosBean obj) {
        mySQLRepository("update carritos_libros SET carritos_id=?,libros_id= ?, cantidad= ? where id=?");
        try {
            preparedStatement.setInt(1, obj.getCarritos_id().getId());
            preparedStatement.setInt(2, obj.getLibros_id().getId());
            preparedStatement.setInt(3, obj.getCantidad());
            preparedStatement.setInt(4, obj.getId());
            status = preparedStatement.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAllConnections();
        }
        return status;
    }

    @Override
    public ArrayList<Carritos_LibrosBean> findAll() {
        mySQLRepository("select * from carritos_libros");
        ArrayList<Carritos_LibrosBean> list = new ArrayList<>();
        try {
            resultSet = preparedStatement.executeQuery();
            Carritos_LibrosDao DAO = new Carritos_LibrosDao();
            while (resultSet.next()) {
                list.add(DAO.findOne(resultSet.getInt("id")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAllConnections();
        }
        return list;
    }

    @Override
    public Carritos_LibrosBean findOne(int id) {
        mySQLRepository("select * from carritos_libros where id = ?");
        Carritos_LibrosBean bean = null;
        try {
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                bean = new Carritos_LibrosBean(
                        resultSet.getInt("id"),
                        new CarritosDao().findOne(resultSet.getInt("carritos_id")),
                        new LibrosDao().findOne(resultSet.getInt("libros_id")),
                        resultSet.getInt("cantidad")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAllConnections();
        }
        return bean;
    }

    public ArrayList<Carritos_LibrosBean> findCarrito(int id) {
        mySQLRepository("select * from carritos_libros where carritos_id = ?");
        ArrayList<Carritos_LibrosBean> list = new ArrayList<>();
        try {
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            Carritos_LibrosDao DAO = new Carritos_LibrosDao();
            while (resultSet.next()) {
                list.add(DAO.findOne(resultSet.getInt("id")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAllConnections();
        }
        return list;
    }


    public boolean sellBooks(Carritos_LibrosBean carritos_librosBean){
        mySQLRepository("UPDATE `bibliutez`.`libros` SET `stock` = ? WHERE (`id` = ?)");
        int catidad = 1;
        try {
            preparedStatement.setInt(1, catidad);
            preparedStatement.setInt(2, carritos_librosBean.getLibros_id().getId());
            status = preparedStatement.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAllConnections();
        }
        return status;
    }


    public boolean deleteCarrito(int id) {
        mySQLRepository("DELETE FROM `carritos_libros` WHERE `carritos_id` = ?");
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

}
