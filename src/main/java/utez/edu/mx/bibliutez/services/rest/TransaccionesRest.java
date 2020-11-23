package utez.edu.mx.bibliutez.services.rest;

import utez.edu.mx.bibliutez.model.transacciones.TransaccionesBean;
import utez.edu.mx.bibliutez.model.transacciones.TransaccionesDao;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;

@Path("/transacciones")
public class TransaccionesRest {

    @GET
    @Path("/hey")
    @Produces(MediaType.APPLICATION_JSON)
    public String hey() {
        return "hey";
    }


    @POST
    @Path("/add")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public int add(TransaccionesBean obj){
        return new TransaccionesDao().add(obj);
    }

    @GET
    @Path("/findOne")
    @Produces(MediaType.APPLICATION_JSON)
    public TransaccionesBean findOne(@QueryParam("id") int id){
        return new TransaccionesDao().findOne(id);
    }

    @GET
    @Path("/findAll")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<TransaccionesBean> findAll(){ return new TransaccionesDao().findAll(); }

    @DELETE
    @Path("/delete/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public boolean delete(@PathParam("id") int id){ return  new TransaccionesDao().delete(id); }

    @PUT
    @Path("/update")
    @Produces(MediaType.APPLICATION_JSON)
    public boolean update(TransaccionesBean bean){ return new TransaccionesDao().update(bean); }
}
