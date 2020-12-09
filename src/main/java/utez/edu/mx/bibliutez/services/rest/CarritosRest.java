package utez.edu.mx.bibliutez.services.rest;

import utez.edu.mx.bibliutez.model.carritos.CarritosBean;
import utez.edu.mx.bibliutez.model.carritos.CarritosDao;
import utez.edu.mx.bibliutez.model.carritos_libros.Carritos_LibrosBean;
import utez.edu.mx.bibliutez.model.carritos_libros.Carritos_LibrosDao;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;

@Path("/carritos")
public class CarritosRest {

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
    public int add(CarritosBean obj){
        return new CarritosDao().add(obj);
    }

    @GET
    @Path("/findOne")
    @Produces(MediaType.APPLICATION_JSON)
    public CarritosBean findOne(@QueryParam("id") int id){
        return new CarritosDao().findOne(id);
    }

    @GET
    @Path("/findAll")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<CarritosBean> findAll(){ return new CarritosDao().findAll(); }

    @DELETE
    @Path("/delete/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public boolean delete(@PathParam("id") int id){ return  new CarritosDao().delete(id); }

    @PUT
    @Path("/update")
    @Produces(MediaType.APPLICATION_JSON)
    public boolean update(CarritosBean bean){ return new CarritosDao().update(bean); }

    @GET
    @Path("/check")
    @Produces(MediaType.APPLICATION_JSON)
    public CarritosBean checkAccess(@QueryParam("email") String email, @QueryParam("password") String password){
        return new CarritosDao().checkAccess(email, password);
    }

}
