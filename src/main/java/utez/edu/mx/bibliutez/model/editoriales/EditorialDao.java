package utez.edu.mx.bibliutez.model.editoriales;

import sun.rmi.runtime.Log;
import utez.edu.mx.bibliutez.model.Dao;
import utez.edu.mx.bibliutez.model.DaoInterface;

import java.sql.SQLException;
import java.util.ArrayList;

public class EditorialDao extends Dao implements DaoInterface<EditorialBean> {
    private final String REPOSITORY = "SQLRepository";

    @Override
    public int add(EditorialBean obj) {
        mySQLRepository("insert into editoriales (nombre) values (?)");
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
        mySQLRepository("delete from editoriales where id =?");
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
    public boolean update(EditorialBean obj) {
        mySQLRepository("update editoriales nombre = ? where id=?");
        try {
            preparedStatement.setString(1, obj.getNombre());
            preparedStatement.setInt(2, obj.getId());
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
    public ArrayList<EditorialBean> findAll() {
        mySQLRepository("select * from editoriales");
        ArrayList<EditorialBean> list = new ArrayList<>();
        try {
            resultSet = preparedStatement.executeQuery();
            EditorialDao dao = new EditorialDao();
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

    @Override
    public EditorialBean findOne(int id) {
        mySQLRepository("select * from editoriales  where id=?");
        EditorialBean editorial = null;
        try {
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                editorial = new EditorialBean(
                        resultSet.getInt("id"),
                        resultSet.getString("nombre")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAllConnections();
        }
        return editorial;
    }

    public static void main(String[] args) {
        EditorialDao dao = new EditorialDao();

        if (dao.add(new EditorialBean(22, "Planetdfdgfkgdjfglkdjfglkdfjgdlkfjgdlkfgjdlkfgjdlkfgjdlfkgjdlfkgjdfglkjdflgkfdjglkdfjga")) == 0) {
            System.err.println("::::::::::::::::::>>>>>>>Error add editorial");
            return;
        }

        System.out.println(dao.findAll().size());
    }
}
