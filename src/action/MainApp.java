package action;

import model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class MainApp {
    static Pengguna autentikasi = new Pengguna();

    public static void main(String[] args) {
        // Register
        Pengguna pengguna = new Pengguna();
        register(pengguna);

        // Login
        autentikasi = login("Rafa", "xxxxxxxx");

        // Rekomendasi
        System.out.println(tampilkanRekomendasi(autentikasi.getId_pengguna()));

        // Pencarian
        System.out.println(pencarian("Sate Ayam"));

        // Daftar Menu
        System.out.println(tampilkanDaftarMenu());

        // Pemesanan
        Pemesanan order = new Pemesanan();
        pemesanan(order);

        // Pembayaran
        Pembayaran bayar = new Pembayaran();
        bayar.setId_pemesanan(order.getId_pemesanan());
        pembayaran(bayar);

        // Riwayat
        System.out.println(riwayat(autentikasi.getId_pengguna()));

        // Notifikasi
        System.out.println(lihatNotifikasi(autentikasi.getId_pengguna()));

        // Edit Profile
        editProfile(autentikasi);

        // Customer Service
        CustomerService cs = new CustomerService();
        tambahCustomerService(cs);
    }

    public static Pengguna login(String email, String password) {
        Pengguna auth = null;
        try (Connection conn = ConnectionManager.getConnection(); PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM Pengguna WHERE email_pengguna = ? AND password = ?")) {
            pstmt.setString(1, email);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                auth = new Pengguna();
                auth.setId_pengguna(rs.getString("id_pengguna"));
                auth.setNama_penguna(rs.getString("nama_penguna"));
                auth.setTgl_lahir_pengguna(rs.getDate("tgl_lahir_pengguna"));
                auth.setJenis_kelamin_pengguna(rs.getString("jenis_kelamin_pengguna"));
                auth.setNmr_telepon_pengguna(rs.getString("nmr_telepon_pengguna"));
                auth.setEmail_pengguna(rs.getString("email_pengguna"));
                auth.setAlamat_pengguna(rs.getString("alamat_pengguna"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return auth;
    }

    public static void register(Pengguna newUser) {
        try (Connection conn = ConnectionManager.getConnection(); PreparedStatement pstmt = conn.prepareStatement("INSERT INTO Pengguna (id_pengguna, nama_penguna, tgl_lahir_pengguna, jenis_kelamin_pengguna, nmr_telepon_pengguna, email_pengguna, alamat_pengguna) VALUES (?, ?, ?, ?, ?, ?, ?)")) {
            pstmt.setString(1, newUser.getId_pengguna());
            pstmt.setString(2, newUser.getNama_penguna());
            pstmt.setDate(3, new java.sql.Date(newUser.getTgl_lahir_pengguna().getTime()));
            pstmt.setString(4, newUser.getJenis_kelamin_pengguna());
            pstmt.setString(5, newUser.getNmr_telepon_pengguna());
            pstmt.setString(6, newUser.getEmail_pengguna());
            pstmt.setString(7, newUser.getAlamat_pengguna());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static List<Rekomendasi> tampilkanRekomendasi(String id_pengguna) {
        List<Rekomendasi> recommendations = new ArrayList<>();
        try (Connection conn = ConnectionManager.getConnection(); PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM Rekomendasi WHERE id_pengguna = ?")) {
            pstmt.setString(1, id_pengguna);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Rekomendasi rec = new Rekomendasi();
                rec.setId_rekomendasi(rs.getString("id_rekomendasi"));
                rec.setId_pengguna(rs.getString("id_pengguna"));
                rec.setPreferensi_makanan(rs.getString("preferensi_makanan"));
                rec.setTgl_pemesanan(rs.getDate("tgl_pemesanan"));
                rec.setNama_katering(rs.getString("nama_katering"));
                recommendations.add(rec);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return recommendations;
    }

    public static List<Pencarian> pencarian(String kataKunci) {
        List<Pencarian> hasilPencarian = new ArrayList<>();
        try (Connection conn = ConnectionManager.getConnection(); PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM Pencarian WHERE kata_kunci LIKE ? OR makanan LIKE ? OR minuman LIKE ?")) {
            pstmt.setString(1, STR."%\{kataKunci}%");
            pstmt.setString(2, STR."%\{kataKunci}%");
            pstmt.setString(3, STR."%\{kataKunci}%");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Pencarian item = new Pencarian();
                item.setId_pencarian(rs.getInt("id_pencarian"));
                item.setKata_kunci(rs.getString("kata_kunci"));
                item.setMakanan(rs.getString("makanan"));
                item.setMinuman(rs.getString("minuman"));
                hasilPencarian.add(item);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return hasilPencarian;
    }

    public static List<Item> tampilkanDaftarMenu() {
        List<Item> daftarItem = new ArrayList<>();
        try (Connection conn = ConnectionManager.getConnection(); PreparedStatement pstmt = conn.prepareStatement("SELECT dm.id_daftar_menu, dm.id_item, i.nama_item, i.deskripsi_item, i.harga_item, i.kategori_item, i.foto_item, i.status_item, i.rating_item \" + \"FROM Daftar_Menu dm \" + \"JOIN Item i ON dm.id_item = i.id_item")) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Item item = new Item();
                item.setId_item(rs.getInt("id_item"));
                item.setNama_item(rs.getString("nama_item"));
                item.setDeskripsi_item(rs.getString("deskripsi_item"));
                item.setHarga_item(rs.getInt("harga_item"));
                item.setKategori_item(rs.getString("kategori_item"));
                item.setFoto_item(rs.getString("foto_item"));
                item.setStatus_item(rs.getString("status_item"));
                item.setRating_item(rs.getFloat("rating_item"));
                daftarItem.add(item);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return daftarItem;
    }

    public static void pemesanan(Pemesanan pemesanan) {
        try (Connection conn = ConnectionManager.getConnection(); PreparedStatement pstmt = conn.prepareStatement("INSERT INTO Pemesanan (id_pemesanan, id_pengguna, tgl_pemesanan, jumlah_pemesanan, status_pemesanan) VALUES (?, ?, ?, ?, ?)")) {
            pstmt.setString(1, pemesanan.getId_pemesanan());
            pstmt.setString(2, pemesanan.getId_pengguna());
            pstmt.setDate(3, new java.sql.Date(pemesanan.getTgl_pemesanan().getTime()));
            pstmt.setInt(4, pemesanan.getJumlah_pemesanan());
            pstmt.setString(5, pemesanan.getStatus_pemesanan());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void pembayaran(Pembayaran pembayaran) {
        try (Connection conn = ConnectionManager.getConnection(); PreparedStatement pstmt = conn.prepareStatement("INSERT INTO Pembayaran (id_pembayaran, id_pengguna, id_pemesanan, metode_pembayaran) VALUES (?, ?, ?, ?)")) {
            pstmt.setString(1, pembayaran.getId_pembayaran());
            pstmt.setString(2, pembayaran.getId_pengguna());
            pstmt.setString(3, pembayaran.getId_pemesanan());
            pstmt.setString(4, pembayaran.getMetode_pembayaran());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static List<Pemesanan> riwayat(String id_pengguna) {
        List<Pemesanan> orders = new ArrayList<>();
        try (Connection conn = ConnectionManager.getConnection(); PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM Pemesanan WHERE id_pengguna = ?")) {
            pstmt.setString(1, id_pengguna);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Pemesanan pemesanan = new Pemesanan();
                pemesanan.setId_pemesanan(rs.getString("id_pemesanan"));
                pemesanan.setId_pengguna(rs.getString("id_pengguna"));
                pemesanan.setTgl_pemesanan(rs.getDate("tgl_pemesanan"));
                pemesanan.setJumlah_pemesanan(rs.getInt("jumlah_pemesanan"));
                pemesanan.setStatus_pemesanan(rs.getString("status_pemesanan"));
                orders.add(pemesanan);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return orders;
    }

    public static List<Notifikasi> lihatNotifikasi(String id_pengguna) {
        List<Notifikasi> notifikasiList = new ArrayList<>();
        try (Connection conn = ConnectionManager.getConnection(); PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM Notifikasi WHERE id_pengguna = ?")) {
            pstmt.setString(1, id_pengguna);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Notifikasi notif = new Notifikasi();
                notif.setId_notifikasi(rs.getInt("id_notifikasi"));
                notif.setId_pengguna(rs.getString("id_pengguna"));
                notif.setIsi_notifikasi(rs.getString("isi_notifikasi"));
                notif.setWaktu_pengiriman(rs.getTimestamp("waktu_pengiriman"));
                notifikasiList.add(notif);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return notifikasiList;
    }

    public static void editProfile(Pengguna pengguna) {
        try (Connection conn = ConnectionManager.getConnection(); PreparedStatement pstmt = conn.prepareStatement("UPDATE Pengguna SET nama_penguna=?, tgl_lahir_pengguna=?, jenis_kelamin_pengguna=?, nmr_telepon_pengguna=?, email_pengguna=?, alamat_pengguna=? WHERE id_pengguna=?")) {
            pstmt.setString(1, pengguna.getNama_penguna());
            pstmt.setDate(2, new java.sql.Date(pengguna.getTgl_lahir_pengguna().getTime()));
            pstmt.setString(3, pengguna.getJenis_kelamin_pengguna());
            pstmt.setString(4, pengguna.getNmr_telepon_pengguna());
            pstmt.setString(5, pengguna.getEmail_pengguna());
            pstmt.setString(6, pengguna.getAlamat_pengguna());
            pstmt.setString(7, pengguna.getId_pengguna());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void tambahCustomerService(CustomerService cs) {
        try (Connection conn = ConnectionManager.getConnection(); PreparedStatement pstmt = conn.prepareStatement("INSERT INTO Customer_Service (id_customer_service, nama_customer_service, jeniskelamin_customer_service) VALUES (?, ?, ?)")) {
            pstmt.setInt(1, cs.getId_customer_service());
            pstmt.setString(2, cs.getNama_customer_service());
            pstmt.setString(3, cs.getJeniskelamin_customer_service());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


}
