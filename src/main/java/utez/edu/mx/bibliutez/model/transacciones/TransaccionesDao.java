package utez.edu.mx.bibliutez.model.transacciones;

import utez.edu.mx.bibliutez.model.Dao;
import utez.edu.mx.bibliutez.model.DaoInterface;

import java.util.ArrayList;

public class TransaccionesDao extends Dao implements DaoInterface<TransaccionesBean> {
    @Override
    public int add(TransaccionesBean obj) {
        return 0;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public boolean update(TransaccionesBean obj) {
        return false;
    }

    @Override
    public ArrayList<TransaccionesBean> findAll() {
        return null;
    }

    @Override
    public TransaccionesBean findOne(int id) {
        return null;
    }
}
