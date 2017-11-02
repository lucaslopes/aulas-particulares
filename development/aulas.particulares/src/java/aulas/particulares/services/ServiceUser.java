/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aulas.particulares.services;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import aulas_particulares.bo.BOFactory;
import aulas_particulares.dao.DAOUser;
import aulas_particulares.fw.Criptografia;
//import aulas_particulares.fw.Guid;
import aulas_particulares.to.TOUser;
import org.json.JSONArray;
import org.json.JSONObject;


/**
 * REST Web Service
 *
 * @author Sergio Pereira
 */
@Path("user")
public class ServiceUser {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ServiceUser
     */
    public ServiceUser() {
    }

      @GET
    @Path("teste")
    public String teste() throws Exception {
        
        JSONObject j = new JSONObject();
        j.put("success Simone na PPK", true);
        
        return j.toString();
    }
    

    @POST
    @Consumes("application/x-www-form-urlencoded")
    @Path("insert")
    public String insert(
            @FormParam("user_name") String user_name_u,
            @FormParam("tel") String tel_u,
            @FormParam("email") String email_u,
            @FormParam("senha") String senha_u,
            @FormParam("aluno") boolean aluno_u) throws Exception {

        JSONObject j = new JSONObject();

        try {

            TOUser t = new TOUser();
            t.setUserName(user_name_u);
            t.setEmail(email_u);
            t.setPassword(Criptografia.md5(senha_u+email_u));
            t.setTelefone(tel_u);
            t.setAluno(aluno_u);
            t.setAtivo(true);

            BOFactory.insert(new DAOUser(), t);
            
            TOUser ja = (TOUser) BOFactory.get(new DAOUser(), t);

            j.put("data", ja);
            j.put("success", true);
            
            if(t.getAluno()){
                j.put("load", "/aluno.jsp");
            }else{
                j.put("load", "/professor.jsp");
            }
        } catch (Exception e) {
            j.put("success", false);
            j.put("message", e.getMessage());
        }

        return j.toString();

    }
    
    @GET
    @Consumes("application/x-www-form-urlencoded")
    @Path("list")
    public String list() throws Exception {

        JSONObject j = new JSONObject();

        try {

            JSONArray ja = BOFactory.list(new DAOUser());

            j.put("data", ja);
            j.put("success", true);

        } catch (Exception e) {
            j.put("success", false);
            j.put("message", e.getMessage());
        }

        return j.toString();

    }


    @POST
    @Consumes("application/x-www-form-urlencoded")
    @Path("update")
    public String update(
            @PathParam("user_name") String user_name_u,
            @FormParam("tel") String tel_u,
            @PathParam("email") String email_u,
            @PathParam("senha") String senha_u,
            @PathParam("id_user") int id_user_u,
            @FormParam("aluno") boolean aluno_u) throws Exception {

        JSONObject j = new JSONObject();

        try {

            TOUser t = new TOUser();
            t.setId(id_user_u);

            t = (TOUser) BOFactory.get(new DAOUser(), t);

            if (t == null) {
                j.put("success", false);
                j.put("message", "Usuário não encontrado");
            } else {
                t.setUserName(user_name_u);
                t.setEmail(email_u);
                t.setPassword(Criptografia.md5(senha_u+email_u));
                t.setTelefone(tel_u);
                t.setAluno(aluno_u);
                t.setAtivo(true);
                t.setId(id_user_u);
                
                BOFactory.update(new DAOUser(), t);
                        
            }
            
            j.put("success", true);
            
            if(t.getAluno()){
                j.put("load", "/aluno.jsp");
            }else{
                j.put("load", "/professor.jsp");
            }
        } catch (Exception e) {
            j.put("success", false);
            j.put("message", e.getMessage());
        }

        return j.toString();

    }

    @POST
    @Consumes("application/x-www-form-urlencoded")
    @Path("delete/{id_user}")
    public String delete(@PathParam("id_user") int id_user_u) throws Exception {
        JSONObject j = new JSONObject();

        try {

            TOUser t = new TOUser();
            t.setId(id_user_u);

            t = (TOUser) BOFactory.get(new DAOUser(), t);

            if (t == null) {
                j.put("success", false);
                j.put("message", "Usuário não encontrado");
            } else {
                BOFactory.delete(new DAOUser(), t);
                j.put("success", true);
            }

        } catch (Exception e) {
            j.put("success", false);
            j.put("message", e.getMessage());
        }

        return j.toString();
    }
    
    
    @POST
    @Consumes("application/x-www-form-urlencoded")
    @Path("autentica")
    public String autentica(
            @FormParam("email") String email_u,
            @FormParam("senha") String senha_u) throws Exception {

        JSONObject j = new JSONObject();
        TOUser ja = null;
        
        try {

            TOUser t = new TOUser();
            t.setEmail(email_u);
            t.setPassword(Criptografia.md5(senha_u+email_u));
            
            ja = (TOUser) BOFactory.getAuthentic(new DAOUser(), t);
            

            if (ja == null) {
                j.put("success", false);
                j.put("message", "Usuário não encontrado");
            } else {
                
                JSONArray ju = BOFactory.getUser(new DAOUser(), ja);
                j.put("data", ju);
                j.put("success", true);
                if(ja.getAluno()){
                    j.put("load", "/aluno.jsp");
                }else{
                    j.put("load", "/professor.jsp");
                }
            }

        } catch (Exception e) {
            j.put("success", false);
            j.put("message", e.getMessage());
        }
            
        return j.toString();
        
    }
}
