

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ControllerHangHoa {
    public Scanner sc = new Scanner(System.in);
    private DanhSachHangHoa danhSachHangHoa = new DanhSachHangHoa();
    private String yn = null, nhaCC;
    private Date ngaySX , ngayHH, ngayNK;
    private SimpleDateFormat sFormat = new SimpleDateFormat("dd/MM/yyyy");
    // Hàm nhập cho Hàng Hoá
    public HangHoa inputHangHoa(){
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
            switch(lc){
                case 1:
                System.out.println("===Bạn Đang Chọn Nhập Cho Điện Máy===");
                System.out.println("Nhập Thời Gian Bảo Hành Cho Hàng Hoá Trên:");
                int thoiGianBH = sc.nextInt();
                System.out.println("Nhập Công Xuất Cho Hàng Hoá Trên:");
                double congXuat = sc.nextDouble();
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
                hangHoa = new HangHoaThucPham(sLTKHH, tenHH, donGiaHH, ngaySX , ngayHH, nhaCC);
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
                default: System.out.println("Lựa Chọn Không Hợp Lệ!!!");
            }
        return hangHoa;
    }
   
    public void menuHangHoa(){
        do{
            System.out.println("======================MENU===================");
            System.out.println("=1===============NHẬP HÀNG HOÁ===============");
            System.out.println("=2================XOÁ HÀNG HOÁ===============");
            System.out.println("=3================SỬA HÀNG HOÁ===============");
            System.out.println("=4==================THỐNG KÊ=================");
            System.out.println("=5===================BÁO CÁO=================");
            System.out.println("=6===================SẮP XẾP=================");
            System.out.println("=7==============HIỂN THỊ DANH SÁCH===========");
            System.out.println("=0====================EIXT===================");
            System.out.println("Nhập Lựa Chọn Của Bạn: ");
            int lc = sc.nextInt();
            sc.nextLine();
            switch(lc){
                case 0:
                break;
                case 1:
                System.out.println("===Bạn Đã Chọn Chức Năng Nhập Thêm Hàng Hoá===");
                this.inputHangHoa();
                break;
                case 2:
                System.out.println("===Bạn Đã Chọn Chức Năng Xoá Hàng Hoá===");
                danhSachHangHoa.xoaHangHoa();
                break;
                case 3:
                System.out.println("===Bạn Đã Chọn Chức Năng Sửa Hàng Hoá===");
                danhSachHangHoa.suaHangHoa();
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
                System.out.println(danhSachHangHoa);
                break;
                default: System.out.println("Lựa Chọn Không Hợp Lệ!!!");
                break;
            }
        System.out.println("Muốn Nhập Tiếp Không [Y/N]");
        yn = sc.nextLine();
        }while(yn.equals("Y") || yn.equals("y"));
    }

    
}
