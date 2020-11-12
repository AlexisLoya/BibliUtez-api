package utez.edu.mx.bibliutez.services.rest;

import utez.edu.mx.bibliutez.model.libros.LibrosBean;
import utez.edu.mx.bibliutez.model.libros.LibrosDao;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;

@Path("/tienda")
public class LibrosRest {

    @GET
    @Path("/find")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<LibrosBean> find(){
        return new LibrosDao().findAll();
    }

    @GET
    @Path("/find/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public LibrosBean find(@PathParam("id") int id){
        return new LibrosDao().findOne(id);
    }
}
