package com.memorand.helper;
// Memorand by Gengram © 2023

// IMPORTACIONES
import com.memorand.dao.RolUsuario;
import com.memorand.dao.service.RolUsuarioService;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginHelper implements Serializable 
{
    private String usuario;
    private String contrasena;
    private HttpServletRequest httpServletRequest;
    private HttpServletResponse httpServletResponse;
    
    public boolean login (HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
    {
        RolUsuarioService rolUsuarioService = null;
        RolUsuario rolUsuario = null;
        String page = null;
        
        this.httpServletRequest = httpServletRequest;
        this.httpServletResponse = httpServletResponse;
        usuario = httpServletRequest.getParameter("user");
        contrasena = httpServletRequest.getParameter("pass");
        
        if(!isLoginOk()) { return false; }
        
        rolUsuarioService = new RolUsuarioService();
        rolUsuario = rolUsuarioService.getRolUsuarioByContrasena(usuario, contrasena);
        
        if(rolUsuario == null) { return false; }
        
        httpServletRequest.getSession(true).setAttribute("rol",rolUsuario);
        switch (rolUsuario.getRol()) 
        {
            case "admin":
                page = "/feed/admin/index.jsp";
                break;
            case "usuario":
                page = "/feed/usuario/index.jsp?user="+usuario;
                break;
            default:
                return false;
        }
        
        return redirect(page);
    }
    
    public boolean isLoginOk()
    {
        try {
            httpServletRequest.login(usuario,contrasena);
            return true;
        } 
        catch (ServletException ex) {
            Logger.getLogger(LoginHelper.class.getName()).log(Level.SEVERE,null,ex);
        }
        return false;
    }
    
    public boolean redirect(String page)
    {
        try {
            httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + page);
            return true;
        } 
        catch (IOException ex) {
            Logger.getLogger(LoginHelper.class.getName()).log(Level.SEVERE,null,ex);
        }
        return false;
    }
    
    public boolean logout(HttpSession httpSession)
    {
        if(httpSession == null) {
            return false;
        }
        httpSession.invalidate();
        return true;
    }
}
