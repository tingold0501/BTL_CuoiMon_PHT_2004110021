

public class HangHoaDienMay extends HangHoa implements InterfaceHangHoa{
    private int thoiGianBH;
    private double congXuat;
    public HangHoaDienMay(){
        
    }
    public int getThoiGianBH() {
        return thoiGianBH;
    }
    private void setThoiGianBH(int thoiGianBH) {
        if(thoiGianBH > 0){
            this.thoiGianBH = thoiGianBH;
        }
        else{
            System.out.println("Thời Gian Bản Hành Không Hợp Lệ!!");
        }
    }
    public double getCongXuat() {
        return congXuat;
    }
    private void setCongXuat(double congXuat) {
        if(congXuat > 0){
            this.congXuat = congXuat;
        }
        else{
            System.out.println("Công Xuất Không Hợp Lệ!!!");
        }
    }
    public HangHoaDienMay(int thoiGianBH, double congXuat) {
        this.thoiGianBH = thoiGianBH;
        this.congXuat = congXuat;
    }
    public HangHoaDienMay(int sLTonKhoH, String tenH, double donGiaH, int thoiGianBH, double congXuat) {
        super( sLTonKhoH, tenH, donGiaH);
        this.thoiGianBH = thoiGianBH;
        this.congXuat = congXuat;
    }
    @Override
    public double VAT() {
        double thueVat = 0;
        thueVat = this.getDonGiaH() * 0.1;
        return thueVat;
    }
    @Override
    public String toString() {
        return super.toString()+"================Thông Tin Hàng Hoá Điện Máy\n" + "Thời Gian Bảo Hành = " + this.getThoiGianBH()+ "Công Xuất = " + this.getCongXuat()+"Thuế VAT Điện Máy = "+ this.VAT();
    }
    @Override
    public void showHangHoa() {
        // TODO Auto-generated method stub
        
    }
   
  
 
}
