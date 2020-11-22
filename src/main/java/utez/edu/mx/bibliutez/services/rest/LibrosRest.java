package utez.edu.mx.bibliutez.services.rest;

import utez.edu.mx.bibliutez.model.categorias.CategoriaBean;
import utez.edu.mx.bibliutez.model.categorias.CategoriaDao;
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
    public CategoriaBean findOne(@QueryParam("id") int id){
        return new CategoriaDao().findOne(id);
    }

    @GET
    @Path("/findAll")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<CategoriaBean> findAll(){ return new CategoriaDao().findAll(); }

    @DELETE
    @Path("/delete/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public boolean delete(@PathParam("id") int id){ return  new CategoriaDao().delete(id); }

    @PUT
    @Path("/update")
    @Produces(MediaType.APPLICATION_JSON)
    public boolean update(CategoriaBean bean){ return new CategoriaDao().update(bean); }
}
