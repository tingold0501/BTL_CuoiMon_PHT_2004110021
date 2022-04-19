

public abstract class HangHoa {
    private int maH, sLTonKhoH;
    private String tenH;
    private double donGiaH;
    private static int autoMaH = 1;
    public HangHoa(){

    }
    
    public int getMaH() {
        return maH;
    }
    private void setMaH(int maH) {
        if(maH > 0){
            this.maH = maH;
        }
        else{
            System.out.println("Mã Đang Rổng Vui Lòng Thử Lại");
        }
        
    }
    public int getsLTonKhoH() {
        return sLTonKhoH;
    }
    private void setsLTonKhoH(int sLTonKhoH) {
        if(sLTonKhoH > 0){
            this.sLTonKhoH = sLTonKhoH;
        }
        else{
            System.out.println("Số Lượng Tồn Kho Không Hợp Lệ");
        }
    }
    public String getTenH() {
        return tenH;
    }
    private void setTenH(String tenH) {
        if(tenH != null){
            this.tenH = tenH;
        }
        else{
            System.out.println("Tên Hàng Đang Rỗng Vui Lòng Thử Lại");
        }
    }
    public double getDonGiaH() {
        return donGiaH;
    }
    private void setDonGiaH(double donGiaH) {
        if(donGiaH > 0 ){
            this.donGiaH = donGiaH;
        }
        else{
            System.out.println("Đơn Giá Không Hợp Lê!!");
        }
    }
    public HangHoa(int sLTonKhoH, String tenH, double donGiaH) {
        this.maH = autoMaH++;
        this.sLTonKhoH = sLTonKhoH;
        this.tenH = tenH;
        this.donGiaH = donGiaH;
    }
    @Override
    public String toString() {
        return "Quản Lý Hàng Hoá \n[Đơn Giá Hàng Hoá = " + donGiaH + 
        ", Mã Hàng Hoá = " + maH + 
        ", Số Lượng Tồn Kho = " + sLTonKhoH + 
        ", Tên Hàng Hoá = " + tenH + "]\n";
    }
}
