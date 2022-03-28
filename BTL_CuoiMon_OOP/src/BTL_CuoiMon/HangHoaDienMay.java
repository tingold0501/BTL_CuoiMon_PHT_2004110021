package BTL_CuoiMon;

public class HangHoaDienMay extends HangHoa {
    private int thoiGianBH;
    private double congXuat;
    public HangHoaDienMay(){
        
    }
    public int getThoiGianBH() {
        return thoiGianBH;
    }
    public void setThoiGianBH(int thoiGianBH) {
        this.thoiGianBH = thoiGianBH;
    }
    public double getCongXuat() {
        return congXuat;
    }
    public void setCongXuat(double congXuat) {
        this.congXuat = congXuat;
    }
    public HangHoaDienMay(int thoiGianBH, double congXuat) {
        this.thoiGianBH = thoiGianBH;
        this.congXuat = congXuat;
    }
    public HangHoaDienMay(int maH, int sLTonKhoH, String tenH, double donGiaH, int thoiGianBH, double congXuat) {
        super(maH, sLTonKhoH, tenH, donGiaH);
        this.thoiGianBH = thoiGianBH;
        this.congXuat = congXuat;
    }
    @Override
    public String toString() {
        return super.toString() + "Thời Gian Bảo Hành = " + this.getThoiGianBH()+ "Công Xuất = " + this.getCongXuat();
    }
}
