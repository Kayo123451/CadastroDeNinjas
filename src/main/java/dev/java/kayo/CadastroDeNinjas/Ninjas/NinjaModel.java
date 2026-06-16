package dev.java.kayo.CadastroDeNinjas.Ninjas;

import dev.java.kayo.CadastroDeNinjas.Missoes.MissoesModel;
import jakarta.persistence.*;

//Entity transforma a classe em uma entidade do banco de dados
@Entity
@Table(name = "tb_cadastro")
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

//    Construtores
    public NinjaModel() {
    }
    public NinjaModel(String nome, String email, int idade) {
        this.nome = nome;
        this.email = email;
        this.idade = idade;
    }

//    Getters And Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}
