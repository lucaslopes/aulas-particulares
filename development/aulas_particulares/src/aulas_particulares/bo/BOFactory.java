/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aulas_particulares.bo;

import java.sql.Connection;
import aulas_particulares.dao.DAOBase;
import aulas_particulares.dao.Data;
import aulas_particulares.to.TOBase;
import org.json.JSONArray;

/**
 *
 * @author dirceubelem
 */
public class BOFactory {

    public static void insert(DAOBase d, TOBase t) throws Exception {
        
        Connection c;
        c = null;
        
        TOBase to = getEmail(d, t);


        try {        
            if(to == null){
                c = Data.openConnection();
                d.insert(c, t);
            }else{
                throw new Exception("Erro ao persistir objeto.");
            }
        
        } finally {
            c.close();
        }
    }

    public static void update(DAOBase d, TOBase t) throws Exception {
        
        Connection c;
        c = null;
        
        try {
            c = Data.openConnection();

            d.update(c, t);

        } finally {
            c.close();
        }
    }

    public static void delete(DAOBase d, TOBase t) throws Exception {
        
        Connection c;
        c = null;
        
        try {
            c = Data.openConnection();

            d.delete(c, t);

        } finally {
            c.close();
        }
    }

    public static TOBase get(DAOBase d, TOBase t) throws Exception {
        
        Connection c;
        c = null;
        
        try {
            c = Data.openConnection();

            return d.get(c, t);

        } finally {
            c.close();
        }
    }
    
    public static TOBase getAuthentic(DAOBase d, TOBase t) throws Exception {
        
        Connection c;
        c = null;
        
        
        try {
            c = Data.openConnection();

            return d.getAuthentic(c, t);

        } finally {
            c.close();
        }
    }
    
   
    public static JSONArray getUser(DAOBase d, TOBase t) throws Exception {
        
        Connection c;
        c = null;
        
        try {
            c = Data.openConnection();

            return d.getUser(c, t);

        } finally {
            c.close();
        }
    }
    
    public static TOBase getEmail(DAOBase d, TOBase t) throws Exception {
        
        Connection c;
        c = null;
        
        try {
            c = Data.openConnection();

            return d.getEmail(c, t);

        } finally {
            c.close();
        }
    }

    public static JSONArray list(DAOBase d) throws Exception {
        
        Connection c;
        c = null;
        
        try {
            c = Data.openConnection();

            return d.list(c);

        } finally {
            c.close();
        }
    }
}
