package dev.java.kayo.CadastroDeNinjas.Ninjas;

import dev.java.kayo.CadastroDeNinjas.Missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

//Entity transforma a classe em uma entidade do banco de dados
@Entity
@Table(name = "tb_cadastro")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "missoes")
public class NinjaModel {

//  Faz o java controlar pra mim com o ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Column(name = "Nome")
    private String nome;

    @Column(unique = true)
    private String email;

    @Column(name = "Idade")
    private int idade;

    @Column(name = "Rank")
    private String rank;


//   @ManyToOne - Um ninja pode ter somente uma unica missao
    @ManyToOne
    @JoinColumn(name = "missoes_id")  //Foreing key ou chave estrangeira
    private MissoesModel missoes;

}
