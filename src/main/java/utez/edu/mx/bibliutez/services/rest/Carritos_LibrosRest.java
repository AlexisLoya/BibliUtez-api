package utez.edu.mx.bibliutez.services.rest;


import utez.edu.mx.bibliutez.model.carritos_libros.Carritos_LibrosBean;
import utez.edu.mx.bibliutez.model.carritos_libros.Carritos_LibrosDao;
import utez.edu.mx.bibliutez.model.usuarios.UsuariosDao;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;

@Path("/carritos_libros")
public class Carritos_LibrosRest {

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
    public int add(Carritos_LibrosBean obj){ return new Carritos_LibrosDao().add(obj);}

    @GET
    @Path("/findOne")
    @Produces(MediaType.APPLICATION_JSON)
    public Carritos_LibrosBean findOne(@QueryParam("id") int id){
        return new Carritos_LibrosDao().findOne(id);
    }

    @GET
    @Path("/findAll")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Carritos_LibrosBean> findAll(){ return new Carritos_LibrosDao().findAll(); }

    @GET
    @Path("/findCarrito")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Carritos_LibrosBean> findCarrito(@QueryParam("id") int id){
        return new Carritos_LibrosDao().findCarrito(id);
    }

    @DELETE
    @Path("/delete/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public boolean delete(@PathParam("id") int id){ return  new Carritos_LibrosDao().delete(id); }

    @PUT
    @Path("/update")
    @Produces(MediaType.APPLICATION_JSON)
    public boolean update(Carritos_LibrosBean bean){ return new Carritos_LibrosDao().update(bean); }

    @POST
    @Path("/sell")
    public boolean sellBook(Carritos_LibrosBean bean){ return  new Carritos_LibrosDao().sellBooks(bean);}

    @DELETE
    @Path("/deleteCarrito/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public boolean deleteCarrito(@PathParam("id") int id){ return  new Carritos_LibrosDao().deleteCarrito(id); }



}
