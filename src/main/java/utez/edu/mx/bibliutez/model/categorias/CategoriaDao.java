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
        mySQLRepository("UPDATE categorias SET nombre = ? where id=?");
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
        CategoriaDao dao = new CategoriaDao();
       System.out.println(dao.add(new CategoriaBean("Acción")));
        //System.out.println(dao.update(new CategoriaBean(2,"ciencia ficción")));
    }
}
