package dev.java.kayo.CadastroDeNinjas.Ninjas;

import dev.java.kayo.CadastroDeNinjas.Missoes.MissoesModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NinjaDTO {

    private Long id;
    private String nome;
    private String email;
    private int idade;
    private MissoesModel missoes;
    private String rank;


}
