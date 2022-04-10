package BTL_CuoiMon;

public class HangHoaTestDrive {
    public static void main(String[] args) {
        ControllerHangHoa controllerHangHoa = new ControllerHangHoa();
        DanhSachHangHoa danhSachHangHoa = new DanhSachHangHoa();
        controllerHangHoa.menuHangHoa();
        danhSachHangHoa.hienThiHangHoa();
    }
}
