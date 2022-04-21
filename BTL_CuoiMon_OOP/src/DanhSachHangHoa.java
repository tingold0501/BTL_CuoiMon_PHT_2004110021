
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import javax.swing.plaf.SliderUI;

public class DanhSachHangHoa implements InterfaceHangHoa {
    private List<HangHoa> lHoas = new ArrayList<>();
    private List<HangHoaDienMay> lMays = new ArrayList<>();
    private int sLHHDienMay;
    private int sLHHSanhSu;
    private int sLHHThucPham;
    private Date ngaySX, ngayHH, ngayNK;
    private String nhaCC;
    private SimpleDateFormat sFormat = new SimpleDateFormat("dd/MM/yyyy");
    public Scanner sc = new Scanner(System.in);

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

    public void xoaHH() {
        HangHoa hangHoa1 = null;
        System.out.println("Nhập Mã Hàng Muốn Xoá:");
        int maHH = sc.nextInt();
        for (HangHoa hangHoa : lHoas) {
            if (maHH == hangHoa.getMaH()) {
                hangHoa1 = hangHoa;
                break;
            }
        }
        if (hangHoa1 != null) {
            this.xoaHangHoa(hangHoa1);
            System.out.println("Hàng Hoá Đã Được Xoá");
        } else {
            System.out.println("Hàng Hoá Không Tồn Tại");
        }
    }

    public void suaHH() {
        System.out.println("Nhập Mã Hàng Muốn Sửa:");
        int maH = sc.nextInt();
        sc.nextLine();
        this.suaHangHoa(maH);
    }

    private HangHoa suaHangHoa(int maSua) {
        HangHoa hangHoa1 = null;
        for (HangHoa hangHoa : lHoas) {
            if (maSua == hangHoa.getMaH()) {
                hangHoa1 = hangHoa;
                break;
            }
        }
        if (hangHoa1 == null) {
            System.out.println("Hàng Hoá Chưa Tồn Tại");
        }
        System.out.println("Muốn Nhập Hoá Đơn Nào? [1: Điện Máy] [2:Thực Phẩm] [3:Sành Sứ]");
        int lc = sc.nextInt();
        if(lc == 1){
            System.out.println("===Bạn Đang Chọn Nhập Cho Điện Máy===");
            for (int i = 0; i < lHoas.size(); i++) {
                if (maSua == lHoas.get(i).getMaH()) {
                    System.out.println("Nhập Tên Hàng Hoá: ");
                    String tenHH = sc.nextLine();
                    System.out.println("Nhập Đơn Giá Hàng Hoá: ");
                    double donGiaHH = sc.nextDouble();
                    System.out.println("Nhập Số Lượng Tồn Kho: ");
                    int sLTKHH = sc.nextInt();
                    System.out.println("Nhập Thời Gian Bảo Hành Cho Hàng Hoá Trên:");
                    int thoiGianBH = sc.nextInt();
                    System.out.println("Nhập Công Xuất Cho Hàng Hoá Trên:");
                    double congXuat = sc.nextDouble();
                    sc.nextLine();
                    lMays.get(i).setTenH(tenHH);
                    lMays.get(i).setDonGiaH(donGiaHH);
                    lMays.get(i).setCongXuat(congXuat);
                    lMays.get(i).setsLTonKhoH(sLTKHH);
                    lMays.get(i).setThoiGianBH(thoiGianBH);
                }
            
        }
        }
        

    return hangHoa1;

    }

    // public void sua() {
    // try {
    // System.out.println("Nhap ma hang can sua: ");
    // String idSua = nhap.nextLine();
    // HangHoa hh = null;

    // for (HangHoa hangHoa : dShangHoa) {
    // if (hangHoa.getMaHang().equals(idSua)) {
    // hh = hangHoa;
    // break;
    // }
    // }

    // if (hh == null) {
    // System.out.println("Ma san pham khong ton tai trong kho!!");
    // }

    // for (int i = 0; i < dShangHoa.size(); i++) {
    // if (idSua.equals(dShangHoa.get(i).getMaHang())) {

    // nhap.nextLine();

    // System.out.println("Nhap ten Hang Hoa: ");
    // String tenHang = nhap.nextLine();
    // System.out.println("So luong Hang Hoa: ");
    // int soLuong = nhap.nextInt();
    // System.out.println("Don Gia: ");
    // double donGia = nhap.nextDouble();

    // dShangHoa.get(i).setTenHang(tenHang);
    // dShangHoa.get(i).setSoLuong(soLuong);
    // dShangHoa.get(i).setDonGia(donGia);

    // System.out.println("Sua hang hoa thanh cong!!!");
    // break;
    // }else
    // System.out.println("Sua hang hoa that bai");
    // }

    // } catch (InputMismatchException ei) {
    // System.out.println("Bạn đã nhập sai giá trị, xin vui lòng nhập lại!");
    // } catch (Exception e) {
    // System.out.println(e.getMessage());
    // }
    // }

    public int timViTri(HangHoa hangHoa) {
        int viTri = -1;
        viTri = this.lHoas.indexOf(viTri);
        return viTri;
    }

    public HangHoa timHangHoaTheoMa(int maHH) {
        HangHoa hangHoa1 = null;
        for (HangHoa hangHoa : lHoas) {
            if (hangHoa.getMaH() == maHH) {
                hangHoa1 = hangHoa;
            } else {
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
