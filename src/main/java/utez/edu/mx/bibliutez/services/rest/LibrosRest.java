package utez.edu.mx.bibliutez.services.rest;


import utez.edu.mx.bibliutez.model.libros.LibrosBean;
import utez.edu.mx.bibliutez.model.libros.LibrosDao;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;

@Path("/libros")
public class LibrosRest {

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
    public int add(LibrosBean obj){return new LibrosDao().add(obj);}

    @GET
    @Path("/findOne")
    @Produces(MediaType.APPLICATION_JSON)
    public LibrosBean findOne(@QueryParam("id") int id){
        return new LibrosDao().findOne(id);
    }

    @GET
    @Path("/findAll")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<LibrosBean> findAll(){
        return new LibrosDao().findAll();
    }

    @DELETE
    @Path("/delete/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public boolean delete(@PathParam("id") int id){ return  new LibrosDao().delete(id); }

    @PUT
    @Path("/update")
    @Produces(MediaType.APPLICATION_JSON)
    public boolean update(LibrosBean bean){ return new LibrosDao().update(bean); }
}
