package com.joaopedro.clientCrud.classes;

/**
 *
 * @author joaopedrocnmota
 */
public enum UserType {
    ADMIN(1, "Administrador"),
    COMUM(2, "Usuário");

    private int cod;
    private String desc;

    private UserType(int cod, String desc) {
        this.cod = cod;
        this.desc = desc;
    }

    public int getCod() {
        return cod;
    }

    public String getDesc() {
        return desc;
    }

    public static UserType toEnum(Integer cod) {
        if(cod == null) {
            return null;
        } 
        
        for(UserType x: UserType.values()){
            if(cod.equals(x.getCod())){
                return x;
            }
        }
        
        throw new IllegalArgumentException("Tipo invalido" + cod);
    }
}
