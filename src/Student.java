import java.io.DataOutputStream;
import java.io.*;
import java.util.Random;

public class Student {
    public static void main(String[] args){
        WriteStudent("text.txt");
        ReadStudent("text.txt");
    }
    public static void WriteStudent(String path){
        try(DataOutputStream out = new DataOutputStream(new FileOutputStream(path))){
            for(int i=1; i<=5; i++){
                int studentId = i;
                String name = "Name"+i;
                Random random = new Random();
                int grade = random.nextInt(5)+2;
                double gpa = random.nextDouble(4)+2;
                out.writeInt(studentId);
                out.writeUTF(name);
                out.writeChar(grade);
                out.writeDouble(gpa);
            }
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
    public static void ReadStudent(String path){
        try(DataInputStream in = new DataInputStream(new FileInputStream(path))){
            try{
                while(true){
                    int studentId = in.readInt();
                    String name = in.readUTF();
                    int grade = in.readChar();
                    double gpa = in.readDouble();
                    System.out.print(studentId+" | "+name+" | grade: "+grade);
                    System.out.printf(" | gpa: "+"%.2f",gpa);
                    System.out.println();
                }
            }
            catch(EOFException e){

            }
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}