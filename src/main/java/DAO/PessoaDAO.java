package DAO;

import model.Pessoa;

import java.util.List;
import java.util.Optional;

public interface PessoaDAO {

    void save(Pessoa pessoa) throws Exception;
    List<Pessoa> findAll() throws Exception;
    boolean delete (long id) throws Exception;
    void update(Pessoa pessoa) throws Exception;


}

