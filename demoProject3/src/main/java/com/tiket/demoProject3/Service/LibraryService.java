package com.tiket.demoProject3.Service;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.awt.print.Book;

@Service
public class LibraryService {

    public ResponseEntity getBook(String id) throws UnirestException {
        try {
            HttpResponse<String> response  = Unirest.get("http://localhost:8080/app1/book").queryString("id", id).asString();
            if(response.getStatus()==200){
                Book booktest = response.getBody();

                return ResponseEntity.ok(response.getBody());
            }else if(response.getStatus()==404){
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.badRequest().build();
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    public ResponseEntity searchBook(String name) throws UnirestException {
        try {
            HttpResponse<String> response  = Unirest.get("http://localhost:8080/app1/search").queryString("name", name).asString();
            if(response.getStatus()==200 && !response.getBody().isEmpty()){
                return ResponseEntity.ok(response.getBody());
            }else if(response.getStatus()==404 || response.getBody().isEmpty()){
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.badRequest().build();
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    public ResponseEntity allBook() throws UnirestException {
        try {
            HttpResponse<String> response  = Unirest.get("http://localhost:8080/app1/allBook").asString();
            if(response.getStatus()==200 && !response.getBody().isEmpty()){
                return ResponseEntity.ok(response.getBody());
            }else if(response.getStatus()==404 || response.getBody().isEmpty()){
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.badRequest().build();
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
