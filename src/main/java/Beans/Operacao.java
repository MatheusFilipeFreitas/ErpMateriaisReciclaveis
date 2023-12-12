/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Beans;

import java.util.Date;
import lombok.*;

/**
 *
 * @author laboratorio
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Operacao {
    private int id_operacao;
    private Produto id_produto;
    private Usuario id_usuario;
    private String tipo_operacao;
    private String motivo;
    private int quantidade;
    private Date data_hora;    
}
