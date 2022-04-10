package BTL_CuoiMon;

public class HangHoaTestDrive {
    public static void main(String[] args) {
        ControllerHangHoa controllerHangHoa = new ControllerHangHoa();
        DanhSachHangHoa danhSachHangHoa = new DanhSachHangHoa();
        String luaChon = null;
        do{
            HangHoa hangHoa = controllerHangHoa.inputHangHoa();
            danhSachHangHoa.themHangHoa(hangHoa);
            System.out.println("Nhập Tiếp Không [Y/N]");
            controllerHangHoa.sc.nextLine();
            luaChon = controllerHangHoa.sc.nextLine();
        }while(luaChon.equals("Y") || luaChon.equals("y"));
        danhSachHangHoa.hienThiHangHoa();
    }
}
