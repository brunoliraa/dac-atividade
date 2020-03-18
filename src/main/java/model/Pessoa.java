package model;

import java.time.LocalDate;

public class Pessoa {
    private long id;
    private String nome;
    private int idade;
    private double altura;
    private LocalDate dataNascimento;

    public Pessoa(){

    }
    public Pessoa(long id, String nome, int idade, double altura, LocalDate dataNascimento){
        this.id=id;
        this.nome= nome;
        this.idade=idade;
        this.altura=altura;
        this.dataNascimento=dataNascimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;

    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", idade=" + idade +
                ", altura=" + altura +
                ", dataNascimento=" + dataNascimento +
                '}';
    }
}
