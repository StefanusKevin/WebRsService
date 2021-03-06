/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package service;

import com.google.gson.Gson;
import helper.KlinikHelper;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import pojos.Klinik;

/**
 * REST Web Service
 *
 * @author admin
 */
@Path("Klinik")
public class KlinikResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of PasienResource
     */
    public KlinikResource() {
    }

    /**
     * Retrieves representation of an instance of services.PasienResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/json")
    public Response getJson() {
        
     return Response.status(200)
           .entity(KlinikHelper.toJson())
           .header("Access-Control-Allow-Origin", "*")
           .header("Access-Control-Allow-Methods",
                        "GET,POST,HEAD,OPTIONS,PUT")
           .header("Access-Control-Allow-Headers",
                        "Content-Type,X-Requested-With,accept,Origin,Access-Control-Request-Method,Access-Control-Request-Headers")
           .header("Access-Exposed-Headers",
                        "Access-Control-Allow-Origin,Access-Control-Allow-Credentials")
           .header("Access-Support-Credentials",
                        "true")
           .header("Acces-Control-Max-Age", "20")
           .header("Access-Preflight-Maxage", "20")
                
             .build();
            
    }
    
    @POST
   @Path("addKlinik")
   @Consumes(MediaType.APPLICATION_JSON)
   public Response addNewKlinik(String data){
       Gson gson = new Gson();
       Klinik klinik = gson.fromJson(data, Klinik.class);
       KlinikHelper help = new KlinikHelper();
       help.addNewKlinik(klinik.getIdKlinik(), klinik.getNama(), klinik.getSpesialis());
       return Response
               .status(200)
               .entity(klinik)
               .build();
       
   }

    /**
     * PUT method for updating or creating an instance of PasienResource
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    public void putJson(String content) {
    }
}
