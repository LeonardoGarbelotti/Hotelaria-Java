/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controles;

import dao.ClienteDao;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import modelo.Cliente;

/**
 *
 * @author 1511 IRON
 */
@ManagedBean (name="loginControleCliente")
@ViewScoped
public class LoginControleCliente implements Serializable{
    private Cliente cli;
    
    public LoginControleCliente(){
        cli = new Cliente();
    }
    
    public String autenticar(){
        this.cli.setLogin(cli.getLogin().toUpperCase());
        ClienteDao dao = new ClienteDao();
        Cliente temp;
        temp = dao.autenticar(cli);
        if (temp == null){  // se houver erro, método autenticar no dao retorna null
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário ou senha inválidos", null));
            return null;  //fica na página
        } 
         //seta usuario na Sessao
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext ectx = context.getExternalContext();
        HttpSession session = (HttpSession) ectx.getSession(true);
        session.setAttribute("usuarioLogado", temp);        
        return "login-cliente-success";    
    }

    public Cliente getCli() {
        return cli;
    }

    public void setCli(Cliente cli) {
        this.cli = cli;
    }
    
}
