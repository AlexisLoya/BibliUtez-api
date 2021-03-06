package utez.edu.mx.bibliutez.model.usuarios;

import utez.edu.mx.bibliutez.model.Dao;
import utez.edu.mx.bibliutez.model.DaoInterface;
import utez.edu.mx.bibliutez.model.roles.RolesDao;

import java.sql.SQLException;
import java.util.ArrayList;

public class UsuariosDao extends Dao implements DaoInterface<UsuariosBean> {
    @Override
    public int add(UsuariosBean obj) {
        mySQLRepository("INSERT INTO `bibliutez`.`usuarios` (`nombre`, `apellido1`, `apellido2`, `email`, `estatus`, `sexo`, `roles_id`, `password`) VALUES (?,?,?,?,?,?,?,?);");
        int a = 2;
        try {
            preparedStatement.setString(1, obj.getNombre());
            preparedStatement.setString(2, obj.getApellido1());
            preparedStatement.setString(3, obj.getApellido2());
            preparedStatement.setString(4, obj.getEmail());
            preparedStatement.setInt(5, obj.getEstatus());
            preparedStatement.setString(6, obj.getSexo());
            preparedStatement.setInt(7, a);
            preparedStatement.setString(8, obj.getPassword());
            preparedStatement.executeUpdate();
            resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                System.out.println( "Usuarioid:"+resultSet.getInt(1));
                return resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAllConnections();
        }
        return 0;
    }

    @Override
    public boolean delete(int id) {
        mySQLRepository("delete usuarios estatus = 0 where id = ?");
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
    public boolean update(UsuariosBean obj) {
        mySQLRepository("update usuarios SET nombre = ?, apellido1= ?, apellido2= ?, email= ?,estatus= ?, sexo= ?,rolesid=?,password=? where id= ?");
        try {
            preparedStatement.setString(1, obj.getNombre());
            preparedStatement.setString(2, obj.getApellido1());
            preparedStatement.setString(3, obj.getApellido2());
            preparedStatement.setString(4, obj.getEmail());
            preparedStatement.setInt(5, obj.getEstatus());
            preparedStatement.setString(6, obj.getSexo());
            preparedStatement.setInt(7, obj.getRolesid().getId());
            preparedStatement.setString(8, obj.getPassword());
            preparedStatement.setInt(9, obj.getId());
            status = preparedStatement.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAllConnections();
        }
        return status;
    }

    @Override
    public ArrayList<UsuariosBean> findAll() {
        mySQLRepository("select * from usuarios where estatus = 1");
        ArrayList<UsuariosBean> list = new ArrayList<>();
        try {
            resultSet = preparedStatement.executeQuery();
            UsuariosDao dao = new UsuariosDao();
            while (resultSet.next()){
                list.add(dao.findOne(resultSet.getInt("id")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public UsuariosBean findOne(int id) {
        mySQLRepository("select * from usuarios where estatus = 1 and id = ?");
        UsuariosBean usuario = null;
        try {
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                usuario = new UsuariosBean(
                        resultSet.getInt("id"),
                        resultSet.getString("nombre"),
                        resultSet.getString("apellido1"),
                        resultSet.getString("apellido2"),
                        resultSet.getString("email"),
                        resultSet.getInt("estatus"),
                        resultSet.getString("sexo"),
                        new RolesDao().findOne(resultSet.getInt("roles_id"))
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAllConnections();
        }
        return  usuario;
    }


    public UsuariosBean findEmail(String email) {
        mySQLRepository("select * from usuarios where estatus = 1 and email = ?");
        UsuariosBean usuario = null;
        try {
            preparedStatement.setString(1,email);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                usuario = new UsuariosBean(
                        resultSet.getInt("id"),
                        resultSet.getString("nombre"),
                        resultSet.getString("apellido1"),
                        resultSet.getString("apellido2"),
                        resultSet.getString("email"),
                        resultSet.getInt("estatus"),
                        resultSet.getString("sexo"),
                        new RolesDao().findOne(resultSet.getInt("roles_id"))
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAllConnections();
        }
        return  usuario;
    }

    public boolean updatePassword(UsuariosBean obj) {
        mySQLRepository("update usuarios SET password=? where id= ?");
        try {
            preparedStatement.setString(1, obj.getPassword());
            preparedStatement.setInt(2, obj.getId());
            status = preparedStatement.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAllConnections();
        }
        System.out.println(obj.getPassword());
        return status;
    }
    public UsuariosBean findFull(int id) {
        mySQLRepository("select * from usuarios where estatus = 1 and id = ?");
        UsuariosBean usuario = null;
        try {
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                usuario = new UsuariosBean(
                        resultSet.getInt("id"),
                        resultSet.getString("nombre"),
                        resultSet.getString("apellido1"),
                        resultSet.getString("apellido2"),
                        resultSet.getString("email"),
                        resultSet.getInt("estatus"),
                        resultSet.getString("sexo"),
                        new RolesDao().findOne(resultSet.getInt("roles_id")),
                        resultSet.getString("password")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAllConnections();
        }
        return  usuario;
    }
}
