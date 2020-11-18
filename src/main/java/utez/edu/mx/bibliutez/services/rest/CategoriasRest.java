package utez.edu.mx.bibliutez.services.rest;


import utez.edu.mx.bibliutez.model.categorias.CategoriaBean;
import utez.edu.mx.bibliutez.model.categorias.CategoriaDao;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/categorias")
public class CategoriasRest {

    @GET
    @Path("/add")
    @Produces(MediaType.APPLICATION_JSON)
    public int add(@QueryParam("obj")CategoriaBean obj){
        return new CategoriaDao().add(obj);
    }

    @GET
    @Path("/findOne")
    @Produces(MediaType.APPLICATION_JSON)
    public CategoriaBean findOne(@QueryParam("id") int id){
        return new CategoriaDao().findOne(id);
    }


}
