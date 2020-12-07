package utez.edu.mx.bibliutez.services.rest;




import utez.edu.mx.bibliutez.model.usuarios.UsuariosBean;
import utez.edu.mx.bibliutez.model.usuarios.UsuariosDao;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;

@Path("/usuarios")
public class UsuariosRest  {

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
    public int add(UsuariosBean obj){
        System.out.println("add->usuario");
        return new UsuariosDao().add(obj);}

    @GET
    @Path("/findOne")
    @Produces(MediaType.APPLICATION_JSON)
    public UsuariosBean findOne(@QueryParam("id") int id){
        return new UsuariosDao().findOne(id);
    }

    @GET
    @Path("/findAll")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<UsuariosBean> findAll(){
        return new UsuariosDao().findAll();
    }

    @DELETE
    @Path("/delete/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public boolean delete(@PathParam("id") int id){ return  new UsuariosDao().delete(id); }

    @PUT
    @Path("/update")
    @Produces(MediaType.APPLICATION_JSON)
    public boolean update(UsuariosBean bean){ return new UsuariosDao().update(bean); }

    @GET
    @Path("/findEmail")
    @Produces(MediaType.APPLICATION_JSON)
    public UsuariosBean findOne(@QueryParam("email") String email){
        return new UsuariosDao().findEmail(email);
    }

    @GET
    @Path("/check")
    @Produces(MediaType.APPLICATION_JSON)
    public boolean checkAccess(@QueryParam("email") String email,@QueryParam("password") String password){
        return new UsuariosDao().checkAccess(email, password);
    }
}
