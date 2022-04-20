
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DanhSachHangHoa implements InterfaceHangHoa {
    private List<HangHoa> lHoas = new ArrayList<>();
    private int sLHHDienMay;
    private int sLHHSanhSu;
    private int sLHHThucPham;
    private String yn;
    private Scanner sc = new Scanner(System.in);

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

    private void xoaHangHoa(HangHoa hangHoa) {
        this.lHoas.remove(hangHoa);
    }

    private void suaHangHoa(int index, HangHoa hangHoa) {
        this.lHoas.set(index, hangHoa);
    }
    public void suaHH(int idSua){
       
    }
    private int timViTri(HangHoa hangHoa){
        int viTri = -1;
        viTri = this.lHoas.indexOf(viTri);
        return viTri;
    }
    public HangHoa timHangHoaTheoMa( int maHH){
        HangHoa hangHoa1 = null;
        for (HangHoa hangHoa : lHoas) {
            if(hangHoa.getMaH() == maHH){
                hangHoa1 = hangHoa;
            }
            else{
                System.out.println("Mã Không Tồn Tại");
            }
        }
        return hangHoa1;
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

    public void themHangHoa(HangHoa hangHoa) {
        lHoas.add(hangHoa);
    }

    public void hienThiHangHoa() {
        for (HangHoa hangHoa : lHoas) {
            System.out.println(hangHoa);
        }
    }

    @Override
    public void showHangHoa() {

    }

}
