package utez.edu.mx.bibliutez.model.clientes;

import utez.edu.mx.bibliutez.model.Dao;
import utez.edu.mx.bibliutez.model.DaoInterface;
import utez.edu.mx.bibliutez.model.usuarios.UsuariosDao;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClientesDao extends Dao implements DaoInterface<ClientesBean> {
    @Override
    public int add(ClientesBean obj) {
        mySQLRepository("insert into clientes(fecha_nacimiento, telefono, usuariosBean, domicilio) values(?,?,?,?)");
        try {
            preparedStatement.setDate(1, (Date) obj.getFecha_nacimiento());
            preparedStatement.setString(2, obj.getTelefono());
            preparedStatement.setInt(3, obj.getUsuariosBean().getId());
            preparedStatement.setString(4, obj.getDomicilio());
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
        mySQLRepository("delete from clientes where id = ?");
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
    public boolean update(ClientesBean obj) {
        mySQLRepository("update clientes SET fecha_nacimiento = ?, telefono = ?,usuariosBean=?, domicilio = ? where id = ?");
        try {
            preparedStatement.setDate(1, (Date) obj.getFecha_nacimiento());
            preparedStatement.setString(2, obj.getTelefono());
            preparedStatement.setInt(3, obj.getUsuariosBean().getId());
            preparedStatement.setString(4, obj.getDomicilio());
            preparedStatement.setInt(5, obj.getId());
            status = preparedStatement.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAllConnections();
        }
        return status;
    }

    @Override
    public ArrayList<ClientesBean> findAll() {
        mySQLRepository("select * from clientes");
        ArrayList<ClientesBean> list = new ArrayList<>();
        try {
            resultSet = preparedStatement.executeQuery();
            ClientesDao dao = new ClientesDao();
            while (resultSet.next()){
                list.add(dao.findOne(resultSet.getInt("id")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAllConnections();
        }
        return list ;
    }

    @Override
    public ClientesBean findOne(int id) {
        mySQLRepository("select * from clientes where id = ?");
        ClientesBean cliente = null;
        try {
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                cliente = new ClientesBean(
                        resultSet.getInt("id"),
                        resultSet.getDate("fecha_nacimiento"),
                        resultSet.getString("telefono"),
                        new UsuariosDao().findOne(resultSet.getInt("id")),
                        resultSet.getString("domicilio")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAllConnections();
        }
        return cliente;
    }
}
