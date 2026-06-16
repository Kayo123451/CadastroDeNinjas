package dev.java.kayo.CadastroDeNinjas.Ninjas;

import dev.java.kayo.CadastroDeNinjas.Missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Entity transforma a classe em uma entidade do banco de dados
@Entity
@Table(name = "tb_cadastro")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NinjaModel {

//  Faz o java controlar pra mim com o ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private int idade;

//   @ManyToOne - Um ninja pode ter somente uma unica missao
    @ManyToOne
    @JoinColumn(name = "missoes_id")  //Foreing key ou chave estrangeira
    private MissoesModel missoes;

}
