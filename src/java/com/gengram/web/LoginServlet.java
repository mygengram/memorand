package com.gengram.web;

import com.gengram.dao.service.*;
import com.gengram.dao.*;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/loginstaff")
public class LoginServlet extends HttpServlet {
    
    private UsuariosService usuariosService;

    public void init() {
        usuariosService = new UsuariosService();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        String correo = request.getParameter("correo");
        String password = request.getParameter("pass");
        
        Usuarios usuario = new Usuarios();
        usuario.setCorreo_usuario(correo);
        usuario.setPass_usuario(password);

        if (usuariosService.getLogin(usuario)) {
            
            Usuarios aux = new Usuarios();
            aux = usuariosService.getUsuarioCorreo(correo);
                    
            HttpSession session = request.getSession();
            session.setAttribute("id",aux.getId_usuario());

            if(aux.getTipo_usuario().equals("staff")) 
                response.sendRedirect("staff.jsp");
            else
                response.sendRedirect("/index.jsp?intruso=nostaff");
            
        } else {
            HttpSession session = request.getSession();
            response.sendRedirect("/index.jsp?intruso=incorrect");
        }
    }
    
}
