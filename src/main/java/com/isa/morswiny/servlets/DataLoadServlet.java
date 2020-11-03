package com.isa.morswiny.servlets;

import com.isa.morswiny.freemarker.TemplateProvider;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/loadEvents")
@MultipartConfig()
public class DataLoadServlet extends HttpServlet {
    private Map<String, Object> model = new HashMap<>();
    private static final String TEMPLATE_NAME = "loadData";
    private static final String SAVE_DIR = "uploadFiles";
    private static final String ARCHIVE_DIR = "archivedFiles";


    @Inject
    private TemplateProvider templateProvider;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Template template = templateProvider.createTemplate(getServletContext(), TEMPLATE_NAME);
        model.put("user", "Admin");
        try {
            template.process(model, resp.getWriter());
        } catch (TemplateException e) {
            //STDOUT.error("Error while processing template: " + template.getName(), e);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String appPath = req.getServletContext().getRealPath("");
        String savePath = appPath + File.separator + SAVE_DIR;
        File fileSaveDir = new File(savePath);
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdir();
        }

        for (Part part : req.getParts()) {
            String fileName = extractFileName(part);
            fileName = new File(fileName).getName();
            String filePath = savePath + File.separator + fileName;
            if (!checkIfFileExists(filePath)) {
                part.write(filePath);
               // moveFileToArchive( ?????????,req);
                //TODO : wyswietlanie komunikatu po poprawnym zaladowaniu

                req.setAttribute("message", "Upload successful" );
            } else {
                //TODO: jakis tekst ze sie nie udalo
            }
        }

//        PrintWriter writer = resp.getWriter();
//        writer.append("Upload has been done successfully!\");
    }

    private boolean checkIfFileExists (String filePath){
        Path path = Paths.get(filePath);
        return Files.exists(path);
    }

    private void moveFileToArchive (File fileToArchive, HttpServletRequest req){
        String appPath = req.getServletContext().getRealPath("");
        String savePath = appPath + File.separator + ARCHIVE_DIR;
        File fileSaveDir = new File(savePath);
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdir();
        }
        fileToArchive.renameTo(new File (savePath));

    }


    private String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length() - 1);
            }
        }
        return "";
    }

}
