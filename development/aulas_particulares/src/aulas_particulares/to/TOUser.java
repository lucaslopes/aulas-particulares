/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aulas_particulares.to;

import java.sql.ResultSet;
import org.json.JSONObject;

/**
 *
 * @author dirceubelem
 */
public class TOUser extends TOBase {

    private int id_user;
    private String user_name;
    private String senha;
    private String email;
    private String telefone;
    private boolean aluno;
    private boolean ativo;
    
    
    public int getId() {
        return id_user;
    }

    public void setId(int id_user) {
        this.id_user = id_user;
    }

    public String getUserName() {
        return user_name;
    }

    public void setUserName(String user_name) {
        this.user_name = user_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getPassword() {
        return senha;
    }

    public void setPassword(String senha) {
        this.senha = senha;
    }
    
    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    public boolean getAluno() {
        return aluno;
    }

    public void setAluno(boolean aluno) {
        this.aluno = aluno;
    }
    
    public boolean geAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }    

    public TOUser() {
    }

    public TOUser(ResultSet rs) throws Exception {
        this.id_user = rs.getInt("id_user");
        this.user_name = rs.getString("user_name");
        this.email = rs.getString("email");
        this.senha = rs.getString("senha");
        this.telefone = rs.getString("telefone");
        this.aluno = rs.getBoolean("aluno"); 
        this.ativo = rs.getBoolean("ativo"); 
    }

    @Override
    public JSONObject getJson() throws Exception {
        JSONObject j = new JSONObject();

        j.put("id_user", id_user);
        j.put("user_name", user_name);
        j.put("email", email);
        j.put("telefone", telefone);
        j.put("aluno", aluno);
        j.put("ativo", ativo);

        return j;
    }
}

