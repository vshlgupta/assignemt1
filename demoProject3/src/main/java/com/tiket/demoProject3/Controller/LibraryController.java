package com.tiket.demoProject3.Controller;

import com.mashape.unirest.http.exceptions.UnirestException;
import com.tiket.demoProject3.Service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/app2")
public class LibraryController {

    @Autowired private LibraryService libraryService;

    @GetMapping("/getBookInLibraryById")
    public ResponseEntity getBook(@RequestParam("id") String id) throws UnirestException {
        if(id==null || id.isEmpty()){
            return ResponseEntity.badRequest().body("No id in the request-param");
        }
        return libraryService.getBook(id);
    }


    @GetMapping("/searchInLibrary")
    public ResponseEntity searchBook(@RequestParam("name") String name) throws UnirestException{
        if(name.isEmpty() || name==null){
            return ResponseEntity.badRequest().body("No name in the request-param");
        }
        return libraryService.searchBook(name);
    }

    @GetMapping("/allBookInLibrary")
    public ResponseEntity allBook() throws UnirestException{
        return libraryService.allBook();
    }





}
