

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class DanhSachHangHoa implements InterfaceHangHoa {
    private List<HangHoa> lHoas = new ArrayList<>();
    private DuLieuHangHoaFile dFile = new DuLieuHangHoaFile();
    private static int sLHHDienMay,sLHHSanhSu,sLHHThucPham;
    private int sumDM, sumSS, sumTP, sum;
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

    private void xoaHH(HangHoa hangHoa) {
        this.lHoas.remove(hangHoa);
    }
    @Override
    public void xoaHangHoa() {
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
            this.xoaHH(hangHoa1);
            System.out.println("Hàng Hoá Đã Được Xoá");
        } else {
            System.out.println("Hàng Hoá Không Tồn Tại");
        }
        
    }
    private void tinhSLHangHoaTungLoai() {
        for (HangHoa hangHoa : lHoas) {
            if (hangHoa instanceof HangHoaThucPham) {
                sumTP += hangHoa.getsLTonKhoH();  
            }
            if (hangHoa instanceof HangHoaDienMay) {
                sumDM += hangHoa.getsLTonKhoH(); 
            } else if (hangHoa instanceof HangHoaSanhSu) {
                sumSS += hangHoa.getsLTonKhoH();
            }
        }
    }
    @Override
    public void tongSlHangHoaTungLoai() {
        this.tinhSLHangHoaTungLoai();
        System.out.println("Tong so luong Hang Thuc Pham ton kho= " + sumTP);
        System.out.println("Tong so luong Hang Dien May ton kho= " + sumDM);
        System.out.println("Tong so luong Hang Sanh Su ton kho = " + sumSS);
        sum = sumTP + sumDM + sumSS;
        System.out.println("Tong so hang con trong kho la:" + sum);
        
    }
    @Override
    public void sapXepHangHoa() {
            Collections.sort(lHoas, new Comparator<HangHoa>() {
            @Override
            public int compare(HangHoa o1, HangHoa o2) {
                if(o1.getDonGiaH() < o2.getDonGiaH()){
                    return 1;
                }
                else{
                    if(o1.getDonGiaH() ==  o2.getDonGiaH()){
                        return 0;
                    }
                    else{
                        return -1;
                    }
                }
            }
        });
        this.hienThiHangHoa();
    }

    @Override
    public void hienThiHangHoa() {
        for (HangHoa hangHoa : lHoas) {
                    dFile.read();
                    System.out.println(hangHoa);
                    System.out.println();
                }
        
    }
    public HangHoa timHangHoaTheoMa(int maHH) {
        HangHoa hangHoa1 = null;
        for (HangHoa hangHoa : lHoas) {
            if (maHH == hangHoa.getMaH()) {
                hangHoa1 = hangHoa;
                System.out.println(hangHoa1);  
                break;    
            }   
        }
        if(maHH != hangHoa1.getMaH()){
            System.out.println("Mã Hàng Không Tồn Tại");
        }
        return hangHoa1;
    }   
    public void themHangHoa(HangHoa hangHoa) {
        lHoas.add(hangHoa);
        dFile.write(lHoas);

    }
}
