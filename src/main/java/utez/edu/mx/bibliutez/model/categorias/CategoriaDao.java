package utez.edu.mx.bibliutez.model.categorias;

import utez.edu.mx.bibliutez.model.Dao;
import utez.edu.mx.bibliutez.model.DaoInterface;

import java.sql.SQLException;
import java.util.ArrayList;

public class CategoriaDao extends Dao implements DaoInterface<CategoriaBean> {


    @Override
    public int add(CategoriaBean obj) {
        mySQLRepository("insert into categorias (nombre) values (?)");
        try {
            preparedStatement.setString(1, obj.getNombre());
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
        mySQLRepository("delete from categorias where id =?");
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
    public boolean update(CategoriaBean obj) {
        mySQLRepository("update categorias nombre = ? where id=?");
        try {
            preparedStatement.setString(1, obj.getNombre());
            preparedStatement.setInt(2, obj.getId());
            if (resultSet.next()) return true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAllConnections();
        }
        return false;
    }

    @Override
    public ArrayList<CategoriaBean> findAll() {
        mySQLRepository("select * from categorias");
        ArrayList<CategoriaBean> list = new ArrayList<>();
        try {
            resultSet = preparedStatement.executeQuery();
            CategoriaDao dao = new CategoriaDao();
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
    public CategoriaBean findOne(int id) {
        mySQLRepository("select * from categorias  where id=?");
        CategoriaBean categoria = null;
        try {
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                categoria = new CategoriaBean(
                        resultSet.getInt("id"),
                        resultSet.getString("nombre")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAllConnections();
        }
        return categoria;
    }

    public static void main(String[] args) {
        System.out.println(new CategoriaDao().findOne(1));
    }
}
