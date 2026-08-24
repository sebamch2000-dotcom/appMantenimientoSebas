package com.senati.materialdesing;

public class Empleado {

    private String codigo;
    private String nombre;
    private String celular;
    private double sueldo;
    private String dni;

    public Empleado(String codigo, String nombre, String celular, double sueldo, String dni) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.celular = celular;
        this.sueldo = sueldo;
        this.dni = dni;
    }

    @Override
    public String toString() {
        return codigo + " - " + nombre + " - " + celular + " - S/. " + sueldo + " - DNI: " + dni;
    }
}