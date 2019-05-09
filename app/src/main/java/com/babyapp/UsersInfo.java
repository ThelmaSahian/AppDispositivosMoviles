package com.babyapp;

public class UsersInfo {
    private String editTextProducto;
    private String editTextTienda;
    private String editTextOferta;
    private String editTextSucursal;

    public UsersInfo(String editProducto,String editTienda, String editOferta, String editSucursal){
        editTextProducto = editProducto;
        editTextTienda = editTienda;
        editTextOferta = editOferta;
        editTextSucursal = editSucursal;
    }

    public String getEditTextProducto() {
        return editTextProducto;
    }

    public void setEditTextProducto(String firstName) {
        editTextProducto = firstName;
    }

    public String getEditTextTienda() {
        return editTextTienda;
    }

    public String getEditTextOferta() {
        return editTextOferta;
    }

    public void setEditTextOferta(String favFood) {
        editTextTienda = favFood;
    }

    public void setEditTextTienda(String editTextTienda) {
        this.editTextTienda = editTextTienda;
    }

    public String getEditTextSucursal() {
        return editTextSucursal;
    }

    public void setEditTextSucursal(String editTextSucursal) {
        this.editTextSucursal = editTextSucursal;
    }
}
