package utez.edu.mx.bibliutez.model.autores;

import utez.edu.mx.bibliutez.model.Dao;
import utez.edu.mx.bibliutez.model.DaoInterface;
import utez.edu.mx.bibliutez.model.editoriales.EditorialBean;

import java.sql.SQLException;
import java.util.ArrayList;

public class AutoresDao extends Dao implements DaoInterface<AutoresBean> {
    @Override
    public int add(AutoresBean obj) {
        mySQLRepository("insert into autores (nombre) values (?)");
        try {
            preparedStatement.setString(1, obj.getNombre());
            preparedStatement.executeUpdate();
            resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) return resultSet.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            System.out.println("llega");
            closeAllConnections();
        }
        return 0;
    }

    @Override
    public boolean delete(int id) {
        mySQLRepository("delete from autores where id = ?");
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
    public boolean update(AutoresBean obj) {
        mySQLRepository("update autores SET nombre = ? where id = ?");
        try {
            preparedStatement.setString(1, obj.getNombre());
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
    public ArrayList<AutoresBean> findAll() {
        mySQLRepository("select * from autores");
        ArrayList<AutoresBean> list = new ArrayList<>();
        try {
            resultSet = preparedStatement.executeQuery();
            AutoresDao dao = new AutoresDao();
            while (resultSet.next()){
                list.add(dao.findOne(resultSet.getInt("id")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeAllConnections();
        }
        return list;
    }

    @Override
    public AutoresBean findOne(int id) {
        mySQLRepository("select * from autores where id = ?");
        AutoresBean autor = null;
        try {
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                autor = new AutoresBean(
                        resultSet.getInt("id"),
                        resultSet.getString("nombre")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeAllConnections();
        }
        return autor;
    }
}
