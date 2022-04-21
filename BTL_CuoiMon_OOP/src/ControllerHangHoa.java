
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ControllerHangHoa {
    public Scanner sc = new Scanner(System.in);
    private DanhSachHangHoa danhSachHangHoa = new DanhSachHangHoa();
    private List<HangHoa> lHoas = new ArrayList<>();
    private DuLieuHangHoaFile dFile;
    private Date ngaySX, ngayHH, ngayNK;
    private String nhaCC;

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

    private String yn = null;
    private SimpleDateFormat sFormat = new SimpleDateFormat("dd/MM/yyyy");

    // Hàm nhập cho Hàng Hoá

    private String nhapTenHang() {
        System.out.print("Nhập Tên Hàng Hoá: ");
        return sc.nextLine();
    }

    private String nhapNhaCungCap() {
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
    // private void nhapHH() {
    //     String luaChon = null;
    //     do {
    //         HangHoa hangHoa = this.nhapHangHoa();
    //         danhSachHangHoa.themHangHoa(hangHoa);
    //         System.out.println("Nhập Sản Phẩm Tiếp Không [Y/N]");
    //         luaChon = sc.nextLine();
    //     } while (luaChon.equals("Y") || luaChon.equals("y"));
    // }

    // public void add() {
        
    //     String name = inputName();
    //     byte age = inputAge();
    //     String address = inputAddress();
    //     float gpa = inputGpa();
    //     Student student = new Student(id, name, age, address, gpa);
    //     studentList.add(student);
    //     studentDao.write(studentList);
    // }


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
        } else {
            dFile.write(lHoas);
        }
    }
    private void nhapHangHoa() {
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
                nhaCC = this.nhapNhaCungCap();
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
        dFile.write(lHoas);
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
            System.out.println("=8=============TÌM HÀNG HOÁ THEO MÃ==========");
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
                    danhSachHangHoa.xoaHH();
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
            
                    break;
                case 5:
                    System.out.println("===Bạn Đã Chọn Chức Năng Sắp Xếp Hàng Hoá===");
                    danhSachHangHoa.sapXepHangHoa();
                    break;
                case 6:
                    System.out.println("===Bạn Đã Chọn Chức Năng Hiển Thị Hàng Hoá===");
                    danhSachHangHoa.hienThiHangHoa();
                    break;
                case 7:
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
