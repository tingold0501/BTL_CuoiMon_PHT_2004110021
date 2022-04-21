
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ControllerHangHoa {
    public Scanner sc = new Scanner(System.in);
    private DanhSachHangHoa danhSachHangHoa = new DanhSachHangHoa();
    private String yn = null, nhaCC;
    private Date ngaySX, ngayHH, ngayNK;
    private SimpleDateFormat sFormat = new SimpleDateFormat("dd/MM/yyyy");

    // Hàm nhập cho Hàng Hoá
   

    private void nhapHH() {
        String luaChon = null;
        do {
            HangHoa hangHoa = this.nhapHangHoa();
            danhSachHangHoa.themHangHoa(hangHoa);
            System.out.println("Nhập Sản Phẩm Tiếp Không [Y/N]");
            luaChon = sc.nextLine();
        } while (luaChon.equals("Y") || luaChon.equals("y"));
    }

    private HangHoa nhapHangHoa() {
        HangHoa hangHoa = null;
        System.out.println("Nhập Tên Hàng Hoá: ");
        String tenHH = sc.nextLine();
        System.out.println("Nhập Đơn Giá Hàng Hoá: ");
        double donGiaHH = sc.nextDouble();
        System.out.println("Nhập Số Lượng Tồn Kho: ");
        int sLTKHH = sc.nextInt();
        System.out.println("Muốn Nhập Hoá Đơn Nào? [1: Điện Máy] [2:Thực Phẩm] [3:Sành Sứ]");
        int lc = sc.nextInt();
        sc.nextLine();
        switch (lc) {
            case 1:
                System.out.println("===Bạn Đang Chọn Nhập Cho Điện Máy===");
                System.out.println("Nhập Thời Gian Bảo Hành Cho Hàng Hoá Trên:");
                int thoiGianBH = sc.nextInt();
                System.out.println("Nhập Công Xuất Cho Hàng Hoá Trên:");
                double congXuat = sc.nextDouble();
                sc.nextLine();
                hangHoa = new HangHoaDienMay(sLTKHH, tenHH, donGiaHH, thoiGianBH, congXuat);
                break;
            case 2:
                // Thực hiện chức năng nhập Hàng Hoá Thực Phẩm
                System.out.println("===Bạn Đang Chọn Chức Năng Cho Thực Phẩm===");
                try {
                    System.out.println("Nhập Ngày Sản Xuất Cho Hàng Hoá Trên: [dd/MM/yyyy]");
                    ngaySX = sFormat.parse(sc.nextLine());
                    System.out.println("Nhập Ngày Hết Hạn Cho Hàng Hoá Trên:[dd/MM/yyyy]");
                    ngayHH = sFormat.parse(sc.nextLine());
                    System.out.println("Nhập Nhà Cung Cấp Cho Hàng Hoá Trên:");
                    nhaCC = sc.nextLine();
                } catch (Exception e) {
                    System.out.println("Dữ Liệu Nhập Không Hợp Lệ!!");
                }
                hangHoa = new HangHoaThucPham(sLTKHH, tenHH, donGiaHH, ngaySX, ngayHH, nhaCC);
                break;
            case 3:
                // Thực hiện chức năng nhập Hàng Hoá Sành Sứ
                System.out.println("===Bạn Đang Chọn Nhập Cho Sành Sứ===");
                System.out.println("Nhập Nhà Sản Xuất Cho Hàng Hoá Trên: ");
                String nhaSXHH = sc.nextLine();
                try {
                    System.out.println("Nhập Ngày Nhập Kho Cho Hàng Hoá Trên:");
                    ngayNK = sFormat.parse(sc.nextLine());
                } catch (Exception e) {
                    System.out.println("Dữ Liệu Không Hợp Lệ!!!");
                }
                hangHoa = new HangHoaSanhSu(sLTKHH, tenHH, donGiaHH, nhaSXHH, ngayNK);
                break;
            default:
                System.out.println("Lựa Chọn Không Hợp Lệ!!!");
        }
        return hangHoa;
    }

    public void dataTest() {
        HangHoa hHDM = new HangHoaDienMay(10, "Máy Lạnh", 100000, 12, 20);
        HangHoa hHDM1 = new HangHoaDienMay(10, "Máy Lạnh", 100000, 12, 20);
        HangHoa hHDM2 = new HangHoaDienMay(10, "Máy Lạnh", 100000, 12, 20);
        HangHoa hHDM3 = new HangHoaDienMay(10, "Máy Lạnh", 100000, 12, 20);
        HangHoa hHDM4 = new HangHoaDienMay(10, "Máy Lạnh", 100000, 12, 20);
        HangHoa hHTP = new HangHoaThucPham(20, "Rau", 10000, new Date(), new Date(), "HCM");
        HangHoa hHTP1 = new HangHoaThucPham(20, "Rau", 10000, new Date(), new Date(), "HCM");
        HangHoa hHTP2 = new HangHoaThucPham(20, "Rau", 10000, new Date(), new Date(), "HCM");
        HangHoa hHTP3 = new HangHoaThucPham(20, "Rau", 10000, new Date(), new Date(), "HCM");
        HangHoa hHTP4 = new HangHoaThucPham(20, "Rau", 10000, new Date(), new Date(), "HCM");
        HangHoa hHSS = new HangHoaSanhSu(30, "Máy Lạnh", 2000000, "HCM", new Date());
        HangHoa hHSS1 = new HangHoaSanhSu(30, "Máy Lạnh", 2000000, "HCM", new Date());
        HangHoa hHSS2 = new HangHoaSanhSu(30, "Máy Lạnh", 2000000, "HCM", new Date());
        HangHoa hHSS3 = new HangHoaSanhSu(30, "Máy Lạnh", 2000000, "HCM", new Date());
        HangHoa hHSS4 = new HangHoaSanhSu(30, "Máy Lạnh", 2000000, "HCM", new Date());
        HangHoa hHSS5 = new HangHoaSanhSu(30, "Máy Lạnh", 2000000, "HCM", new Date());
        danhSachHangHoa.themHangHoa(hHDM);
        danhSachHangHoa.themHangHoa(hHDM1);
        danhSachHangHoa.themHangHoa(hHDM2);
        danhSachHangHoa.themHangHoa(hHDM3);
        danhSachHangHoa.themHangHoa(hHDM4);
        danhSachHangHoa.themHangHoa(hHTP);
        danhSachHangHoa.themHangHoa(hHTP1);
        danhSachHangHoa.themHangHoa(hHTP2);
        danhSachHangHoa.themHangHoa(hHTP3);
        danhSachHangHoa.themHangHoa(hHTP4);
        danhSachHangHoa.themHangHoa(hHSS);
        danhSachHangHoa.themHangHoa(hHSS1);
        danhSachHangHoa.themHangHoa(hHSS2);
        danhSachHangHoa.themHangHoa(hHSS3);
        danhSachHangHoa.themHangHoa(hHSS4);
        danhSachHangHoa.themHangHoa(hHSS5);
    }

    public void menuHangHoa() {
        this.dataTest();
        do {
            System.out.println("======================MENU===================");
            System.out.println("=1===============NHẬP HÀNG HOÁ===============");
            System.out.println("=2================XOÁ HÀNG HOÁ===============");
            System.out.println("=3================SỬA HÀNG HOÁ===============");
            System.out.println("=4==================THỐNG KÊ=================");
            System.out.println("=5===================BÁO CÁO=================");
            System.out.println("=6===================SẮP XẾP=================");
            System.out.println("=7==============HIỂN THỊ DANH SÁCH===========");
            System.out.println("=8============TÌM HOÁ ĐÓN THEO MÃ============");
            System.out.println("=0====================EIXT===================");
            System.out.println("Nhập Lựa Chọn Của Bạn: ");
            int lc = sc.nextInt();
            sc.nextLine();
            switch (lc) {
                case 0:
                    break;
                case 1:
                    System.out.println("===Bạn Đã Chọn Chức Năng Nhập Thêm Hàng Hoá===");
                    this.nhapHH();
                    break;
                case 2:
                    System.out.println("===Bạn Đã Chọn Chức Năng Xoá Hàng Hoá===");
                    danhSachHangHoa.xoaHH();
                    break;
                case 3:
                    System.out.println("===Bạn Đã Chọn Chức Năng Sửa Hàng Hoá===");
                    danhSachHangHoa.suaHH();
                    break;
                case 4:
                    System.out.println("===Bạn Đã Chọn Chức Năng Thống Kê Hàng Hoá===");
                    danhSachHangHoa.thongKeHangHoa();
                    break;
                case 5:
                    System.out.println("===Bạn Đã Chọn Chức Năng Báo Cáo Hàng Hoá===");
                    danhSachHangHoa.baoCaoHangHoa();
                    break;
                case 6:
                    System.out.println("===Bạn Đã Chọn Chức Năng Sắp Xếp Hàng Hoá===");
                    danhSachHangHoa.sapXepHangHoa();
                    break;
                case 7:
                    System.out.println("===Bạn Đã Chọn Chức Năng Hiển Thị Hàng Hoá===");
                    danhSachHangHoa.hienThiHangHoa();
                    break;
                case 8:
                    System.out.println("Nhập Mã Muốn Tìm: ");
                    int maTK = sc.nextInt();
                    sc.nextLine();
                    danhSachHangHoa.timHangHoaTheoMa(maTK);
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
