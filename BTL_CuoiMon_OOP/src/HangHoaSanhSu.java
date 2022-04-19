

import java.util.Date;

public class HangHoaSanhSu extends HangHoa {
    private String nhaSX;
    private Date ngayNhapKho;
    public HangHoaSanhSu(){
        
    }
    public String getNhaSX() {
        return nhaSX;
    }
    public void setNhaSX(String nhaSX) {
        this.nhaSX = nhaSX;
    }
    public Date getNgayNhapKho() {
        return ngayNhapKho;
    }
    public void setNgayNhapKho(Date ngayNhapKho) {
        if(ngayNhapKho != null){
            this.ngayNhapKho = ngayNhapKho;
        }
        else{
            System.out.println("Ngày Không Được Rỗng");
        }
    }
    public HangHoaSanhSu(String nhaSX, Date ngayNhapKho) {
        this.nhaSX = nhaSX;
        this.ngayNhapKho = ngayNhapKho;
    }
    public HangHoaSanhSu(int sLTonKhoH, String tenH, double donGiaH, String nhaSX, Date ngayNhapKho) {
        super(sLTonKhoH, tenH, donGiaH);
        this.nhaSX = nhaSX;
        this.ngayNhapKho = ngayNhapKho;
    }
    @Override
    public String toString() {
        return super.toString()+ "=========================Thông Tin Hàng Hoá Sành Sứ\n"+"Nhà Sản Xuất = " + this.getNhaSX() + "Ngày Sản Xuất = " + this.getNgayNhapKho();
    }
   
}
