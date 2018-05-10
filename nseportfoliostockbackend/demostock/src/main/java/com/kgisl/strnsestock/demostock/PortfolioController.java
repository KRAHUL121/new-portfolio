package com.kgisl.strnsestock.demostock;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import com.kgisl.strnsestock.demostock.Portfolio;
//import com.kgfsl.forum.Agenda;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/portfolio")
public class PortfolioController {

    @Autowired
    private PortfolioService portfolioService;
    private PortfolioRepository portfoilioRepository;
    // @GetMapping("/get")
    // public @ResponseBody ResponseEntity<List<Portfolio>> get() {
    //     System.out.println("GET ALL CALLED");
    //     portfolioService.getAll();
    //     System.out.println("portfolioService.getAll()"+portfolioService.getAll());
    //     return new ResponseEntity<>(portfolioService.getAll(), HttpStatus.OK);
    // }

    // @PostMapping("/post")
    // public ResponseEntity<?> post(@RequestBody Portfolio portfolio,UriComponentsBuilder ucBuilder) {
    //     System.out.println("Post bck called"+portfolio);
        
    //     portfolioService.save(portfolio);
        
    //     HttpHeaders headers = new HttpHeaders();
    //     // headers.setLocation(ucBuilder.path("/get/{portfolioid}").buildAndExpand(portfolio.getaId()).toUri());
    //     System.out.println("Post bck called"+  portfolioService.save(portfolio));
    //     return new ResponseEntity<>(  portfolioService.save(portfolio),HttpStatus.CREATED);

    // }
    

    @PutMapping("/put/{portfolioidId}")
    public ResponseEntity<?> put(@PathVariable Long portfolioidId, @RequestBody Portfolio portfolio ) {

        portfolioService.save(portfolio);
       
        return new ResponseEntity<>(portfolio,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{pId}")
    public ResponseEntity<?> delete(@PathVariable Long pId) {
System.out.println("Delete Id"+pId);
        portfolioService.delete(pId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

@GetMapping("/get")
public @ResponseBody ResponseEntity<List<Portfolio>> all() {
    System.out.println("GET ALL CALLED");
    return new ResponseEntity<>(portfolioService.getAll(), HttpStatus.OK);
}


@PostMapping("/post")
public ResponseEntity<?> post(@RequestBody Portfolio portfolio, UriComponentsBuilder ucBuilder) {

   System.out.println("Post data"+portfolio.id+portfolio.cat+portfolio.symbol);
   portfolio.setCat(portfolio.cat);
   portfolio.setId(portfolio.id);
   portfolio.setSymbol(portfolio.symbol);
   portfolioService.save(portfolio);

    HttpHeaders headers = new HttpHeaders();
    headers.setLocation(ucBuilder.path("/get/{id}").buildAndExpand(portfolio.getId()).toUri());
    return new ResponseEntity<>(portfolio,headers, HttpStatus.CREATED);

}

}
