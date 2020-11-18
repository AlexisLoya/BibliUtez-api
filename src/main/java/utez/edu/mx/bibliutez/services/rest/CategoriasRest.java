package utez.edu.mx.bibliutez.services.rest;


import utez.edu.mx.bibliutez.model.categorias.CategoriaBean;
import utez.edu.mx.bibliutez.model.categorias.CategoriaDao;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;

@Path("/categorias")
public class CategoriasRest {
    @GET
    @Path("/hey")
    @Produces(MediaType.APPLICATION_JSON)
    public String hey() {
        return "hey";
    }


    @GET
    @Path("/add")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public int add(@QueryParam("obj")CategoriaBean obj){
        return new CategoriaDao().add(obj);
    }

    @GET
    @Path("/findOne")
    @Produces(MediaType.APPLICATION_JSON)
    public CategoriaBean findOne(@QueryParam("id") int id){
        return new CategoriaDao().findOne(id);
    }
    @GET
    @Path("/findAll")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<CategoriaBean> findAll(){
        return new CategoriaDao().findAll();
    }



}
