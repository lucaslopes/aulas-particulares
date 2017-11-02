/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aulas_particulares.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import aulas_particulares.to.TOBase;
import aulas_particulares.to.TOUser;
import org.json.JSONArray;

/**
 *
 * @author dirceubelem
 */
public class DAOUser extends DAOBase {

    @Override
    public void insert(Connection c, TOBase t) throws Exception {

        String sql = " insert into usuario (user_name, email, senha, telefone, aluno, ativo) values (?, ?, ?, ?, ?, ?) ";

        TOUser to = (TOUser) t;

        List<Object> p = new ArrayList<>();

        //p.add(to.getId());
        p.add(to.getUserName());
        p.add(to.getEmail());
        p.add(to.getPassword());
        p.add(to.getTelefone());
        p.add(to.getAluno());
        p.add(to.geAtivo());

        Data.executeUpdate(c, sql, p);

    }

    @Override
    public void update(Connection c, TOBase t) throws Exception {
        
        String sql = " update usuario set user_name = ?, email = ?, senha = ?, telefone = ?, aluno = ?, ativo = ? where id_user = ? ";

        TOUser to = (TOUser) t;

        List<Object> p = new ArrayList<>();

        p.add(to.getUserName());
        p.add(to.getEmail());
        p.add(to.getPassword());
        p.add(to.getId());
        p.add(to.getTelefone());
        p.add(to.getAluno());
        p.add(to.geAtivo());

        Data.executeUpdate(c, sql, p);
    }

    @Override
    public void delete(Connection c, TOBase t) throws Exception {
        
        String sql = " delete from usuario where id_user = ? ";

        TOUser to = (TOUser) t;

        List<Object> p = new ArrayList<>();
        
        p.add(to.getId());

        Data.executeUpdate(c, sql, p);
    }

    @Override
    public TOBase get(Connection c, TOBase t) throws Exception {
        
        String sql = " SELECT id_user, user_name, email, senha, telefone, aluno, ativo FROM usuario WHERE id_user = ? ";
        
        TOUser to = (TOUser) t;

        List<Object> p = new ArrayList<>();
        p.add(to.getId());

        ResultSet rs = null;

        try {
            //TOUser to = (TOUser) t;

            rs = Data.executeQuery(c, sql, p);// to.getId());

            if (rs.next()) {
                return new TOUser(rs);
            } else {
                return null;
            }

        } finally {
            rs.close();
        }
    }

    @Override
    public JSONArray list(Connection c) throws Exception{
        
        JSONArray ja = new JSONArray();
        
        String sql = " select id_user, user_name, email, senha, telefone, aluno, ativo from usuario order by user_name ";
  
        ResultSet rs = null;

        try {
            
            rs = Data.executeQuery(c, sql);

            while (rs.next()) {
                
                TOUser t = new TOUser(rs);
                ja.put(t.getJson());
                
            }
        } finally {
            rs.close();
        }
        
        return ja;
    }
    
    @Override
    public TOBase getAuthentic(Connection c, TOBase t) throws Exception {
                
        String sql = "SELECT id_user, user_name, email, senha, telefone, aluno, ativo FROM usuario WHERE email = ? AND senha = ?";
        
        TOUser to = (TOUser) t;

        List<Object> p = new ArrayList<>();
        p.add(to.getEmail());
        p.add(to.getPassword());

        ResultSet rs = null;

        try {
            //TOUser to = (TOUser) t;

            rs = Data.executeQuery(c, sql, p);// to.getId());

            if (rs.next()) {
                return new TOUser(rs);
            } else {
                return null;
            }

        } finally {
            rs.close();
        }
    }
    
    @Override
    public JSONArray getUser(Connection c, TOBase t) throws Exception{
        
        JSONArray ja = new JSONArray();
        
        String sql = " SELECT id_user, user_name, email, senha, telefone, aluno, ativo FROM usuario WHERE id_user = ? ";
        
        TOUser to = (TOUser) t;

        List<Object> p = new ArrayList<>();
        p.add(to.getId());

        ResultSet rs = null;

        try {
            //TOUser to = (TOUser) t;

            rs = Data.executeQuery(c, sql, p);// to.getId());

            if (rs.next()) {
                
                TOUser u = new TOUser(rs);
                ja.put(u.getJson());
                return ja;
            } else {
                return null;
            }

        } finally {
            rs.close();
        }
    }
    
    @Override
    public TOBase getEmail(Connection c, TOBase t) throws Exception{
        
        JSONArray ja = new JSONArray();
        
        String sql = " SELECT id_user, user_name, email, senha, telefone, aluno, ativo FROM usuario WHERE email = ? ";
        
        TOUser to = (TOUser) t;

        List<Object> p = new ArrayList<>();
        p.add(to.getEmail());

        ResultSet rs = null;

        
        try {
            //TOUser to = (TOUser) t;

            rs = Data.executeQuery(c, sql, p);// to.getId());

            if (rs.next()) {
                return new TOUser(rs);
            } else {
                return null;
            }

        } finally {
            rs.close();
        }
    }
    
}
