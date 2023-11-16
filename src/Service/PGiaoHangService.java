package Service;

import Model.PGiaoHang;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class PGiaoHangService {

    private ArrayList<PGiaoHang> listGH;
    Connection conn = DBConect.getJDBCConnection();

    public PGiaoHangService() {
        this.listGH = new ArrayList<>();
    }

    public ArrayList<PGiaoHang> getAll() {
        this.listGH = new ArrayList<>();
        try {
            String sql = "select id, user_id, address_id, into_money, total_cost, created_at, updated_at, delivery_date, voucher_id, status from db_levents.bill";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                this.listGH.add(new PGiaoHang(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getDouble(4),
                        rs.getDouble(5),
                        rs.getInt(3),
                        rs.getDate(6),
                        rs.getDate(7),
                        rs.getDate(8),
                        rs.getInt(9),
                        rs.getString(10)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listGH;
    }

    public ArrayList<PGiaoHang> Search(int id) {
        this.listGH = new ArrayList<>();
        try {
            String sql = "select id, user_id, address_id, into_money, total_cost, created_at, updated_at, delivery_date, voucher_id, status from db_levents.bill where id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setObject(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                this.listGH.add(new PGiaoHang(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getDouble(4),
                        rs.getDouble(5),
                        rs.getInt(3),
                        rs.getDate(6),
                        rs.getDate(7),
                        rs.getDate(8),
                        rs.getInt(9),
                        rs.getString(10)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listGH;
    }

}
