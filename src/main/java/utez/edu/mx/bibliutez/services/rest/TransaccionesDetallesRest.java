package utez.edu.mx.bibliutez.services.rest;


import utez.edu.mx.bibliutez.model.transacciones_detalles.TransaccionesDetallesBean;
import utez.edu.mx.bibliutez.model.transacciones_detalles.TransaccionesDetallesDao;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;

public class TransaccionesDetallesRest {
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
    public int add(TransaccionesDetallesBean obj){
        return new TransaccionesDetallesDao().add(obj);
    }

    @GET
    @Path("/findOne")
    @Produces(MediaType.APPLICATION_JSON)
    public TransaccionesDetallesBean findOne(@QueryParam("id") int id){
        return new TransaccionesDetallesDao().findOne(id);
    }

    @GET
    @Path("/findAll")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<TransaccionesDetallesBean> findAll(){ return new TransaccionesDetallesDao().findAll(); }

    @DELETE
    @Path("/delete/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public boolean delete(@PathParam("id") int id){ return  new TransaccionesDetallesDao().delete(id); }

    @PUT
    @Path("/update")
    @Produces(MediaType.APPLICATION_JSON)
    public boolean update(TransaccionesDetallesBean bean){ return new TransaccionesDetallesDao().update(bean); }
}
