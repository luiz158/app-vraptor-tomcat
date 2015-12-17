/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pro.professormatte.app.repository;

import br.pro.professormatte.app.data.DataException;
import br.pro.professormatte.app.data.PostDAO;
import br.pro.professormatte.app.models.Post;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;

/**
 *
 * @author marcio
 */
public class PostRepository {
    
    @Inject
    private PostDAO dao;

    public PostRepository() {
    }
    
    public Post create(Post post) throws DataException {
        /*
        aqui no repositório pode ser acrescentada alguma regra de negócio, no DAO só persistência.
        */
        try {
            return dao.save(post);
        } catch (DataException ex) {
            Logger.getLogger(PostRepository.class.getName()).log(Level.SEVERE, null, ex);
            throw new DataException(ex);
        }
    }
    
    public Post findById(Long id){
        return dao.findById(id);
    }
}
