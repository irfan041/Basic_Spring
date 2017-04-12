/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Spring.services;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import org.springframework.stereotype.Service;
import org.springframework.web.context.ServletConfigAware;
import org.springframework.web.multipart.MultipartFile;

@Service
public class StudentRegistrationService implements ServletConfigAware {

    ServletContext servletContext;

    public String upload(MultipartFile image, String uploadBasePath) {
        String fileName = image.getOriginalFilename();
        try {
            if (!image.isEmpty()) {
                String extension = fileName.substring(fileName.lastIndexOf("."), fileName.length());
                String myFileName = System.currentTimeMillis() + extension;
                byte[] bytes = image.getBytes();
                File f = new File(uploadBasePath + "suploads");
                if (!f.exists()) {
                    f.mkdir();

                }
                File serverfile = new File(f.getAbsolutePath() + File.separator + myFileName);
                FileOutputStream fout = new FileOutputStream(serverfile);
                BufferedOutputStream stream = new BufferedOutputStream(fout);
                stream.write(bytes);
                stream.close();
                return myFileName;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    @Override
    public void setServletConfig(ServletConfig sc) {
        servletContext = sc.getServletContext();
    }

}
