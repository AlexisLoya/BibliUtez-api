package utez.edu.mx.bibliutez.model.transacciones;

import utez.edu.mx.bibliutez.model.Dao;
import utez.edu.mx.bibliutez.model.DaoInterface;
import utez.edu.mx.bibliutez.model.clientes.ClientesBean;
import utez.edu.mx.bibliutez.model.clientes.ClientesDao;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

public class TransaccionesDao extends Dao implements DaoInterface<TransaccionesBean> {
    @Override
    public int add(TransaccionesBean obj) {
        mySQLRepository("INSERT INTO transacciones (cliente_id, monto_total, fecha) values (?,?,?)");
        try {
            preparedStatement.setInt(1,obj.getCliente().getId());
            preparedStatement.setDouble(2,obj.getMonto_total());
            preparedStatement.setDate(3, (Date) obj.getFecha());
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
        mySQLRepository("delete from transacciones where id =?");
        status = false;
        try {
            preparedStatement.setInt(1,id);
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
        mySQLRepository("UPDATE transacciones SET cliente = ?, monto_total = ?, fecha = ?");
        status = false;
        try {
            preparedStatement.setInt(1, obj.getCliente().getId());
            preparedStatement.setDouble(2, obj.getMonto_total());
            preparedStatement.setDate(3, (Date) obj.getFecha());
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
            while (resultSet.next()){
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
    public TransaccionesBean findOne(int id) {
        mySQLRepository("select * from transacciones where id = ?");
        TransaccionesBean bean = null;
        try {
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                bean = new TransaccionesBean(
                        resultSet.getInt("id"),
                        new ClientesDao().findOne(resultSet.getInt("cliente_id")),
                        resultSet.getDouble("monto_total"),
                        resultSet.getDate(String.valueOf(resultSet.getDate("fecha")))
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
