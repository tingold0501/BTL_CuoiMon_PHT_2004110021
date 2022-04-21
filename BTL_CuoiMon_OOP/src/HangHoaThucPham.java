

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
        if(ngaySXH.before(this.ngayHHH)){
            this.ngaySXH = ngaySXH;
        }
        else{
            System.out.println("Ngày Sản Xuất Phải Trước Ngày Hết Hạn!!!");
        }
    }
    public Date getNgayHHH() {
        return ngayHHH;
    }
    public void setNgayHHH(Date ngayHHH) {
        if(ngayHHH.after(this.ngaySXH)){
            this.ngayHHH = ngayHHH;
        }
        else{
            System.out.println("Ngày Hết Hạn Phải Sau Ngày Sản Xuất");
        }
    }
    public String getNhaCC() {
        return nhaCC;
    }
    public void setNhaCC(String nhaCC) {
        if(nhaCC != null && nhaCC != ""){
            this.nhaCC = nhaCC;
        }
        else{
            System.out.println("Nhà Cung Cấp Không Được Rỗng");
        }
    }
    public HangHoaThucPham(Date ngaySXH, Date ngayHHH, String nhaCC) {
        this.ngaySXH = ngaySXH;
        this.ngayHHH = ngayHHH;
        this.nhaCC = nhaCC;
    }
    public HangHoaThucPham(int sLTonKhoH, String tenH, double donGiaH, Date ngaySXH, Date ngayHHH, String nhaCC) {
        super(sLTonKhoH, tenH, donGiaH);
        this.ngaySXH = ngaySXH;
        this.ngayHHH = ngayHHH;
        this.nhaCC = nhaCC;
    }
    @Override
    public double VAT() {
        double thueVat = 0;
        thueVat = this.getDonGiaH() * 0.05;
        return thueVat;
    }
    @Override
    public String toString() {
        return super.toString()+"====================Thông Tin Hàng Hoá Thực Phẩm\n" + "Ngày Hết Hạn = " + this.getNgayHHH() + "Ngày Sản Xuất = " + this.getNgaySXH() + " Nhà Cung Cấp = " + this.getNhaCC()+ "Thuế VAT Thực Phẩm = " + this.VAT();
    }
   
}
