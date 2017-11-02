/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aulas_particulares.dao;

import java.sql.Connection;
import aulas_particulares.to.TOBase;
import org.json.JSONArray;

/**
 *
 * @author dirceubelem
 */
public class DAOBase {

    public void insert(Connection c, TOBase t) throws Exception {
    }
    
    public void update(Connection c, TOBase t) throws Exception {
    }
    
    public void delete(Connection c, TOBase t) throws Exception {
    }
    
    public TOBase get(Connection c, TOBase t) throws Exception {
        return null;
    }
    
    public TOBase getAuthentic(Connection c, TOBase t) throws Exception {
        return null;
    }
    
    public JSONArray list(Connection c) throws Exception{
        return null;
    }
    
    public JSONArray getUser(Connection c, TOBase t) throws Exception{
        return null;
    }
    
    public TOBase getEmail(Connection c, TOBase t) throws Exception{
        return null;
    }
    
}
