/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Spring.controller;

import com.Spring.command.StudentRegisterCommand;
import com.Spring.dao.HobbiesDao;
import com.Spring.dao.StudentDao;
import com.Spring.dto.StudentDetailDto;
import com.Spring.model.RegisterStudent;
import com.Spring.model.StudentHobbies;
import com.Spring.services.StudentRegistrationService;
import com.Spring.util.UploadImageUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author irfan
 */
@Controller
public class StudentController {

    @Autowired
    StudentDao studentDao;
    @Autowired
    HobbiesDao hobbiesDao;
    @Autowired
    DataSourceTransactionManager dataSourceTransactionManager;

    @RequestMapping("/student")
    public String prepaarePage(Model m) {
        StudentRegisterCommand rs = new StudentRegisterCommand();

        List<String> genderList = new ArrayList<String>();
        genderList.add("Male");
        genderList.add("Female");

        m.addAttribute("genderList", genderList);
        m.addAttribute("cmd", rs);
        return "studentregistration";
    }

    @RequestMapping("/StudentSave")
    public String saveStudentRegister(@ModelAttribute("cmd") StudentRegisterCommand cmd, HttpServletRequest request,RedirectAttributes ra,Model m) {
        //for managing the both table data.this two line means diable the auto commit
         UploadImageUtil up = new UploadImageUtil();
        
        TransactionDefinition definition = new DefaultTransactionDefinition();
        TransactionStatus status = dataSourceTransactionManager.getTransaction(definition);
       
        try {//SaveStudent
             up.upload(cmd);
            Date date = new Date();
            StudentRegistrationService srs = new StudentRegistrationService();
            //String imagePath = srs.upload(imageFile,request.getServletContext().getInitParameter("upload_base_path"));
            RegisterStudent rs = cmd.getRegisterStudent();
            rs.setDOB(date);
            //rs.setImage(imagePath);
            studentDao.save(rs);

            // save Hobbies for Student
            String strHobbyCount = request.getParameter("hobbyCount");
            Integer hobbyCount = new Integer(strHobbyCount);

            for (Integer i = 0; i < hobbyCount; i++) {
                StudentHobbies sh = new StudentHobbies();
                sh.setHobby(request.getParameter("hobby" + i));
                System.out.println(request.getParameter("hobby" + i));
                sh.setStudentId(rs.getStudentId());
                hobbiesDao.save(sh);
            }
            dataSourceTransactionManager.commit(status);
        } catch (Exception e) {

            dataSourceTransactionManager.rollback(status);
            e.printStackTrace();
        }

//        m.addAttribute("genderList", genderList);
//        m.addAttribute("cmd", new StudentRegisterCommand());
        return "redirect:/";
    }

    @RequestMapping("/studentList")
    public String studentList(Model m ,RedirectAttributes ra,HttpSession session) {
       ServletContext servletContext = session.getServletContext();
        String uploadurl = servletContext.getInitParameter("upload_url");
        m.addAttribute("img_path", (uploadurl + File.separator));
        ra.addFlashAttribute("", "");
        List<RegisterStudent> studentList = studentDao.findAll();
        List<StudentDetailDto> dtos = new ArrayList<StudentDetailDto>();
        //String rootpath = System.getProperty("catalina.home") + File.separator + "suploads" + File.separator;

        for (RegisterStudent rs : studentList) {
            rs.setImage(rs.getImage());
            StudentDetailDto dto = new StudentDetailDto();
            dto.setRegisterStudent(rs);
            List<StudentHobbies> hobbieses = hobbiesDao.findByProperty("studentId", rs.getStudentId());
            dto.setHobbies(hobbieses);
            dtos.add(dto);
        }
        m.addAttribute("dtos", dtos);
        return "studentList";
    }

}
