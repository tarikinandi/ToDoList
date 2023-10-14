import javax.swing.*;
import java.util.ArrayList;
import java.util.Objects;

public class Main {

    static ArrayList<Object> toDoList = new ArrayList<Object>();

    public static void main(String[] args) throws Exception {
        start();
    }

    private static void start() {
        String str = "Lütfen seçim yapınız : ";
        str += "\n ****************** \n";
        str += "\n [ 1 ]  Listele";
        str += "\n [ 2 ]  Ekle";
        str += "\n [ 3 ]  Sil";
        str += "\n [ 0 veya Cancel]  Çıkış";

        String selection = JOptionPane.showInputDialog(null , str);

        if (selection == null){
            selection = "0";
        } else if (selection.equals("") || selection.matches("[^0-9]+")) {
            start();
        }

        switch (selection){
            case "0" :
                exit();
                break;

            case "1":
                list();
                break;

            case "2":
                add();
                break;
            case "3":
                delete();
                break;
            default:

                break;
        }
    }

    private static void delete() {
        String title = JOptionPane.showInputDialog(null , "Silinecek başlık!");
        if(title != null && !title.equals("")){
            if (toDoList.indexOf(title) >= 0){
                toDoList.remove(toDoList.indexOf(title));
                JOptionPane.showMessageDialog(null , "Kayıt Silindi!");
                start();
            }else{
                JOptionPane.showMessageDialog(null , "Sistemde kayıtlı olmayan bir veri girdiniz!");
                delete();
            }
        }
    }

    private static void add() {
        String title = JOptionPane.showInputDialog(null , "Title giriniz!");
        if(title != null && !title.equals("")){
            if (toDoList.indexOf(title) >= 0){
                JOptionPane.showMessageDialog(null , "Sistemde kayıtlı bir veri girdiniz!");
                add();
            }else{
                toDoList.add(title);
                JOptionPane.showMessageDialog(null , "Kayıt eklendi.");
                start();
            }
        }
    }

    private static void list() {
        String str = "ToDoList";
        str += "\n\n *********************** \n";
        for (int i = 0 ; i < toDoList.size() ; i++){
            str += "[ "+ i +" ]" + toDoList.get(i) + "\n";
        }
        str += "Toplam : " + toDoList.size() + " Kayıt Bulunmaktadır.";
        message(str);
        start();
    }

    private static void message(String str) {
        JOptionPane.showMessageDialog(null , str);
    }

    private static void exit() {
        int confirm = JOptionPane.showConfirmDialog(null , "Çıkmak istediğinize emin misiniz ?");
        if (confirm == 0){
            System.exit(0);
        }else {
            start();
        }
    }
}