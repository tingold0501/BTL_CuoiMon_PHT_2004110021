
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ControllerHangHoa {
    public Scanner sc = new Scanner(System.in);
    private DanhSachHangHoa dSHH = new DanhSachHangHoa();
    private List<HangHoa> lHoas = new ArrayList<>();
    private DuLieuHangHoaFile dFile = new DuLieuHangHoaFile();
    private Date ngaySX, ngayHH, ngayNK;
    private String nhaCC;
    private String yn = null;
    private SimpleDateFormat sFormat = new SimpleDateFormat("dd/MM/yyyy");

    public ControllerHangHoa() {
        dFile = new DuLieuHangHoaFile();
        lHoas = dFile.read();
    }

    public ControllerHangHoa(List<HangHoa> lHoas) {
        this.lHoas = lHoas;
    }

    public List<HangHoa> getlHoas() {
        return lHoas;
    }

    public void setlHoas(List<HangHoa> lHoas) {
        this.lHoas = lHoas;
    }

   

    // Hàm nhập cho Hàng Hoá

    private String nhapTenHang() {
        System.out.print("Nhập Tên Hàng Hoá: ");
        return sc.nextLine();
    }

    private String nhapNhaCC() {
        System.out.println("Nhập Nhà Cung Cấp:");
        return sc.nextLine();
    }

    private String nhapNhaSX() {
        System.out.println("Nhập Nhà Sản Xuất:");
        return sc.nextLine();
    }

    private int nhapSLTK() {
        System.out.println("Nhập Số Lượng Tồn Kho: ");
        while (true) {
            try {
                int maH = Integer.parseInt((sc.nextLine()));
                return maH;
            } catch (NumberFormatException ex) {
                System.out.println("Nhập Lại Số Lượng ");
            }
        }
    }

    private double nhapDonGia() {
        System.out.println("Nhập Đơn Giá:");
        while (true) {
            try {
                double donGiaH = Double.parseDouble(sc.nextLine());
                return donGiaH;
            } catch (Exception e) {
                System.out.println("Nhập Lại Đơn Giá");
            }
        }
    }

    private int nhapThoiGianBH() {
        System.out.println("Nhập Thời Gian Bảo Hành: ");
        while (true) {
            try {
                int tGBH = Integer.parseInt((sc.nextLine()));
                return tGBH;
            } catch (NumberFormatException ex) {
                System.out.println("Nhập Lại Thời Gian Bảo Hành ");
            }
        }
    }

    private double nhapCongXuat() {
        System.out.println("Nhập Công Xuất:");
        while (true) {
            try {
                double congXuat = Double.parseDouble(sc.nextLine());
                return congXuat;
            } catch (Exception e) {
                System.out.println("Nhập Lại Công Xuất");
            }
        }
    }

    private Date nhapNgayNhapKho() {
        while (true) {
            try {
                System.out.println("Nhập Ngày Nhập Kho[dd/MM/yyyy]:");
                Date ngayNK = sFormat.parse(sc.nextLine());
                return ngayNK;
            } catch (Exception e) {
                System.out.println("Ngày Nhập Kho Không Hợp Lệ!!");
            }
        }
    }
    private Date nhapNgaySanXuat() {
        while (true) {
            try {
                System.out.println("Nhập Ngày Sản Xuất[dd/MM/yyyy]:");
                Date ngayNK = sFormat.parse(sc.nextLine());
                return ngayNK;
            } catch (Exception e) {
                System.out.println("Ngày Sản Xuất Không Hợp Lệ!!");
            }
        }
    }
    private Date nhapNgayHetHan() {
        while (true) {
            try {
                System.out.println("Nhập Ngày Hết Hạn[dd/MM/yyyy]:");
                Date ngayNK = sFormat.parse(sc.nextLine());
                return ngayNK;
            } catch (Exception e) {
                System.out.println("Ngày Hết Hạn Không Hợp Lệ!!");
            }
        }
    }
   
    public void suaHangHoa(int maSua) {
        boolean isExisted = false;
        int size = lHoas.size();
        for (int i = 0; i < size; i++) {
            if (lHoas.get(i).getMaH() == maSua) {
                isExisted = true;
                lHoas.get(i).setTenH(nhapTenHang());
                lHoas.get(i).setDonGiaH(nhapDonGia());
                lHoas.get(i).setsLTonKhoH(nhapSLTK());
                break;
            }
        }
        if (!isExisted) {
            System.out.printf("Mã Hàng = %d Không Tồn Tại.\n", maSua);
        } 
    }
    private HangHoa nhapHangHoa() {
        HangHoa hangHoa = null;
        int id = (lHoas.size() > 0) ? (lHoas.size() + 1) : 1;
        System.out.println("Mã Hàng Hoá = " + id);
        String tenHH = this.nhapTenHang();
        double donGiaHH = this.nhapDonGia();
        int sLTKHH = this.nhapSLTK();
        System.out.println("Muốn Nhập Hoá Đơn Nào? [1: Điện Máy] [2:Thực Phẩm] [3:Sành Sứ]");
        int lc = sc.nextInt();
        sc.nextLine();
        switch (lc) {
            case 1:
                System.out.println("===Bạn Đang Chọn Nhập Cho Điện Máy===");
                int thoiGianBH = this.nhapThoiGianBH();
                double congXuat = this.nhapCongXuat();
                sc.nextLine();
                hangHoa = new HangHoaDienMay(sLTKHH, tenHH, donGiaHH, thoiGianBH, congXuat);
                break;
            case 2:
                // Thực hiện chức năng nhập Hàng Hoá Thực Phẩm
                System.out.println("===Bạn Đang Chọn Chức Năng Cho Thực Phẩm===");
                ngaySX = this.nhapNgaySanXuat();
                ngayHH = this.nhapNgayHetHan();
                nhaCC = this.nhapNhaCC();
                hangHoa = new HangHoaThucPham(sLTKHH, tenHH, donGiaHH, ngaySX, ngayHH, nhaCC);
                break;
            case 3:
                // Thực hiện chức năng nhập Hàng Hoá Sành Sứ
                System.out.println("===Bạn Đang Chọn Nhập Cho Sành Sứ===");
                String nhaSXHH = this.nhapNhaSX();
                ngayNK = this.nhapNgayNhapKho();
                hangHoa = new HangHoaSanhSu(sLTKHH, tenHH, donGiaHH, nhaSXHH, ngayNK);
                break;
            default:
                System.out.println("Lựa Chọn Không Hợp Lệ!!!");
        }
        lHoas.add(hangHoa);
        // dFile.write(lHoas);
        return hangHoa;
    }

    public void data() {
        try{
            String Date1 = "18/04/2022";
            String Date2 = "20/04/2022";
            String Date3 = "25/04/2022";
            String Date4 = "30/04/2022";
            String Date5 = "16/04/2022";
            String Date6 = "14/04/2022";
            String Date7 = "10/04/2022";
            String Date8 = "22/04/2022";
            String Date9 = "26/04/2022";
            Date d1 = sFormat.parse(Date1);
            Date d2 = sFormat.parse(Date2);
            Date d3 = sFormat.parse(Date3);
            Date d4 = sFormat.parse(Date4);
            Date d5 = sFormat.parse(Date5);
            Date d6 = sFormat.parse(Date6);
            Date d7 = sFormat.parse(Date7);
            Date d8 = sFormat.parse(Date8);
            Date d9 = sFormat.parse(Date9);
            HangHoa hTP = new HangHoaThucPham(200, "Rau Má", 1000, d1, d2, "HCM");
            HangHoa hTP1 = new HangHoaThucPham(150, "Rau Thơm", 2500, d3, d5, "Củ Chi");
            HangHoa hTP2 = new HangHoaThucPham(250, "Rau Bắp Cải", 3500, d6, d9, "Củ Chi");
            HangHoa hDM = new HangHoaDienMay(10, "Máy Lạnh", 10000000, 12, 200);
            HangHoa hDM1 = new HangHoaDienMay(30, "Máy Nước Nóng", 150000000, 12, 200);
            HangHoa hDM2 = new HangHoaDienMay(15, "Quạt Máy", 7000000, 9, 100);
            HangHoa hDM3 = new HangHoaDienMay(32, "Máy Tính", 50000000, 24, 250);
            HangHoa hSS = new HangHoaSanhSu(100, "Chén", 120000, "HCM", d4);
            HangHoa hSS1 = new HangHoaSanhSu(50, "Dĩa", 20000, "Củ Chi", d1);
            HangHoa hSS2 = new HangHoaSanhSu(70, "Muỗng", 10000, "HCM", d8);
            HangHoa hSS3 = new HangHoaSanhSu(150, "Nồi", 11000, "HCM", d7);
            dSHH.themHangHoa(hTP);
            dSHH.themHangHoa(hTP1);
            dSHH.themHangHoa(hTP2);
            dSHH.themHangHoa(hDM);
            dSHH.themHangHoa(hDM1);
            dSHH.themHangHoa(hDM2);
            dSHH.themHangHoa(hDM3);
            dSHH.themHangHoa(hSS);
            dSHH.themHangHoa(hSS1);
            dSHH.themHangHoa(hSS2);
            dSHH.themHangHoa(hSS3);

        }catch (Exception e){
            System.out.println("Data Lỗi");
        }
    }

    public void menuHangHoa() {
        this.data();
        do {
            System.out.println("======================MENU===================");
            System.out.println("=1===============NHẬP HÀNG HOÁ===============");
            System.out.println("=2================XOÁ HÀNG HOÁ===============");
            System.out.println("=3================SỬA HÀNG HOÁ===============");
            System.out.println("=4==================THỐNG KÊ=================");
            System.out.println("=5===================SẮP XẾP=================");
            System.out.println("=6==============HIỂN THỊ DANH SÁCH===========");
            System.out.println("=7=============TÌM HÀNG HOÁ THEO MÃ==========");
            System.out.println("=8==============DANH SÁCH TỔNG QUÁ===========T");
            System.out.println("=0====================EIXT===================");
            System.out.println("Nhập Lựa Chọn Của Bạn: ");
            int lc = sc.nextInt();
            sc.nextLine();
            switch (lc) {
                case 0:
                    break;
                case 1:
                    System.out.println("===Bạn Đã Chọn Chức Năng Nhập Thêm Hàng Hoá===");
                    this.nhapHangHoa();
                    break;
                case 2:
                    System.out.println("===Bạn Đã Chọn Chức Năng Xoá Hàng Hoá===");
                    dSHH.xoaHangHoa();
                    break;
                case 3:
                    System.out.println("===Bạn Đã Chọn Chức Năng Sửa Hàng Hoá===");
                    System.out.println("Nhập Mã Muốn Sửa:");
                    int maS = sc.nextInt();
                    sc.nextLine();
                    this.suaHangHoa(maS);
                    break;
                case 4:
                    System.out.println("===Bạn Đã Chọn Chức Năng Thống Kê Hàng Hoá===");
                    dSHH.tongSlHangHoaTungLoai();
                    break;
                case 5:
                    System.out.println("===Bạn Đã Chọn Chức Năng Sắp Xếp Hàng Hoá===");
                    dSHH.sapXepHangHoa();
                    break;
                case 6:
                    System.out.println("===Bạn Đã Chọn Chức Năng Hiển Thị Hàng Hoá===");
                    dSHH.hienThiHangHoa();
                    break;
                case 7:
                    System.out.println("Nhập Mã Muốn Tìm: ");
                    int maTK = sc.nextInt();
                    sc.nextLine();
                    dSHH.timHangHoaTheoMa(maTK);
                    break;
                default:
                    System.out.println("Lựa Chọn Không Hợp Lệ!!!");
                    break;
            }
            System.out.println("Muốn Dừng Chương Trình Không [Y/N]");
            yn = sc.nextLine();
        } while (yn.equals("N") || yn.equals("n"));
    }

}
