package exercise.iofile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

// Đọc file hiển thị danh sách các quốc gia
public class ExReadFile {
    private List<Nations> nations;
    public ExReadFile(){
        nations = readFile(fileName);
        showListNations(nations);
    }
    private static final String fileName = "F:\\Module2\\Module2\\JavaExercise\\src\\exercise\\iofile\\danhsach.txt";
    public List<Nations> readFile(String fileName){
        List<Nations> nations = new ArrayList<>();
        try{
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = null;
            while ((line = bufferedReader.readLine()) != null){
                String[] items = line.split(",");
                int id = Integer.parseInt(items[0]);
                Nations nation = new Nations(id, items[1], items[2]);
                nations.add(nation);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return nations;
    }
    public void showListNations(List<Nations> nations){
        System.out.printf("%-5s | %-10s | %-20s\n", "ID", "CODE", "NAME");
        for(int i = 0; i < nations.size(); i++){
            Nations item = nations.get(i);
            System.out.printf("%-5s | %-10s | %-20s\n", item.getId(), item.getCode(), item.getName());
        }
    }

    public static void main(String[] args) {
        ExReadFile exReadFile = new ExReadFile();
    }
}
