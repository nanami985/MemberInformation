package jp.co.aforce.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jp.co.aforce.tool.Page;

@WebServlet(urlPatterns={"/servlet/DeleteServlet"}) 
public class DeleteServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out=response.getWriter();
        Page.header(out);
        
        try {
            InitialContext ic=new InitialContext();
            DataSource ds=(DataSource)ic.lookup("java:/comp/env/jdbc/member_information"); 
            Connection con=ds.getConnection();
            
            String userID=request.getParameter("userID"); 
            String password=request.getParameter("password");

            PreparedStatement st=con.prepareStatement("DELETE FROM MEMBER_INFO WHERE USER_ID=? AND PASSWORD=?");

            st.setString(1, userID);
            st.setString(2, password);
            
            int rowsDeleted = st.executeUpdate();

            if (rowsDeleted > 0) {
            	response.sendRedirect(request.getContextPath() + "/view/DeleteOK.jsp");
            } else {
                out.println("<p>該当する会員情報が見つかりませんでした。</p>");
            }

            st.close();
            con.close();
        } catch (Exception e) {
            out.println("<p>エラー: " + e.getMessage() + "</p>");
        } finally {
            out.close();
            Page.footer(out);
        }
    }
}
