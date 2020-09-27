package com.company;

import javax.lang.model.type.ArrayType;
import java.util.ArrayList;
import java.util.List;

public class Pedidos {

    private List<Pratos> pratosPedido = new ArrayList<>();
    private List<Vinhos> vinhosPedido = new ArrayList<>();
    private List<Bebidas> bebidasPedido = new ArrayList<>();
    private String desc;
    private int id = 0;
    private double total;
    private String idX;
    private String coment;


    public List<Pratos> getPratosPedido() {
        return pratosPedido;
    }

    public void setPratosPedido(List<Pratos> pratosPedido) {
        this.pratosPedido = pratosPedido;
    }

    public List<Vinhos> getVinhosPedido() {
        return vinhosPedido;
    }

    public void setVinhosPedido(List<Vinhos> vinhosPedido) {
        this.vinhosPedido = vinhosPedido;
    }

    public List<Bebidas> getBebidasPedido() {
        return bebidasPedido;
    }

    public void setBebidasPedido(List<Bebidas> bebidasPedido) {
        this.bebidasPedido = bebidasPedido;
    }


    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getIdX() {
        return idX;
    }

    public void setIdX(String idX) {
        this.idX = idX;
    }

    public String getComent() {
        return coment;
    }

    public void setComent(String coment) {
        this.coment = coment;
    }
}