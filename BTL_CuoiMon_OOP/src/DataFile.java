

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DataFile {
    private File dataFile = new File("DataFile.txt");
    public void createFile(){
        try {
            if(dataFile.createNewFile()){
                System.out.println("File Đã Được Tạo Thành Công!!!");
            }
            else
            {
                System.out.println("File Không Được Tạo Thành Công!!!");
            }
        } catch (IOException e) {
            System.out.println("File Không Ổn...");
        }
    }
    public void writeFile(){
        try (FileWriter datFileWriter = new FileWriter("DataFile.txt")) {
            datFileWriter.write(this.dataTP()+ this.dataDM() + this.dataSS());
            datFileWriter.close();
        } catch (IOException e) {
            System.out.println("Không Thể Viết File...");
        }
        
    }
    public void readData(){
        char data [] = new char[10000];
        try {
            FileReader datFileReader = new FileReader("DataFile.txt");
            datFileReader.read(data);
            System.out.println("Đã Đọc Được Data Trong File");
            System.out.println(data);
            datFileReader.close();
        } catch (IOException e) {
            System.out.println("File Có Vấn Đề!!!");
        }
    }
    public String dataTP(){
        String dataTP = "Rau Má, 12000, 100, 12/02/2022, 12/05/2022, HCM\n" +
        "Rau Thơm, 12000, 100, 12/02/2022, 12/05/2022, HCM\n"+
        "Rau Muống, 12000, 100, 12/02/2022, 12/05/2022, HCM\n"+
        "Cá Mú, 12000, 100, 12/02/2022, 12/05/2022, HCM\n"+
        "Cá Ba Sa, 12000, 100, 12/02/2022, 12/05/2022, HCM\n"+
        "Cá Trê, 12000, 100, 12/02/2022, 12/05/2022, HCM\n" ;
        return dataTP;
    }
    public String dataSS(){
        String dataSS = "Chén, 12000, 100, 12/02/2022, 12/05/2022, HCM\n" +
        "Dĩa, 12000, 100, 12/02/2022, 12/05/2022, HCM\n"+
        "Muỗng, 12000, 100, 12/02/2022, 12/05/2022, HCM\n"+
        "Nồi Sứ, 12000, 100, 12/02/2022, 12/05/2022, HCM\n"+
        "Vá Sứ, 12000, 100, 12/02/2022, 12/05/2022, HCM\n"+
        "Chảo, 12000, 100, 12/02/2022, 12/05/2022, HCM\n" ; 
        return dataSS;
    }
    public String dataDM()
    {
        String dataDM = "Máy Lạnh, 12000, 100, 12/02/2022, 12/05/2022, HCM\n" +
        "Máy Giặt, 12000, 100, 12/02/2022, 12/05/2022, HCM\n"+
        "Máy Nước Nóng, 12000, 100, 12/02/2022, 12/05/2022, HCM\n"+
        "Máy Quạt, 12000, 100, 12/02/2022, 12/05/2022, HCM\n"+
        "Ổ Điện, 12000, 100, 12/02/2022, 12/05/2022, HCM\n"+
        "Dây Điện, 12000, 100, 12/02/2022, 12/05/2022, HCM\n" ; 
        return dataDM;
    }
}
