import DAO.Conexao;
import DAO.PessoaDAO;
import DAO.PessoaDAOImp;
import model.Pessoa;

import java.time.LocalDate;

public class App {
    public static void main(String[] args) {
        Conexao conexao = new Conexao();
//        try {
//            conexao.getConnection();
//        }catch (Exception ex){
//            System.out.println(ex.getMessage());
//        }
//        Pessoa pessoa = new Pessoa();
//        pessoa.setDataNascimento(LocalDate.now());
//        pessoa.setId(2);
//        pessoa.setNome("joao");
//        pessoa.setIdade(20);
//        pessoa.setAltura(2);
        //conexao.createTable();

        PessoaDAO pessoaDAO = new PessoaDAOImp();
//        try{
//            pessoaDAO.save(pessoa);
//        }catch (Exception ex){
//            System.out.println(ex.getMessage());
//        }
        try{
            System.out.println(pessoaDAO.findAll());
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }

    }
}
