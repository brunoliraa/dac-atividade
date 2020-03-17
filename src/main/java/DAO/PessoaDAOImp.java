package DAO;

import model.Pessoa;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class PessoaDAOImp  implements PessoaDAO{
    private Conexao conexao;

    public PessoaDAOImp(){
        this.conexao = new Conexao();
    }


    @Override
    public void save(Pessoa pessoa) throws Exception {
        try{
            conexao.getConnection();
            String sql = "INSERT INTO PESSOA(id, nome, idade, altura, dataNascimento) VALUES(?,?,?,?,?)";
            PreparedStatement preparedStatement =this.conexao.getConnection().prepareStatement(sql);
            preparedStatement.setLong(1,pessoa.getId());
            preparedStatement.setString(2,pessoa.getNome());
            preparedStatement.setInt(3,pessoa.getIdade());
            preparedStatement.setDouble(4,pessoa.getAltura());
            preparedStatement.setDate(5,java.sql.Date.valueOf(pessoa.getDataNascimento()));
            preparedStatement.execute();
            preparedStatement.close();

        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }finally {
            this.conexao.FecharConexao();
        }
    }

    @Override
    public List<Pessoa> findAll() throws Exception {
        try{
            this.conexao.getConnection();
            String sql = "SELECT * FROM PESSOA";
            PreparedStatement preparedStatement = this.conexao.getConnection().prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Pessoa> pessoas = new ArrayList<>();
            while (resultSet.next()){
                Pessoa pessoa = new Pessoa();
                pessoa.setId(resultSet.getLong("id"));
                pessoa.setNome(resultSet.getString("nome"));
                pessoa.setIdade(resultSet.getInt("idade"));
                pessoa.setAltura(resultSet.getDouble("altura"));
                Date nascimento = resultSet.getDate("dataNascimento");
                String data = new SimpleDateFormat("dd/MM/yyyy").format(nascimento);
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate dataNascimento = LocalDate.parse(data, formatter);
                pessoa.setDataNascimento(dataNascimento);
                pessoas.add(pessoa);
            }
            this.conexao.FecharConexao();
            return pessoas;

        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return null;
    }


    @Override
    public boolean delete(long id) throws Exception {
        return false;
    }

    @Override
    public void update(Pessoa pessoa) throws Exception {

    }
}
