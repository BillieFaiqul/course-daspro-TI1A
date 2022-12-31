/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author M. ROM DONI
 */
public class Transaksi {
    private int id_transaksi;
    private Admin admin = new Admin();
    private Pelanggan pelanggan = new Pelanggan();
    private Kamar kamar = new Kamar();
    private Menu menu = new Menu();
    private int lamaMenginap;
    private String tgl_transaksi;
    private int ttl_harga;

    public Transaksi() {
    }

    public Transaksi(Admin admin, Pelanggan pelanggan, Kamar kamar,
            Menu menu, int lamaMenginap, String tgl_transaksi, int ttl_harga) {
        this.admin = admin;
        this.pelanggan = pelanggan;
        this.kamar = kamar;
        this.menu = menu;
        this.lamaMenginap = lamaMenginap;
        this.tgl_transaksi = tgl_transaksi;
        this.ttl_harga = ttl_harga;
    }

    public int getId_transaksi() {
        return id_transaksi;
    }

    public void setId_transaksi(int id_transaksi) {
        this.id_transaksi = id_transaksi;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public Pelanggan getPelanggan() {
        return pelanggan;
    }

    public void setPelanggan(Pelanggan pelanggan) {
        this.pelanggan = pelanggan;
    }

    public Kamar getKamar() {
        return kamar;
    }

    public void setKamar(Kamar kamar) {
        this.kamar = kamar;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }
    public int getLamaMenginap() {
        return lamaMenginap;
    }

    public void setLamaMenginap(int lamaMenginap) {
        this.lamaMenginap = lamaMenginap;
    }
    public String getTgl_transaksi() {
        return tgl_transaksi;
    }

    public void setTgl_transaksi(String tgl_transaksi) {
        this.tgl_transaksi = tgl_transaksi;
    }

    public int getTtl_harga() {
        return ttl_harga;
    }

    public void setTtl_harga(int ttl_harga) {
        this.ttl_harga = ttl_harga;
    }


    
    public Transaksi getById(int id) {
        Transaksi tsk = new Transaksi();
        ResultSet rs = DBHelper.selectQuery("SELECT "
                                        + "     t.id_transaksi AS id_transaksi, "
                                        + "     t.lamaMenginap AS lamaMenginap, "
                                        + "     t.tgl_transaksi AS tgl_transaksi, "
                                        + "     t.ttl_harga AS ttl_harga, "
                                        + "     a.id_admin AS id_admin, "
                                        + "     a.username AS username, "
                                        + "     a.password AS password, "
                                        + "     p.id_pelanggan AS id_pelanggan, "
                                        + "     p.nama AS nama, "
                                        + "     p.no_telepon AS no_telepon, "   
                                        + "     p.j_kelamin AS j_kelamin, "
                                        + "     k.id_kamar AS id_kamar, "
                                        + "     k.no_kamar AS no_kamar, "
                                        + "     k.lantai_kamar AS lantai_kamar, "
                                        + "     k.jenis_kamar AS jenis_kamar, "
                                        + "     k.harga AS harga, "
                                        + "     k.ditempati AS ditempati, "
                                        + "     m.id_menu AS id_menu, "
                                        + "     m.nama_menu AS nama_menu, "
                                        + "     m.harga AS harga, "
                                        + "     FROM transaksi t "
                                        + "     LEFT JOIN admin a ON t.id_admin = a.id_admin "
                                        + "     LEFT JOIN pelanggan p ON t.id_pelanggan = p.id_pelanggan "
                                        + "     LEFT JOIN kamar k ON t.id_kamar = k.id_kamar "
                                        + "     LEFT JOIN menu m ON t.id_menu = m.id_menu "
                                        + "     WHERE t.id_transaksi = '" + id + "'");
        try
        {
            while(rs.next()) {
                tsk = new Transaksi();
                tsk.setId_transaksi(rs.getInt("id_transaksi"));
                tsk.getAdmin().setId(rs.getInt("id_admin"));
                tsk.getAdmin().setUsername(rs.getString("username"));
                tsk.getAdmin().setPassword(rs.getString("password"));
                tsk.getPelanggan().setId_pelanggan(rs.getInt("id_pelanggan"));
                tsk.getPelanggan().setNama(rs.getString("nama"));
                tsk.getPelanggan().setNo_telepon(rs.getString("no_telepon"));
                tsk.getPelanggan().setJ_kelamin(rs.getString("j_kelamin"));
                tsk.getKamar().setId_kamar(rs.getInt("id_kamar"));
                tsk.getKamar().setNo_kamar(rs.getString("no_kamar"));
                tsk.getKamar().setLantai_kamar(rs.getInt("lantai_kamar"));
                tsk.getKamar().setJenis_kamar(rs.getString("jenis_kamar"));
                tsk.getKamar().setHarga(rs.getInt("harga"));
                tsk.getKamar().setDitempati(rs.getBoolean("ditempati"));
                tsk.getMenu().setId_menu(rs.getInt("id_menu"));
                tsk.getMenu().setNama_menu(rs.getString("nama_menu"));
                tsk.getMenu().setHarga(rs.getInt("harga"));
                tsk.setLamaMenginap(rs.getInt("lamaMenginap"));
                tsk.setTgl_transaksi(rs.getString("tgl_transaksi"));
                tsk.setTtl_harga(rs.getInt("ttl_harga"));
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        
        return tsk;
    }
    
    public ArrayList<Transaksi> getAll() {
        ArrayList<Transaksi> ListTransaksi = new ArrayList();
        ResultSet rs = DBHelper.selectQuery("SELECT "
                                        + "     t.id_transaksi AS id_transaksi, "
                                        + "     t.lamaMenginap AS lamaMenginap, "
                                        + "     t.tgl_transaksi AS tgl_transaksi, "
                                        + "     t.ttl_harga AS ttl_harga, "
                                        + "     a.id_admin AS id_admin, "
                                        + "     a.username AS username, "
                                        + "     a.password AS password, "
                                        + "     p.id_pelanggan AS id_pelanggan, "
                                        + "     p.nama AS nama, "
                                        + "     p.no_telepon AS no_telepon, "   
                                        + "     p.j_kelamin AS j_kelamin, "
                                        + "     k.id_kamar AS id_kamar, "
                                        + "     k.no_kamar AS no_kamar, "
                                        + "     k.lantai_kamar AS lantai_kamar, "
                                        + "     k.jenis_kamar AS jenis_kamar, "
                                        + "     k.harga AS harga, "
                                        + "     k.ditempati AS ditempati, "
                                        + "     m.id_menu AS id_menu, "
                                        + "     m.nama_menu AS nama_menu, "
                                        + "     m.harga AS harga, "
                                        + "     FROM transaksi t "
                                        + "     LEFT JOIN admin a ON t.id_admin = a.id_admin "
                                        + "     LEFT JOIN pelanggan p ON t.id_pelanggan = p.id_pelanggan "
                                        + "     LEFT JOIN kamar k ON t.id_kamar = k.id_kamar "
                                        + "     LEFT JOIN menu m ON t.id_menu = m.id_menu ");
        
    try
        {
            while(rs.next()) {
                System.out.println(rs.getString("id_admin"));
                Transaksi tsk = new Transaksi();
                tsk = new Transaksi();
                tsk.setId_transaksi(rs.getInt("id_transaksi"));
                tsk.getAdmin().setId(rs.getInt("id_admin"));
                tsk.getAdmin().setUsername(rs.getString("username"));
                tsk.getAdmin().setPassword(rs.getString("password"));
                tsk.getPelanggan().setId_pelanggan(rs.getInt("id_pelanggan"));
                tsk.getPelanggan().setNama(rs.getString("nama"));
                tsk.getPelanggan().setNo_telepon(rs.getString("no_telepon"));
                tsk.getPelanggan().setJ_kelamin(rs.getString("j_kelamin"));
                tsk.getKamar().setId_kamar(rs.getInt("id_kamar"));
                tsk.getKamar().setNo_kamar(rs.getString("no_kamar"));
                tsk.getKamar().setLantai_kamar(rs.getInt("lantai_kamar"));
                tsk.getKamar().setJenis_kamar(rs.getString("jenis_kamar"));
                tsk.getKamar().setHarga(rs.getInt("harga"));
                tsk.getKamar().setDitempati(rs.getBoolean("ditempati"));
                tsk.getMenu().setId_menu(rs.getInt("id_menu"));
                tsk.getMenu().setNama_menu(rs.getString("nama_menu"));
                tsk.getMenu().setHarga(rs.getInt("harga"));
                tsk.setLamaMenginap(rs.getInt("lamaMenginap"));
                tsk.setTgl_transaksi(rs.getString("tgl_transaksi"));
                tsk.setTtl_harga(rs.getInt("ttl_harga"));
                
                ListTransaksi.add(tsk);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        
        return ListTransaksi;
    }
    
    public void save() {
        if(getById(id_transaksi).getId_transaksi() == 0) {
            String SQL = "INSERT INTO transaksi (id_admin, id_pelanggan, id_kamar, id_menu, tgl_transaksi, ttl_harga) VALUES ("
                    + "     '" + this.getAdmin().getId() + "', "
                    + "     '" + this.getPelanggan().getId_pelanggan()+ "', "
                    + "     '" + this.getKamar().getId_kamar() + "', "
                    + "     '" + this.getMenu().getId_menu() + "', "
                    + "     '" + this.getTgl_transaksi() + "' , "
                    + "     '" + this.getTtl_harga()+ "' )";
            this.id_transaksi = DBHelper.insertQueryGetId(SQL);
        } else {
            String SQL = "UPDATE transaksi SET "
                    + "     id_admin = '" + this.getAdmin().getId()+ "', "
                    + "     id_pelanggan = '" + this.getPelanggan().getId_pelanggan()+ "', "
                    + "     id_kamar = '" + this.getKamar().getId_kamar()+ "', "
                    + "     id_menu = '" + this.getMenu().getId_menu()+ "', "
                    + "     tgl_transaksi = '" + this.getTgl_transaksi()+ "', "
                    + "     ttl_harga = '" + this.getTtl_harga()+ "' "
                    + "     WHERE id_transaksi = '" + this.id_transaksi + "'";
            DBHelper.executeQuery(SQL);
        }
    }
    
    public void delete() {
        String SQL = "DELETE FROM transaksi WHERE id_transaksi = '" + this.id_transaksi + "'";
        DBHelper.executeQuery(SQL);
    }
    
}
