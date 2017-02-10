/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.hu.to4.groep1.services;

/**
 *
 * @author Jeroen
 */
public interface Service<E,ID> {
    
    void create(E entity);
    
    E find(ID id);
    
    E update(E entity);
    
    void delete(E entity);
    
    
}
