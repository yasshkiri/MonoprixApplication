package com.example.mprixweb.service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.List;
import java.util.Objects;

import com.example.mprixweb.entities.ArticleMission;
import com.example.mprixweb.entities.Articles;
import com.example.mprixweb.entities.mission;
import com.example.mprixweb.repository.ArticlesMissionRepo;
import com.example.mprixweb.repository.ArticlesRepo;
import com.example.mprixweb.repository.MissionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.mprixweb.helper.ExcelHelper;

import javax.annotation.PostConstruct;


@Service
public class ExcelService {

    @Autowired
    ArticlesRepo articlesRepo;
    @Autowired
    ArticlesMissionRepo articlesMissionRepo;
    @Autowired
    MissionRepo missionRepo;

    public void saveExcelToTableArticlesMission(Long idmiss) {
        try {
            String absoblutPath = Objects.requireNonNull(this.getClass().getClassLoader().getResource(ExcelHelper.pathArticlesMissionPrix)).getPath();
            System.out.println("excelFilesPath : " + ExcelHelper.pathArticlesMissionPrix);
            System.out.println("absoblutPath : " + absoblutPath);
            File file = new File(absoblutPath + ExcelHelper.fileNameArticleMission);
            InputStream fileInputStream = Files.newInputStream(file.toPath());
            List<ArticleMission> articlesMission = ExcelHelper.excelToArticlesMission(fileInputStream);
            mission newMission = missionRepo.findById(idmiss).get();
            articlesMission.forEach(art -> art.setId_miss(newMission));
            articlesMissionRepo.saveAll(articlesMission);
            file.delete();
        } catch (Exception e) {
            throw new RuntimeException("Fail to store excel data in table Article Mission: " + e.getMessage());
        }
    }

    public void saveExcelToTableArticles() {
        try {
            String absoblutPath = Objects.requireNonNull(this.getClass().getClassLoader().getResource(ExcelHelper.pathArticles)).getPath();
            System.out.println("excelFilesPath : " + ExcelHelper.pathArticles);
            System.out.println("absoblutPath : " + absoblutPath);
            File file = new File(absoblutPath + '/' + ExcelHelper.fileNameArticle);
            InputStream fileInputStream = Files.newInputStream(file.toPath());
            List<Articles> articles = ExcelHelper.excelToArticles(fileInputStream);
            articlesRepo.saveAll(articles);
            file.delete();
        } catch (Exception e) {
            throw new RuntimeException("Fail to store excel data in table Article: " + e.getMessage());
        }
    }

    public void saveFileInPath(MultipartFile file, String filename, String excelFilesPath) {
        try {
            String absoblutPath = this.getClass().getClassLoader().getResource(excelFilesPath).getPath();
            System.out.println("excelFilesPath : " + excelFilesPath);
            System.out.println("absoblutPath : " + absoblutPath);
            file.transferTo(new File(absoblutPath + '/' + filename));
        } catch (IOException e) {
            throw new RuntimeException("Fail to store file in specific path: " + e.getMessage());
        }
    }

    public void saveFileArticleMissionPrix(MultipartFile file, String filename) {
        saveFileInPath(file, ExcelHelper.fileNameArticleMission, ExcelHelper.pathArticlesMissionPrix);
    }
    public void saveFileArticles(MultipartFile file, String filename) {
        saveFileInPath(file, ExcelHelper.fileNameArticle, ExcelHelper.pathArticles);
    }
}
