package BTL_CuoiMon;

import java.util.Date;

public class HangHoaThucPham extends HangHoa {
    private Date ngaySXH, ngayHHH;
    private String nhaCC;
    public HangHoaThucPham(){
        
    }
    public Date getNgaySXH() {
        return ngaySXH;
    }
    public void setNgaySXH(Date ngaySXH) {
        this.ngaySXH = ngaySXH;
    }
    public Date getNgayHHH() {
        return ngayHHH;
    }
    public void setNgayHHH(Date ngayHHH) {
        this.ngayHHH = ngayHHH;
    }
    public String getNhaCC() {
        return nhaCC;
    }
    public void setNhaCC(String nhaCC) {
        this.nhaCC = nhaCC;
    }
    public HangHoaThucPham(Date ngaySXH, Date ngayHHH, String nhaCC) {
        this.ngaySXH = ngaySXH;
        this.ngayHHH = ngayHHH;
        this.nhaCC = nhaCC;
    }
    public HangHoaThucPham(int maH, int sLTonKhoH, String tenH, double donGiaH, Date ngaySXH, Date ngayHHH, String nhaCC) {
        super(maH, sLTonKhoH, tenH, donGiaH);
        this.ngaySXH = ngaySXH;
        this.ngayHHH = ngayHHH;
        this.nhaCC = nhaCC;
    }
    @Override
    public String toString() {
        
        return super.toString() + "Ngày Hết Hạn = " + this.getNgayHHH() + "Ngày Sản Xuất = " + this.getNgaySXH() + "Nhà Cung Cấp = " + this.getNhaCC();
    }
}
