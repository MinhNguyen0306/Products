
package Connect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Product;

public class LoadDB {
    public List<Product> getAll(){
        List<Product> PD = new ArrayList<Product>();
        
        Connection con = JTDSConnection.getConnect();
        
        String sql = "select * from PRODUCT";
        
        try{
            PreparedStatement prepare = con.prepareStatement(sql);
            ResultSet rs = prepare.executeQuery();
            
            while(rs.next()){
                Product pd = new Product();
                
                pd.setMaSP(rs.getString("maSP"));
                pd.setTenSP(rs.getString("tenSP"));
                pd.setGiaban(rs.getInt("giaban"));
                pd.setSoluong(rs.getInt("soluong"));
                
                PD.add(pd);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoadDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return PD;
    }
    
    public void addProduct(Product p){
        Connection con = JTDSConnection.getConnect();
        String sql = "insert into PRODUCT values(?,?,?,?)";
        
        try{
            PreparedStatement prepare = con.prepareStatement(sql);
            prepare.setString(1, p.getMaSP());
            prepare.setString(2, p.getTenSP());
            prepare.setFloat(3, p.getGiaban());
            prepare.setInt(4, p.getSoluong());
            
            int rs = prepare.executeUpdate();
            System.out.println(rs);   
        } catch (SQLException ex) {
            Logger.getLogger(LoadDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
