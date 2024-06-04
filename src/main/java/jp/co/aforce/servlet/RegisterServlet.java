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

@WebServlet(urlPatterns={"/servlet/RegisterServlet"}) 
public class RegisterServlet extends HttpServlet {
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
            String last_name=request.getParameter("last_name");
            String first_name=request.getParameter("first_name");
            String sex=request.getParameter("sex");
            int birth_year = Integer.parseInt(request.getParameter("birth_year"));
            int birth_month = Integer.parseInt(request.getParameter("birth_month"));
            int birth_day = Integer.parseInt(request.getParameter("birth_day"));
            String phone_number=request.getParameter("phone_number");
            String mail_address=request.getParameter("mail_address");
            String job=request.getParameter("job");

            PreparedStatement st=con.prepareStatement("INSERT INTO MEMBER_INFO (USER_ID,PASSWORD,LAST_NAME,FIRST_NAME,SEX,BIRTH_YEAR,BIRTH_MONTH,BIRTH_DAY,PHONE_NUMBER,MAIL_ADDRESS,JOB) VALUES (?,?,?,?,?,?,?,?,?,?,?)");

            st.setString(1, userID);
            st.setString(2, password);
            st.setString(3, last_name);
            st.setString(4, first_name);
            st.setString(5, sex);
            st.setInt(6, birth_year);
            st.setInt(7, birth_month);
            st.setInt(8, birth_day);
            st.setString(9, phone_number);
            st.setString(10,mail_address);
            st.setString(11,job);

            
            int rowsInserted = st.executeUpdate();

            if (rowsInserted > 0) {
            	out.println("<p>会員情報が登録されました。<br><a href=\"" + request.getContextPath() + "/view/login.jsp\">ログインはこちら</a></p>");

            } else {
                out.println("<p>会員情報の登録に失敗しました。</p>");
            }

            st.close();
            con.close();
        } catch (Exception e) {
            out.println("<p>エラー: " + e.getMessage() + "</p>");
        } finally {
            out.close();
        }
        Page.footer(out);
    }
}
