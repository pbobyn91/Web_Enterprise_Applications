/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cst8218.boby0003.business;

import cst8218.boby0003.presentation.WidgetBoby;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Pat
 */
@Stateless
public class WidgetBobyFacade extends AbstractFacade<WidgetBoby> {

    @PersistenceContext(unitName = "my_persistence_unit")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public WidgetBobyFacade() {
        super(WidgetBoby.class);
    }
    
}