package utez.edu.mx.bibliutez.model.transacciones;

import utez.edu.mx.bibliutez.model.Dao;
import utez.edu.mx.bibliutez.model.DaoInterface;
import utez.edu.mx.bibliutez.model.clientes.ClientesBean;
import utez.edu.mx.bibliutez.model.clientes.ClientesDao;
import utez.edu.mx.bibliutez.model.libros.LibrosDao;

import java.sql.SQLException;
import java.util.ArrayList;

public class TransaccionesDao extends Dao implements DaoInterface<TransaccionesBean> {
    @Override
    public int add(TransaccionesBean obj) {
        mySQLRepository("INSERT INTO `bibliutez`.`transacciones` (`cliente_id`, `libros_id`, `monto_total`) VALUES (?,?,?)");
        try {

            preparedStatement.setInt(1, obj.getCliente().getId());
            preparedStatement.setInt(2, obj.getLibro().getId());
            preparedStatement.setDouble(3, obj.getMonto_total());
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
        mySQLRepository("delete from transacciones where id =?");
        status = false;
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
    public boolean update(TransaccionesBean obj) {
        mySQLRepository("UPDATE `bibliutez`.`transacciones` SET `cliente_id` = ?, `libros_id` = ?, `monto_total` = ? WHERE (`id` = ?)");
        status = false;
        try {
            preparedStatement.setInt(1, obj.getCliente().getId());
            preparedStatement.setInt(3, obj.getLibro().getId());
            preparedStatement.setDouble(2, obj.getMonto_total());
            status = preparedStatement.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAllConnections();
        }
        return status;
    }

    @Override
    public ArrayList<TransaccionesBean> findAll() {
        mySQLRepository("select * from transacciones");
        ArrayList<TransaccionesBean> list = new ArrayList<>();
        try {
            resultSet = preparedStatement.executeQuery();
            TransaccionesDao dao = new TransaccionesDao();
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

    public ArrayList<TransaccionesBean> findHistory(int id) {
        mySQLRepository("select * from transacciones where cliente_id = ?");
        ArrayList<TransaccionesBean> list = new ArrayList<>();
        try {
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            LibrosDao librosDao = new LibrosDao();
            ClientesDao clientesDao =  new ClientesDao();
            while (resultSet.next()) {
                list.add(new TransaccionesBean(
                        resultSet.getInt("id"),
                        clientesDao.findOne(resultSet.getInt("cliente_id")),
                        librosDao.findOne(resultSet.getInt("libros_id")),
                        resultSet.getDouble("monto_total")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAllConnections();
        }
        return list;
    }

    @Override
    public TransaccionesBean findOne(int id) {
        mySQLRepository("select * from transacciones where id = ?");
        TransaccionesBean bean = null;
        try {
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                bean = new TransaccionesBean(
                        resultSet.getInt("id"),
                        new ClientesDao().findOne(resultSet.getInt("cliente_id")),
                        new LibrosDao().findOne(resultSet.getInt("libros_id")),
                        resultSet.getDouble("monto_total")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAllConnections();
        }
        return bean;
    }
}
