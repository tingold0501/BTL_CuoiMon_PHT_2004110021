

import java.io.IOException;

public class HangHoaTestDrive {
    public static void main(String[] args) throws IOException {
        // FileWriter.write("Data Chuong Trinh", "Hello");
        ControllerHangHoa controllerHangHoa = new ControllerHangHoa();
        DanhSachHangHoa danhSachHangHoa = new DanhSachHangHoa();
        HangHoa hangHoa = new HangHoaSanhSu();
        DataFile fileWriter = new DataFile();
        fileWriter.createFile();
        fileWriter.writeFile();
        fileWriter.readData();
        // controllerHangHoa.menuHangHoa();

        // String c = "C:/Windows/System32/calc.exe";
        // Runtime env = Runtime.getRuntime();
        // env.exec(c);
        
           

    }
}
