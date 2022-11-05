/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Smartphone_sales_management.DAO;

import Smartphone_sales_management.DBConnect;
import Smartphone_sales_management.DTO.Model_KhuyenMai;
import java.sql.PreparedStatement;
import Smartphone_sales_management.DTO.Model_ChiTietKM;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Vector;
import javax.swing.JOptionPane;

/**
 *
 * @author lehongthai
 */
public class QuanLyKhuyenMai_DAO {
     DBConnect db = new DBConnect();
    private PreparedStatement preparedStatement;
    ResultSet rs = null;

  public ArrayList<Model_KhuyenMai> getDanhSachKhuyenMai_DAO() {

        ArrayList<Model_KhuyenMai> dskm = new ArrayList<Model_KhuyenMai>();
        db.setupConnection();
        try {
            PreparedStatement stm = db.getConnection().prepareStatement("select * from khuyenmai");
            rs = stm.executeQuery();
            while (rs.next()) {
                Model_KhuyenMai a = new Model_KhuyenMai();
                a.setMakm(rs.getInt("Makm"));
                a.setTenkm(rs.getString("Tenkm"));              
                a.setPhantramkm(rs.getFloat("Ptkm"));
                a.setTrangthai(rs.getString("Trangthai"));
                dskm.add(a);

            } 
            
            return dskm;
        } catch (SQLException ex) {
            return null;
        } finally {
            db.closeConnection();
        }
    }
    public ArrayList<Model_ChiTietKM> getDanhSachChiTietKM_DAO() {

        ArrayList<Model_ChiTietKM> dsctkm = new ArrayList<Model_ChiTietKM>();
        db.setupConnection();
        try {
            PreparedStatement stm = db.getConnection().prepareStatement("select chitietkhuyenmai.Machitietkhuyenmai,chitietkhuyenmai.Masp,sanpham.Tensp,chitietkhuyenmai.Makm,chitietkhuyenmai.TrangThai from chitietkhuyenmai,sanpham where sanpham.Masp=chitietkhuyenmai.Masp");
            rs = stm.executeQuery();
            while (rs.next()) {
                Model_ChiTietKM a = new Model_ChiTietKM();
                a.setMachitietkhuyenmai(rs.getInt("Machitietkhuyenmai"));
                a.setMaSP(rs.getInt("MaSP"));
                a.setTenSP(rs.getString("Tensp"));
                a.setMaKM(rs.getInt("Makm"));
                a.setTrangThai(rs.getString("TrangThai"));
//               
                
                dsctkm.add(a);

            } 
            
            return dsctkm;
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            db.closeConnection();
        }
        return null;
    }
    
       public ArrayList getALLKhuyenMai() {
        ArrayList result = new ArrayList<>();
        db.setupConnection();
        try {
            PreparedStatement stm = db.getConnection().prepareStatement("select Makm  from khuyenmai where khuyenmai.Trangthai='T' ");
            rs = db.sqlQry(stm);
            if (rs != null) {
                while (rs.next()) {
                    result.add(rs.getString("Makm"));
                }
            }
        } catch (SQLException ex) {
         System.out.println("Lỗi"+ex);
        } finally {
            db.closeConnection();
        }
        return result;
    }
       
       
      public boolean insertKhuyenMai(Model_KhuyenMai KhuyenMai) {
		boolean isSuccess = false;
                 db.setupConnection();
		String sqlString = "insert into khuyenmai(Tenkm,Ptkm,Trangthai) values (?, ?, ? )";
		try {
			preparedStatement = db.getConnection().prepareStatement(sqlString);
			preparedStatement.setString(1, KhuyenMai.getTenkm());
                        preparedStatement.setFloat(2, KhuyenMai.getPhantramkm());
                        preparedStatement.setString(3, KhuyenMai.getTrangthai());
                        
                        
			int n = preparedStatement.executeUpdate();
                        if (n != 0) {
                     JOptionPane.showMessageDialog(null, "Thêm dữ liệu thành công", "Thông báo",
                        JOptionPane.INFORMATION_MESSAGE);
			isSuccess = true;
                        }
		}
		catch(SQLException ex) {
			 System.out.println(ex);
                        JOptionPane.showMessageDialog(null, "Thêm dữ liệu thất bại", "Lỗi", JOptionPane.ERROR_MESSAGE);
		}
		finally {
			try {
                                   db.closeConnection();
				preparedStatement.close();
			}
			catch(SQLException ex) {
				ex.printStackTrace();
			}
		}

		return isSuccess;
                
	}
       public boolean deleteKhuyenMai(int Makm) {
		boolean isSuccess = false;
		db.setupConnection();
		String sqlString = "delete from khuyenmai where Makm=?";

		try {
			preparedStatement = db.getConnection().prepareStatement(sqlString);

			preparedStatement.setInt(1, Makm);

                        int n = preparedStatement.executeUpdate();
                        if (n != 0) {
                        JOptionPane.showMessageDialog(null, "Xóa dữ liệu thành công", "Thông báo",
                        JOptionPane.INFORMATION_MESSAGE);
			isSuccess = true;
                        }
		}
		catch(SQLException ex) {
			 System.out.println(ex);
                        JOptionPane.showMessageDialog(null, "Xóa dữ liệu thất bại", "Lỗi", JOptionPane.ERROR_MESSAGE);
		}
		finally {
			try {
				db.closeConnection();
				preparedStatement.close();
			}
			catch(SQLException ex) {
				ex.printStackTrace();
			}
		}

		return isSuccess;
	}
       
       public boolean updatekm(Model_KhuyenMai KhuyenMai){
            boolean isSuccess = false;
            db.setupConnection();
            String sqlString = "update khuyenmai set Tenkm = ?, Ptkm = ?,TrangThai=? where Makm = ?";
            
            try {
               preparedStatement = db.getConnection().prepareStatement(sqlString);
               preparedStatement.setString(1,KhuyenMai.getTenkm());
               preparedStatement.setFloat(2,KhuyenMai.getPhantramkm());
               preparedStatement.setString(3,KhuyenMai.getTrangthai());
               preparedStatement.setInt(4, KhuyenMai.getMakm());
                
               int n = preparedStatement.executeUpdate();
                        if (n != 0) {
                     JOptionPane.showMessageDialog(null, "Update dữ liệu thành công", "Thông báo",
                        JOptionPane.INFORMATION_MESSAGE);
			isSuccess = true;
                        }
		}
		catch(SQLException ex) {
			 System.out.println(ex);
                        JOptionPane.showMessageDialog(null, "Update dữ liệu thất bại", "Lỗi", JOptionPane.ERROR_MESSAGE);
		}
		finally {
			try {
                                   db.closeConnection();
				preparedStatement.close();
			}
			catch(SQLException ex) {
				ex.printStackTrace();
			}
		}

		return isSuccess;
       }
       
       
       public boolean InsertCTKM(Model_ChiTietKM ChiTietKM){
           boolean isSuccess = false;
           db.setupConnection();
           String sqlString = "insert into chitietkhuyenmai(Masp,Makm,TrangThai) values (?, ?, ?)";
           try {
               preparedStatement = db.getConnection().prepareStatement(sqlString);
               preparedStatement.setInt(1,ChiTietKM.getMaSP());
               preparedStatement.setInt(2,ChiTietKM.getMaKM());
               preparedStatement.setString(3,ChiTietKM.getTrangThai());
               
               int n = preparedStatement.executeUpdate();
               if( n!= 0 ){
                   JOptionPane.showMessageDialog(null, "Thêm dữ liệu thành công", "Thông báo",
                        JOptionPane.INFORMATION_MESSAGE);
			isSuccess = true;
               }
           } catch (SQLException ex) {
               System.out.println(ex);
             JOptionPane.showMessageDialog(null, "Thêm dữ liệu thất bại", "Lỗi", JOptionPane.ERROR_MESSAGE);

           } finally {
               try {
                   db.closeConnection();
                   preparedStatement.close();
               } catch (SQLException ex) {
                   ex.printStackTrace();
               }
           }
           return  isSuccess; 
       }
       
       public boolean deleteChiTietKM(int MaChiTietKM){
          boolean isSuccess = false;
		db.setupConnection();
		String sqlString = "delete from chitietkhuyenmai where Machitietkhuyenmai=?";

		try {
			preparedStatement = db.getConnection().prepareStatement(sqlString);

			preparedStatement.setInt(1, MaChiTietKM);

                        int n = preparedStatement.executeUpdate();
                        if (n != 0) {
                        JOptionPane.showMessageDialog(null, "Xóa dữ liệu thành công", "Thông báo",
                        JOptionPane.INFORMATION_MESSAGE);
			isSuccess = true;
                        }
		}
		catch(SQLException ex) {
			 System.out.println(ex);
                        JOptionPane.showMessageDialog(null, "Xóa dữ liệu thất bại", "Lỗi", JOptionPane.ERROR_MESSAGE);
		}
		finally {
			try {
				db.closeConnection();
				preparedStatement.close();
			}
			catch(SQLException ex) {
				ex.printStackTrace();
			}
		}
       
		return isSuccess;    
	}
       
       public boolean updateChiTietKM(Model_ChiTietKM ChiTietKM){
          boolean isSuccess = false;
            db.setupConnection();
            String sqlString = "update chitietkhuyenmai set Masp = ?, Makm = ?,TrangThai=? where Machitietkhuyenmai = ?";
            
            try {
               preparedStatement = db.getConnection().prepareStatement(sqlString);
               preparedStatement.setInt(1,ChiTietKM.getMaSP());
               preparedStatement.setInt(2,ChiTietKM.getMaKM());
               preparedStatement.setString(3,ChiTietKM.getTrangThai());
               preparedStatement.setInt(4, ChiTietKM.getMachitietkhuyenmai());
                
               int n = preparedStatement.executeUpdate();
                        if (n != 0) {
                     JOptionPane.showMessageDialog(null, "Update dữ liệu thành công", "Thông báo",
                        JOptionPane.INFORMATION_MESSAGE);
			isSuccess = true;
                        }
		}
		catch(SQLException ex) {
			 System.out.println(ex);
                        JOptionPane.showMessageDialog(null, "Update dữ liệu thất bại", "Lỗi", JOptionPane.ERROR_MESSAGE);
		}
		finally {
			try {
                                   db.closeConnection();
				preparedStatement.close();
			}
			catch(SQLException ex) {
				ex.printStackTrace();
			}
		}

		return isSuccess;
       }
}
