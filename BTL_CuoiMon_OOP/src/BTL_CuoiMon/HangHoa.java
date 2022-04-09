package BTL_CuoiMon;

public abstract class HangHoa {
    private int maH, sLTonKhoH;
    private String tenH;
    private double donGiaH;
    private int autoMaH = 1;
    public HangHoa(){

    }
    public int getMaH() {
        return maH;
    }
    private void setMaH(int maH) {
        this.maH = maH;
    }
    public int getsLTonKhoH() {
        return sLTonKhoH;
    }
    private void setsLTonKhoH(int sLTonKhoH) {
        this.sLTonKhoH = sLTonKhoH;
    }
    public String getTenH() {
        return tenH;
    }
    private void setTenH(String tenH) {
        this.tenH = tenH;
    }
    public double getDonGiaH() {
        return donGiaH;
    }
    private void setDonGiaH(double donGiaH) {
        this.donGiaH = donGiaH;
    }
    public HangHoa(int sLTonKhoH, String tenH, double donGiaH) {
        this.maH = autoMaH++;
        this.sLTonKhoH = sLTonKhoH;
        this.tenH = tenH;
        this.donGiaH = donGiaH;
    }
    @Override
    public String toString() {
        return "Quản Lý Hàng Hoá [Đơn Giá Hàng Hoá = " + donGiaH + 
        ", Mã Hàng Hoá = " + maH + 
        ", Số Lượng Tồn Kho = " + sLTonKhoH + 
        ", Tên Hàng Hoá = " + tenH + "]";
    }
}
