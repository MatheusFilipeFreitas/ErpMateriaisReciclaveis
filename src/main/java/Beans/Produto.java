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
public class Produto {
    private int id_produto;
    private String cod;
    private String descricao;
    private int estoque;
    private Date validade;
    
    @Override
    public String toString() {
        return this.descricao;
    }
}
