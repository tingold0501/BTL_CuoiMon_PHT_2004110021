package BTL_CuoiMon;

import java.util.ArrayList;
import java.util.List;

public class DanhSachHangHoa {
    private List<HangHoa> lHoas = new ArrayList<>();
    private int sLHHDienMay;
    private int sLHHSanhSu;
    private int sLHHThucPham;
    public DanhSachHangHoa(){

    }
    public DanhSachHangHoa(int sLHHDienMay, int sLHHSanhSu, int sLHHThucPham) {
        this.sLHHDienMay = sLHHDienMay;
        this.sLHHSanhSu = sLHHSanhSu;
        this.sLHHThucPham = sLHHThucPham;
    }
    public int getsLHHDienMay() {
        return sLHHDienMay;
    }
    public void setsLHHDienMay(int sLHHDienMay) {
        this.sLHHDienMay = sLHHDienMay;
    }
    public int getsLHHSanhSu() {
        return sLHHSanhSu;
    }
    public void setsLHHSanhSu(int sLHHSanhSu) {
        this.sLHHSanhSu = sLHHSanhSu;
    }
    public int getsLHHThucPham() {
        return sLHHThucPham;
    }
    public void setsLHHThucPham(int sLHHThucPham) {
        this.sLHHThucPham = sLHHThucPham;
    }
    
}
