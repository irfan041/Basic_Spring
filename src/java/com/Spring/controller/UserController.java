/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Spring.controller;

import com.Spring.command.LoginCommand;
import com.Spring.dao.StudentDao;
import com.Spring.dao.UserDAO;
import com.Spring.dto.StudentDetailDto;
import com.Spring.dto.StudentDetailDtoJoin;
import com.Spring.model.Student;
import com.Spring.services.LoginServices;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController {

    @Autowired
    UserDAO userDao;
    @Autowired
    LoginServices loginservice;
    @Autowired
    StudentDao studentDao;

    @RequestMapping("/")
    public String prepaarePage() {
        return "index";
    }

    @RequestMapping("/register/form1")
    public String registerPage(Model m) {
        Student student = new Student();
        m.addAttribute("cmd", student);
        return "Register";
    }

    @RequestMapping(value = {"/register/save"}, method = RequestMethod.POST)
    public String registerSave(@ModelAttribute("cmd") Student student, RedirectAttributes redirectattibutes) {

        if (student.getStudentId() != null) {
            userDao.update(student);
        } else {
            userDao.save(student);
        }

        redirectattibutes.addFlashAttribute("msg", "User Register SuccessFully");
        return "redirect:/userList";
    }

    @RequestMapping("/login/form")
    public String loginPage(Model m) {
        Student student = new Student();
        m.addAttribute("cmd", student);
        return "Login";
    }

    @RequestMapping(value = {"/login/fetch"}, method = RequestMethod.POST)
    public String loginFetch(@ModelAttribute("cmd") LoginCommand logincommand, RedirectAttributes redirectattibutes) {
        String mail = logincommand.getMail();
        String password = logincommand.getPassword();
        Student student = loginservice.Autheticate(mail, password);
        if (student != null) {
            redirectattibutes.addFlashAttribute("msg", "Student Login Successfull");
            return "redirect:/login/form";
        } else {
            redirectattibutes.addFlashAttribute("msg", "Id and Password Incurrect");
            return "redirect:/login/form";
        }

    }

    @RequestMapping("/userList")
    public String userList(Model m) {
        List<Student> studentList = userDao.findAll();
        System.out.println("slist");
        m.addAttribute("studentList", studentList);
        return "userList";
    }

    @RequestMapping("/DeleteUser")
    public String deleteUser(HttpServletRequest request) {
        try {
            Integer studentId = null;
            String studentStringId = request.getParameter("studentId");
            System.out.println(studentStringId);
            if (studentStringId != null && !studentStringId.equals("")) {
                studentId = new Integer(studentStringId);
                System.out.println("inside deleteUser");
            }
            userDao.delete(studentId);

            return "redirect:/userList";
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;

        }
    }

    @RequestMapping("/editUser")
    public String editUser(Model m, HttpServletRequest request) {
        String str = request.getParameter("studentId");
        Integer studentId = new Integer(str);
        Student student;
        student = userDao.findById(studentId);
        m.addAttribute("cmd", student);
        return "Register";
    }

    @RequestMapping("/checkEmail")
    @ResponseBody
    public Boolean checkEmail(Model m, HttpServletRequest request) {
        try {
            String mail = request.getParameter("mail");
            Integer studentId = null;
            if (request.getParameter("studentId") != null && !request.getParameter("studentId").equals("")) {
                studentId = new Integer(request.getParameter("studentId"));
            }
            return loginservice.isEmailExist(mail, studentId);
        } catch (Exception ex) {
            ex.printStackTrace();
            return Boolean.FALSE;
        }

    }

    @RequestMapping("/student1")
    public String renderStudent() {
        return "studentListJoin";
    }

    @RequestMapping("/studentListJoin")
    public String prepareStudentJoin() {
        return "studentListJoin";
    }
    @RequestMapping("/studentListJoin/list")
    @ResponseBody
    public List<StudentDetailDtoJoin> studentListJoin(Model m, HttpServletRequest request) {
        List<StudentDetailDtoJoin> detailDtos = loginservice.getStudentDetailDtos();
        m.addAttribute("dtos", detailDtos);
        return loginservice.getStudentDetailDtos();

    }
    @RequestMapping("/studentListJoin/delete")
    @ResponseBody
    public Boolean studentListDelete(@ModelAttribute("id") Integer id) {       
         try {
           if (id!= null && !id.equals("")) {
               System.out.println(id);
               //userId = new Integer(request.getParameter("userId"));
               return true;
           }
        System.out.println("inside studentListJoin/delete"+id);
            studentDao.delete(id);
      // return "redirect:/student";
      } catch (Exception ex) {
          ex.printStackTrace();
          return false;
      }
        return false;
    }
}
