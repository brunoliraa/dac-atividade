import DAO.Conexao;
import DAO.PessoaDAO;
import DAO.PessoaDAOImp;
import model.Pessoa;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.time.LocalDate;

public class PessoaTest {

//    @BeforeClass
//    public void createtable(){
//        Conexao conexao = new Conexao();
//        conexao.createTable();
//    }

    @Test
    public void salvar() throws Exception{
        Pessoa pessoa = new Pessoa(4,"lucas",20,1.65, LocalDate.now());

        PessoaDAO pessoaDAO = new PessoaDAOImp();
        //pessoaDAO.save(pessoa);

        Assert.assertTrue(pessoaDAO.save(pessoa));

    }
    @Test
    public void findAll() throws Exception{
        PessoaDAO pessoaDAO = new PessoaDAOImp();
        Assert.assertNotNull(pessoaDAO.findAll());
        System.out.println(pessoaDAO.findAll());
    }
    @Test
    public void delete() throws Exception{
        PessoaDAO pessoaDAO = new PessoaDAOImp();
        Assert.assertTrue(pessoaDAO.delete(2));
    }

    @Test
    public void update()throws Exception{
        Pessoa pessoa = new Pessoa(4,"lucas fer",21,1.65, LocalDate.now());
        PessoaDAO pessoaDAO = new PessoaDAOImp();
        Assert.assertTrue(pessoaDAO.update(pessoa));
    }


}
