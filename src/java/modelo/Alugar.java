/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author 1511 IRON
 */
@Entity
public class Alugar implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    @Temporal(TemporalType.DATE)
    private Date checkin;
    @Column
    @Temporal(TemporalType.DATE)
    private Date checkout;
    @ManyToOne(optional = false)     
    @JoinColumn(name = "quarto")
    private Quarto quarto;
    @ManyToOne(optional = false)       
    @JoinColumn(name = "usuario")
    private Cliente cliente;
    
    public Alugar(){
        this.quarto = new Quarto();
        this.checkin = new Date();
        this.checkout = new Date();
        this.cliente = new Cliente();
    }
    
    public Alugar(Quarto quarto, Date checkin, Date checkout, Cliente cliente){
        this.quarto = quarto;
        this.checkin = checkin;
        this.checkout = checkout;
        this.cliente = cliente;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCheckin() {
        return checkin;
    }

    public void setCheckin(Date checkin) {
        this.checkin = checkin;
    }

    public Date getCheckout() {
        return checkout;
    }

    public void setCheckout(Date checkout) {
        this.checkout = checkout;
    }

    public Quarto getQuarto() {
        return quarto;
    }

    public void setQuarto(Quarto quarto) {
        this.quarto = quarto;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    
}
