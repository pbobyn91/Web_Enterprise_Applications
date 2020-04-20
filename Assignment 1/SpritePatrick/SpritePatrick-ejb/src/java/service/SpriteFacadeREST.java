/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import cst8218.boby0003.entity.Sprite;
import cst8218.boby0003.entity.AbstractFacade;
import java.util.List;
import java.util.Objects;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * This class allows for the implementation of the GET, POST, DELETE, and PUT options
 * 
 * @author Pat
 */

@Stateless
@RolesAllowed({"Admin", "RestGroup"})
@Path("cst8218.boby0003.entity.sprite")
public class SpriteFacadeREST extends AbstractFacade<Sprite> {

    @PersistenceContext(unitName = "SpritePatrickPU")
    private EntityManager em;

    /**
     * Constructor for this class
     */
    public SpriteFacadeREST() {
        super(Sprite.class);
    }
    
    /**
     * This is a method for POST that creates a new Sprite and if a Sprite with that ID already exists it updates the old sprite.
     * THIS DOES NOT WORK AS I TOOK THE @POST OUT
     * @param entity The sprite entity that is to be either created or updated
     */
    @Override
    public void create(Sprite entity) {
        super.create(entity);
    }
    
    /**
     * This is a method for POST that creates a new Sprite and if a Sprite with that ID already exists it updates the old sprite.
     * 
     * This is 3.f in the features section
     * My interpretation of this was that you had to create a new Sprite if one does not already exist. To do this I checked for an id,
     * if one was given then it goes on to the next step, if not it creates a new Sprite. The next step was the same idea except it creates a Sprite
     * with the given id or it updates an already existing sprite.
     * 
     * @param entity The sprite entity that is to be either created or updated
     * @return Returns a response
     */
    @POST
    public Response createPost(Sprite entity) {
        
        if (entity.getId() == null){
            
            if (!entity.check())
                entity.setDefault();
            
            super.create(entity);
            return Response.status(Response.Status.CREATED).build();
        } else {
        
            Sprite newSprite = super.find(entity.getId());
        
            try {
                if(newSprite == null){
                
                    if (!entity.check())
                        entity.setDefault();
                
                    super.create(entity);
                    return Response.status(Response.Status.CREATED).build();
            
                } else {
                    newSprite.updates(entity);
                }
                return Response.status(Response.Status.NO_CONTENT).build();
            } catch (Exception e){
                return Response.status(Response.Status.NOT_IMPLEMENTED).build();
            }
        }
    }
    
    /**
     * This method makes a copy of an older Sprite.
     * 
     * This was 3.c of the features section
     * This finds the sprite in the database and then updates it with the new values. If one is not found then it returns an HTTP response.
     * 
     * @param id The id of the sprite to be updated
     * @param entity The old Sprite that is meant to be updated
     * @return Returns a server Response
     */
    @POST
    @Path("{id}")
    public Response editPost(@PathParam("id") Long id, Sprite entity) {
        
        Sprite newSprite = super.find(id);
        
        if (super.find(id) == null)
            return Response.status(Response.Status.NOT_IMPLEMENTED).build();
        
        newSprite.updates(entity);
        return Response.status(Response.Status.CREATED).build();
    }

    /**
     * This method updates a sprite
     * 
     * 3.d of the features sections
     * This method edits the Sprite with the new features, otherwise it returns an HTTP Response.
     * 
     * @param id The id of the sprite to be updated
     * @param entity The old Sprite that is meant to be updated
     * @return Returns a response
     */
    @PUT
    @Path("{id}")
    public Response edit(@PathParam("id") Long id, Sprite entity) {
        
        if (!Objects.equals(id, entity.getId()))
            return Response.status(Response.Status.NOT_IMPLEMENTED).build();
                
        if (super.find(id) == null)
            return Response.status(Response.Status.NOT_IMPLEMENTED).build();
        
        super.edit(entity);
        return Response.status(Response.Status.NO_CONTENT).build();
        
    }
    
    /**
     * 
     * 3.e of features
     * Returns not implemented status as this is not supposed to work 
     * @param entity does nothing
     * @return Returns a status
     */
    @PUT
    public Response editRoot(Sprite entity) {
        return Response.status(Response.Status.NOT_IMPLEMENTED).build();
    }
    
    /**
     * Returns not implemented status
     * 
     * 3.e but without a Sprite in the body
     * 
     * @return Returns a status
     */
    @PUT
    public Response editRoot() {
        return Response.status(Response.Status.NOT_IMPLEMENTED).build();
    }

    /**
     * Deletes a Sprite
     * 
     * @param id The Sprites id that is to be deleted
     */
    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Long id) {
        super.remove(super.find(id));
    }

    /**
     * Returns the Sprite with this id
     * @param id The id of the Sprite to be retrieved
     * @return Returns the Sprite it finds
     */
    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Sprite find(@PathParam("id") Long id) {
        return super.find(id);
    }

    /**
     * GETs all of the Sprites in the application
     * 
     * @return Returns all of the Sprites
     */
    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Sprite> findAll() {
        return super.findAll();
    }

    /**
     * GETs a list of all the sprites within a range
     * 
     * @param from The first sprite
     * @param to The last sprite
     * @return Returns a range of Sprites
     */
    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Sprite> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    /**
     * GETs the count of all the sprites within the application
     * @return Returns the count
     */
    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    /**
     * 
     * @return Returns the entity manager
     */
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
