/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pro.professormatte.app.controllers;

import br.com.caelum.vraptor.Consumes;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;
import br.pro.professormatte.app.data.DataException;
import br.pro.professormatte.app.repository.PostRepository;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author marcio
 */
@Controller
public class RestTestController {
    
    @Inject private Result result;
    @Inject private PostRepository repo;

    public RestTestController() {
    }
    
    @Get("/hello")
    public void sayHelloTest(){
        Map<String,String> json = new HashMap<>();
        json.put("version","1.0.0");
        json.put("describe","VRaptor4 Test Rest API");
        result.use(Results.json()).withoutRoot().from(json).serialize();
    }
    
    
    @Post("/api/post")
    @Consumes(MediaType.APPLICATION_JSON)
    public void createPost(br.pro.professormatte.app.models.Post post){
        try {
            post = repo.create(post);
            result.use(Results.json()).withoutRoot().from(post).serialize();
        } catch (DataException ex) {
            Logger.getLogger(RestTestController.class.getName()).log(Level.SEVERE, null, ex);
            result.use(Results.json()).withoutRoot().from(ex).serialize();
        }
    }
    
    @Get("/api/post/{id}")
    public void findPostById(Long id){
        result.use(Results.json()).withoutRoot().from(repo.findById(id)).serialize();
    }
    
}
