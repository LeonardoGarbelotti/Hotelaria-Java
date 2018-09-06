/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import dao.Dao;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import modelo.Cliente;

/**
 *
 * @author 1511 IRON
 */
@FacesConverter(value = "clienteConverter", forClass = Cliente.class)
public class ClienteConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        String nome;
        Cliente temp = null;
        Dao<Cliente> dao = new Dao(Cliente.class);
        try {
            nome = value;
            temp = dao.buscarPorNomeCliente(nome);
        } catch (Exception e) {
            throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Selecione um usuário"));
        }
        return temp;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object obj) {
        if (obj instanceof Cliente) {
            Cliente u = (Cliente) obj;
            return u.getNome();
        }
        return "";
    }
}