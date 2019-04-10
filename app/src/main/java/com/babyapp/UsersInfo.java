package com.babyapp;

public class UsersInfo {
    private String editTextProducto;
    private String editTextTienda;
    private String editTextOferta;

    public UsersInfo(String editProducto,String editTienda, String editOferta){
        editTextProducto = editProducto;
        editTextTienda = editTienda;
        editTextOferta = editOferta;
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

    public void setLastName(String lastName) {
        editTextTienda = lastName;
    }

    public String getEditTextOferta() {
        return editTextOferta;
    }

    public void setEditTextOferta(String favFood) {
        editTextTienda = favFood;
    }
}
