package com.rer.appLiterAlura.Model;

public enum Idioma {
    Español("es", "Español"),
    Ingles("en", "Inglés"),
    Frances("fr", "Francés"), ;

    private final String codigo;
    private final String nombre;

    Idioma(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }
    public String getCodigo() { return codigo; }
    public String getNombre() { return nombre; }
    public static Idioma getIdiomaPorCodigo(String codigo) {
        for (Idioma idioma : values()) {
            if (idioma.getCodigo().equals(codigo)) {
                return idioma;
            }
        }
        return null;
    }
}
