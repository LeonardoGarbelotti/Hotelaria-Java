/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controles;

import dao.AdministradorDao;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import modelo.Administrador;


/**
 *
 * @author 1511 IRON
 */
@ManagedBean (name="loginControle")
@ViewScoped
public class LoginControle implements Serializable {
    private Administrador adm;
    
    public LoginControle(){
        adm = new Administrador();
    }
    
    public String autenticar(){
        this.adm.setLogin(adm.getLogin().toUpperCase());
        AdministradorDao dao = new AdministradorDao();
        Administrador temp;
        temp = dao.autenticar(adm);
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
        return "login-adm-success";    
    }
    
      public Administrador getAdm() {
        return adm;
    }

    public void setAdm(Administrador adm) {
        this.adm = adm;
    }

    
    
}

