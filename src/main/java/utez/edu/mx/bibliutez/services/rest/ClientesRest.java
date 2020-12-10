package utez.edu.mx.bibliutez.services.rest;


import utez.edu.mx.bibliutez.model.clientes.ClientesBean;
import utez.edu.mx.bibliutez.model.clientes.ClientesDao;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;

@Path("/clientes")
public class ClientesRest {

    @GET
    @Path("/hey")
    @Produces(MediaType.APPLICATION_JSON)
    public String hey() {
        return "hey";
    }


    @PUT
    @Path("/add")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public int add(ClientesBean obj){
        System.out.println("add->cliente");
        return new ClientesDao().add(obj);}

    @GET
    @Path("/findOne")
    @Produces(MediaType.APPLICATION_JSON)
    public ClientesBean findOne(@QueryParam("id") int id){
        return new ClientesDao().findOne(id);
    }

    @GET
    @Path("/findCliente")
    @Produces(MediaType.APPLICATION_JSON)
    public ClientesBean findCliente(@QueryParam("id") int id){
        return new ClientesDao().findCliente(id);
    }


    @GET
    @Path("/findAll")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<ClientesBean> findAll(){
        System.out.println("findAll->Clientes");
        return new ClientesDao().findAll(); }

    @DELETE
    @Path("/delete/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public boolean delete(@PathParam("id") int id){ return  new ClientesDao().delete(id); }

    @PUT
    @Path("/update")
    @Produces(MediaType.APPLICATION_JSON)
    public boolean update(ClientesBean bean){ return new ClientesDao().update(bean); }

}
