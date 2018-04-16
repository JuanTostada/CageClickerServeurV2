/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import generated.World;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

//import Services;

/**
 * REST Web Service
 *
 * @author Maxime
 */

@Path("generic")
public class GenericResource {

    @Context
    private UriInfo context;
    public Services services;

    final GsonBuilder builder = new GsonBuilder();
    final Gson gson = builder.create();
    /**
     * Creates a new instance of GenericResource
     */
    public GenericResource() {
        services = new Services();
    }

    /**
     * Retrieves representation of an instance of rest.GenericResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_XML)
    @Path("world")
    public World getXml() {
        //TODO return proper representation object
        return services.readWorldFromXml();
        //throw new UnsupportedOperationException();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("world")
    public String getXmlJson() {
        //TODO return proper representation object
        return new Gson().toJson(getXml());
        //throw new UnsupportedOperationException();
    }
    /**
     * PUT method for updating or creating an instance of GenericResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content) {
    }
}
