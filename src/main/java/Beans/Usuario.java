/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Beans;

import lombok.*;

/**
 *
 * @author laboratorio
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Usuario {
    private int id_usuario;
    private String nome;
    private int cpf;
    
    @Override
    public String toString() {
        return this.nome;
    }
}
