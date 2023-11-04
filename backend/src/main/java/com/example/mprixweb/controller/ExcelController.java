package com.example.mprixweb.controller;


import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.example.mprixweb.helper.ExcelHelper;
import com.example.mprixweb.service.ExcelService;

@RestController
@RequestMapping("/excel")
@CrossOrigin(origins="http://localhost:4200")
public class ExcelController {

    @Autowired
    ExcelService excelService;
    private static final Logger LOGGER = Logger.getLogger( "ExcelController" );

    @PostMapping("/save/articles")
    public ResponseEntity<?> saveExcelToTableArticles() {
        //String message = "";
            try {
                excelService.saveExcelToTableArticles();
                LOGGER.info(" Saved the file successfully: ");
                return new ResponseEntity<>(HttpStatus.OK);
            } catch (Exception e) {
                LOGGER.severe("Il y a une exception : "+e);
                return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
            }
    }

    @PostMapping("/save/articlesmission/{idMiss}")
    public ResponseEntity<?> saveExcelToTableArticlesMission(@PathVariable(name= "idMiss") Long idMiss) {
        //String message = "";
        try {
            excelService.saveExcelToTableArticlesMission(idMiss);
            LOGGER.info(" Saved the file successfully: ");
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.severe("ERROR : "+e);
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }


    @PostMapping("/upload/articles")
    public ResponseEntity<?> uploadFileArticles(@RequestParam("file") MultipartFile file, @RequestParam("name") String filename) {
        System.out.println("fileNameArticle : " + ExcelHelper.fileNameArticle + "----- pathArticles : " + ExcelHelper.pathArticles );
        if (ExcelHelper.hasExcelFormat(file)) {
            try {
                excelService.saveFileArticles(file, filename);
                LOGGER.info("File saved in the path successfully");
                return new ResponseEntity<>(HttpStatus.OK);
            } catch (Exception e) {
                LOGGER.severe("ERROR : " +e);
                return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
            }
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/upload/articlesmission")
    public ResponseEntity<?> uploadFileArticleMission(
            @RequestParam("file") MultipartFile file,
            @RequestParam("name") String filename )
    {
        if (ExcelHelper.hasExcelFormat(file)) {
            try {
                excelService.saveFileArticleMissionPrix(file, filename);
                return new ResponseEntity<>(HttpStatus.OK);
            } catch (Exception e) {
                LOGGER.severe("ERROR : " +e);
                return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
            }
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }


}