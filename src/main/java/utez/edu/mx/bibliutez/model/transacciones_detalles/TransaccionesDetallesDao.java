package utez.edu.mx.bibliutez.model.transacciones_detalles;

import utez.edu.mx.bibliutez.model.Dao;
import utez.edu.mx.bibliutez.model.DaoInterface;
import utez.edu.mx.bibliutez.model.libros.LibrosBean;
import utez.edu.mx.bibliutez.model.libros.LibrosDao;
import utez.edu.mx.bibliutez.model.transacciones.TransaccionesBean;
import utez.edu.mx.bibliutez.model.transacciones.TransaccionesDao;

import java.sql.SQLException;
import java.util.ArrayList;

public class TransaccionesDetallesDao extends
        Dao implements DaoInterface<TransaccionesDetallesBean> {

    @Override
    public int add(TransaccionesDetallesBean obj) {
        mySQLRepository("INSERT INTO transacciones_detalles (transacciones_id, libres_id, monto) values (?,?,?)");
        try {
            preparedStatement.setInt(1,obj.getTransacciones().getId());
            preparedStatement.setInt(2, obj.getLibros().getId());
            preparedStatement.setDouble(3, obj.getMonto());
            preparedStatement.executeUpdate();
            resultSet = preparedStatement.getGeneratedKeys();
            if(resultSet.next()) return resultSet.getInt();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAllConnections();
        }
        return 0;
    }

    @Override
    public boolean delete(int id) {
        mySQLRepository("delete from transacciones_detalles where id = ?");
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
    public boolean update(TransaccionesDetallesBean obj) {
        mySQLRepository("UPDATE transacciones_detalles SET transacciones_id = ?, libres_id = ?, monto = ?");
        status = false;
        try {
            preparedStatement.setInt(1,obj.getTransacciones().getId());
            preparedStatement.setInt(2, obj.getLibros().getId());
            preparedStatement.setDouble(3, obj.getMonto());
            status = preparedStatement.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAllConnections();
        }
        return status;
    }

    @Override
    public ArrayList<TransaccionesDetallesBean> findAll() {
        mySQLRepository("select * from transacciones_detalles");
        ArrayList<TransaccionesDetallesBean> list = new ArrayList<>();
        try {
            resultSet = preparedStatement.executeQuery();
            TransaccionesDetallesDao dao = new TransaccionesDetallesDao();
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
    public TransaccionesDetallesBean findOne(int id) {
        mySQLRepository("select * from transacciones_detalles where id = ?");
        TransaccionesDetallesBean detallesBean = null;
        try {
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                detallesBean = new TransaccionesDetallesBean(
                        resultSet.getInt("id"),
                        new TransaccionesDao().findOne(resultSet.getInt("transacciones_id")),
                        new LibrosDao().findOne(resultSet.getInt("libros_id")),
                        resultSet.getDouble("monto")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAllConnections();
        }
        return detallesBean;
    }
}
