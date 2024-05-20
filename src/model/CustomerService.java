package model;

public class CustomerService {
    private int id_customer_service;
    private String nama_customer_service;
    private String jeniskelamin_customer_service;

    public int getId_customer_service() {
        return id_customer_service;
    }

    public void setId_customer_service(int id_customer_service) {
        this.id_customer_service = id_customer_service;
    }

    public String getNama_customer_service() {
        return nama_customer_service;
    }

    public void setNama_customer_service(String nama_customer_service) {
        this.nama_customer_service = nama_customer_service;
    }

    public String getJeniskelamin_customer_service() {
        return jeniskelamin_customer_service;
    }

    public void setJeniskelamin_customer_service(String jeniskelamin_customer_service) {
        this.jeniskelamin_customer_service = jeniskelamin_customer_service;
    }
}
