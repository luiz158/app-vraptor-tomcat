/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pro.professormatte.app.controllers;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;

/**
 *
 * @author marcio
 */
@Controller
public class RestTestController {
    
    @Inject private Result result;

    public RestTestController() {
    }
    
    @Get("/hello")
    public void sayHelloTest(){
        Map<String,String> json = new HashMap<>();
        json.put("version","1.0.0");
        json.put("describe","VRaptor4 Test Rest API");
        result.use(Results.json()).withoutRoot().from(json).serialize();
    }
    
}
