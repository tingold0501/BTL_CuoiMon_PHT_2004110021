package BTL_CuoiMon;

import java.util.ArrayList;
import java.util.List;

public class DanhSachHangHoa {
    private List<HangHoa> lHoas = new ArrayList<>();
    private int sLHHDienMay;
    private int sLHHSanhSu;
    private int sLHHThucPham;

    public DanhSachHangHoa() {

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

    public void xoaHangHoa() {
        // Xử lý hàm xoá hàng hoá
    }

    public void suaHangHoa() {
        // Xử lý hàm sửa hàng hoá
    }

    public void thongKeHangHoa() {
        // Xử lý hàm thống kê hàng hoá
    }

    public void baoCaoHangHoa() {
        // Xử lý hàm báo cáo hàng hoá
    }

    public void sapXepHangHoa() {
        // Xử lý hàm sắp xếp hàng hoá
    }
    public void themHangHoa(HangHoa hangHoa){
        lHoas.add(hangHoa);
    }
    public void themHangHoas(HangHoa hangHoa){
        while(true){
            this.themHangHoa(hangHoa);
        }
    }
    public void hienThiHangHoa(){
        for (HangHoa hangHoa : lHoas) {
            System.out.println(hangHoa);
        }
    }
}
