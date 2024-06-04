package jp.co.aforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import jp.co.aforce.beans.Customer;

public class CustomerDAO {
    
    public Customer search(String userID, String password) throws Exception {
        Customer customer = null;
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            // JNDIデータソースを取得
            InitialContext ic = new InitialContext();
            DataSource ds = (DataSource) ic.lookup("java:comp/env/jdbc/member_information"); // データベース名を修正
            
            // データベースに接続
            con = ds.getConnection();

            // SQL文の準備
            String sql = "SELECT * FROM MEMBER_INFO WHERE USER_ID=? AND PASSWORD=?"; // SQL文を修正
            st = con.prepareStatement(sql);
            st.setString(1, userID);
            st.setString(2, password);

            // SQLを実行して結果を取得
            rs = st.executeQuery();

            // 結果をCustomerオブジェクトにマッピング
            if (rs.next()) {
                customer = new Customer();
                customer.setMEMBER_ID(rs.getInt("MEMBER_ID")); // idをMEMBER_IDに変更
                customer.setUserId(rs.getString("USER_ID")); // カラム名を修正
                customer.setPassword(rs.getString("PASSWORD")); // カラム名を修正
            }
        } catch (Exception e) {
            // 例外が発生した場合、適切なメッセージを設定して投げる
            throw new Exception("データベースの検索中にエラーが発生しました。", e);
        } finally {
            // リソースの解放
            if (rs != null) {
                rs.close();
            }
            if (st != null) {
                st.close();
            }
            if (con != null) {
                con.close();
            }
        }

        return customer;
    }
}
