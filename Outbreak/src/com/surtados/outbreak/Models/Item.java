package com.surtados.outbreak.Models;

import com.surtados.outbreak.Utils.Dados;

public class Item {
    private String tipoDeItem;

    public Item(String tipoDeItem) {
        setTipoDeItem(tipoDeItem);
    }

    public String getTipoDeItem() {
        return tipoDeItem;
    }

    public void setTipoDeItem(String tipoDeItem) {
        this.tipoDeItem = tipoDeItem;
    }
}
