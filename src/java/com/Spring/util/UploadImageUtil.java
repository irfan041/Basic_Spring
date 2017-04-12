/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Spring.util;

import com.Spring.command.StudentRegisterCommand;
import com.Spring.model.RegisterStudent;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author irfan
 */
public class UploadImageUtil {
    public void upload(StudentRegisterCommand pc) {
        RegisterStudent p = pc.getRegisterStudent();
        MultipartFile file = pc.getFile();
      if (!file.isEmpty()) {
            try {
                String fname = file.getOriginalFilename();
                String[] name = fname.split("\\.");
                String fileName = System.currentTimeMillis() + "." + name[1];
                p.setImage(fileName);
                byte[] bytes = file.getBytes();

                String rootPath = System.getProperty("catalina.home");
                File dir;
                dir = new File(rootPath + File.separator + "studentuploads");
                if (!dir.exists()) {
                    dir.mkdir();
                }
                File serverfile = new File(dir.getAbsolutePath() + File.separator + fileName);
                BufferedOutputStream stream =
                        new BufferedOutputStream(new FileOutputStream(serverfile));
                stream.write(bytes);


                stream.close();


            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
        }
    }
  }
