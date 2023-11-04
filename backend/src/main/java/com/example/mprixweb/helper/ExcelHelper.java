package com.example.mprixweb.helper;


import java.io.IOException;
import java.io.InputStream;
import java.util.*;

import com.example.mprixweb.entities.ArticleMission;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.example.mprixweb.entities .Articles;

public class ExcelHelper {
    public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
    static String[] HEADERs = { "id", "code_art",
            "reference_art",
            "design_art",
            "gamme_art",
            "id_structmarch",
            "marque_art",
            "prix_art"};

    static String SHEET = "Articles";
    public static final String pathArticlesMissionPrix = "excelFiles/articlesMissionPrix/";
    public static String fileNameArticleMission = "file_articles_mission.xlsx";
    public static String pathArticles = "excelFiles/articlesNouveaux/";
    public static String fileNameArticle= "file_articles.xlsx";


    public static boolean hasExcelFormat(MultipartFile file) {

        if (!TYPE.equals(file.getContentType())) {
            return false;
        }

        return true;
    }

    public static List<Articles> excelToArticles(InputStream is) {
        try {
            Workbook workbook = new XSSFWorkbook(is);

            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rows = sheet.iterator();

            List<Articles> articles = new ArrayList<Articles>();
            DataFormatter formatter = new DataFormatter();

            int rowNumber = 0;
            while (rows.hasNext()) {
                Row currentRow = rows.next();

                // skip header
                if (rowNumber == 0) {
                    rowNumber++;
                    continue;
                }

                Iterator<Cell> cellsInRow = currentRow.iterator();

                Articles article = new Articles();

                int cellIdx = 0;
                while (cellsInRow.hasNext()) {
                    Cell currentCell = cellsInRow.next();

                    switch (cellIdx) {
                        case 0:
                            article.setCode_art(currentCell.getStringCellValue());
                            break;

                        case 1:
                            article.setReference_art((int) currentCell.getNumericCellValue());
                            break;

                        case 2:
                            article.setDesign_art(currentCell.getStringCellValue());
                            break;

                        case 3:
                            article.setGamme_art((int) currentCell.getNumericCellValue());
                            break;

                        case 4:
                            article.setId_structmarch(Double.valueOf(currentCell.getNumericCellValue()).longValue());
                            break;

                        case 5:
                            article.setMarque_art(currentCell.getStringCellValue());
                            break;

                        case 6:
                            article.setPrix_art(currentCell.getNumericCellValue());
                            break;

                        default:
                            break;
                    }

                    cellIdx++;
                }

                article.setDatecreation(new Date(System.currentTimeMillis()));
                article.setDateUpdate(new Date(System.currentTimeMillis()));
                articles.add(article);
            }

            workbook.close();

            return articles;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
        }
    }

    public static List<ArticleMission> excelToArticlesMission(InputStream is) {
        try {
            Workbook workbook = new XSSFWorkbook(is);

            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rows = sheet.iterator();

            List<ArticleMission> articlesMission = new ArrayList<ArticleMission>();

            int rowNumber = 0;
            while (rows.hasNext()) {
                Row currentRow = rows.next();

                // skip header
                if (rowNumber == 0) {
                    rowNumber++;
                    continue;
                }

                Iterator<Cell> cellsInRow = currentRow.iterator();

                ArticleMission articleMission = new ArticleMission();

                int cellIdx = 0;
                while (cellsInRow.hasNext()) {
                    Cell currentCell = cellsInRow.next();

                    switch (cellIdx) {
                        case 0:
                            articleMission.setCodebarre_artM(currentCell.getStringCellValue());
                            break;

/*                        case 1:
                            articleMission.setReference_art((int) currentCell.getNumericCellValue());
                            break;*/

                        case 2:
                            articleMission.setDesign_artM(currentCell.getStringCellValue());
                            break;

                        case 3:
                            articleMission.setGamme_artM((int) currentCell.getNumericCellValue());
                            break;

/*                        case 4:
                            articleMission.setId_structmarch((long) currentCell.getNumericCellValue());
                            break;*/

                        case 5:
                            articleMission.setMarque_artM(currentCell.getStringCellValue());
                            break;

                        case 6:
                            articleMission.setDernier_prix(currentCell.getNumericCellValue());
                            break;

                        default:
                            break;
                    }

                    cellIdx++;
                }

                articleMission.setPlanifie(true);
                articleMission.setDatecreation(new Date(System.currentTimeMillis()));
                articleMission.setDateUpdate(new Date(System.currentTimeMillis()));
                articlesMission.add(articleMission);
            }

            workbook.close();


            return articlesMission;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
        }
    }
}
