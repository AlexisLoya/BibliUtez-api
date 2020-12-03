package utez.edu.mx.bibliutez.model.libros;

import utez.edu.mx.bibliutez.model.Dao;
import utez.edu.mx.bibliutez.model.DaoInterface;
import utez.edu.mx.bibliutez.model.autores.AutoresDao;
import utez.edu.mx.bibliutez.model.categorias.CategoriaDao;
import utez.edu.mx.bibliutez.model.editoriales.EditorialDao;

import java.sql.SQLException;
import java.util.ArrayList;

public class LibrosDao extends Dao implements DaoInterface<LibrosBean> {
    @Override
    public int add(LibrosBean obj) {
        mySQLRepository("INSERT INTO `bibliutez`.`libros` (`nombre`, `editoriales`, `autores`, `categorias_id`, `precio`, `num_pag`, `stock`) VALUES (?,?,?,?,?,?,?)");
        try {
            preparedStatement.setString(1, obj.getNombre());
            preparedStatement.setString(2, obj.getEditoriales_id());
            preparedStatement.setString(3, obj.getAutores_id());
            preparedStatement.setInt(4, obj.getCategorias_id().getId());
            preparedStatement.setDouble(5, obj.getPrecio());
            preparedStatement.setInt(6, obj.getNum_pag());
            preparedStatement.setInt(7, obj.getStock());
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
        mySQLRepository("delete from libros where id = ?");
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
    public boolean update(LibrosBean obj) {
        mySQLRepository("update libros SET nombre ?, editoriales=?, autores=?, categorias_id=?, precio=?, num_pag=?, stock=? where id = ?");
        try {
            preparedStatement.setString(1, obj.getNombre());
            preparedStatement.setString(2, obj.getEditoriales_id());
            preparedStatement.setString(3, obj.getAutores_id());
            preparedStatement.setInt(4, obj.getCategorias_id().getId());
            preparedStatement.setDouble(5, obj.getPrecio());
            preparedStatement.setInt(6, obj.getNum_pag());
            preparedStatement.setInt(7, obj.getStock());
            preparedStatement.setInt(8, obj.getId());
            status = preparedStatement.executeUpdate()== 1;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAllConnections();
        }
        return status;
    }

    @Override
    public ArrayList<LibrosBean> findAll() {
        mySQLRepository("select * from libros");
        ArrayList<LibrosBean> list = new ArrayList<>();
        try {
            resultSet = preparedStatement.executeQuery();
            LibrosDao dao = new LibrosDao();
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
    public LibrosBean findOne(int id) {
        mySQLRepository("select * from libros  where id=?");
        LibrosBean libro = null;
        try {
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                CategoriaDao categoriaDao = new CategoriaDao();
                libro = new LibrosBean(
                        resultSet.getInt("id"),
                        resultSet.getString("nombre"),
                        resultSet.getString("editoriales"),
                        resultSet.getString("autores"),
                        categoriaDao.findOne(resultSet.getInt("categorias_id")),
                        resultSet.getDouble("precio"),
                        resultSet.getInt("num_pag"),
                        resultSet.getInt("stock")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAllConnections();
        }
        return libro;
    }
}
