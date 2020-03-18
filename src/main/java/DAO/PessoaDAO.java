package DAO;

import model.Pessoa;

import java.util.List;
import java.util.Optional;

public interface PessoaDAO {

    boolean save(Pessoa pessoa) throws Exception;
    List<Pessoa> findAll() throws Exception;
    boolean delete (long id) throws Exception;
    boolean update(Pessoa pessoa) throws Exception;


}

