package utez.edu.mx.bibliutez.services.rest;


import utez.edu.mx.bibliutez.model.gerente.GerentesBean;
import utez.edu.mx.bibliutez.model.gerente.GerentesDao;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;

@Path("/gerente")
public class GerenteRest {
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
    public int add(GerentesBean obj){
        return new GerentesDao().add(obj);
    }

    @GET
    @Path("/findOne")
    @Produces(MediaType.APPLICATION_JSON)
    public GerentesBean findOne(@QueryParam("id") int id){
        return new GerentesDao().findOne(id);
    }

    @GET
    @Path("/findAll")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<GerentesBean> findAll(){ return new GerentesDao().findAll(); }

    @DELETE
    @Path("/delete/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public boolean delete(@PathParam("id") int id){ return  new GerentesDao().delete(id); }

    @PUT
    @Path("/update")
    @Produces(MediaType.APPLICATION_JSON)
    public boolean update(GerentesBean bean){ return new GerentesDao().update(bean); }
}
