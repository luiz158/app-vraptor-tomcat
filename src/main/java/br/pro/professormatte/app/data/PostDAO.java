/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pro.professormatte.app.data;

import br.pro.professormatte.app.models.Post;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 *
 * @author marcio
 */
public class PostDAO {
    
    @Inject
    private EntityManager manager;

    public PostDAO() {
    }

    public Post save(Post post) throws DataException {
        try {
            manager.persist(post);
            return post;
        } catch (Exception e) {
            throw new DataException(e);
        }
    }
    
    public Post findById(Long id){
        return manager.find(Post.class, id);
    }
    
    
}
