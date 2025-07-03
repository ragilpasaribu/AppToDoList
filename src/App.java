import java.util.Scanner;

public class App {

    public static String[] model = new String[10];
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
       
      viewShowToDoList();

    } 

    public static void showToDoList(){
        System.out.println("TO DO LIST");
        for(var i=0; i< model.length; i++){
            var  todo=model[i];
            var no=i+1;

            if (todo!=null) {
                System.out.println("NO: "+no +" "+ todo);
            }
        }

    }

    public static void testShowToDoList(){
        model[0]="Makan Pagi";
        model[1]="Berak";
        model[2]="Makan Siang";
        showToDoList();
    }

    public static void addToDoList(String todo){
        var penuh = true;
        for(var i=0; i<model.length;i++){
            if (model[i]==null) {
                
                penuh=false;
                break;
                
            }
        }

        if (penuh) {
            var tam =model;
            model=new String[model.length*2];

            for(var i=0;i<tam.length;i++){
                model[i]=tam[i];
            }
        }



        for(var i=0; i<model.length;i++){
            if (model[i]== null) {
                model[i]= todo;
                break;
            }
        }

    }

    public static void tesAddToDoList(){
        for (int i = 0; i < 25; i++) {
            addToDoList("Contoh TODOKE: " + i);
        }
        showToDoList();
    }

    public static boolean removeToDoList(int no){
        if ((no-1)>=model.length) {
            return false;
        }

        else if (model[no-1]==null) {
            return false;
        }
        else{

            
            for (int i = (no-1); i < model.length; i++) {
                if (i== (model.length -1)) {
                    model[i]= null;
                    
                }
                else{

                    model[i]=model[i+1];
                }
            }

            return true;
        }
    }

    public static void testRemove(){
        addToDoList("satu");
        addToDoList("dua");
        addToDoList("tiga");

        var result = removeToDoList(20);
        System.out.println(result);

         result = removeToDoList(4);
        System.out.println(result);

        result = removeToDoList(2);
        System.out.println(result);

        showToDoList();
    }

    public static String input(String info){
        System.out.print(info+" :");
        String data = scanner.nextLine();

        return data;
    }



    public static void tesInput(){
        var data = input("Kegiatan");
        System.out.println("Hi"+ data);
    }

    public static void viewShowToDoList(){

    while (true) {
        showToDoList();
        System.out.println("MENU: ");
        System.out.println("1. Tambah");
        System.out.println("2. hapus");
        System.out.println("X. hapus");

        var input = input("Pilih: ");
        if (input.equals("1")) {
            viewAddToDoList();
        }
        else if(input.equals("2")){
            viewRemoveToDoList();
        }
        else if(input.equals("x")){
            break;
        }
        else{
            System.out.println("tidak ada pilihan");
        }
    }

    }
    public static void testviewShowToDoList(){
        addToDoList("Bangun PAGI");
        addToDoList("Makan Siang");
        addToDoList("Bermain");

        viewShowToDoList();
    }

    public static void viewAddToDoList(){
        System.out.println("Tambah TO DO LIST");

        var todo = input("TO DO (x Jika Batal)");

        if (todo.equals(("x"))) {
            
        }
        else{
            addToDoList(todo);
        }

    }

    public static void tesViewAddTodolis(){

        viewAddToDoList();
        showToDoList();
    }

    public static void viewRemoveToDoList(){

        System.out.println("MENGHAPUS TO DO LIST");
        var todo = input("Nomor Yang Di Hapus (x Jika Batal)");

        if (todo.equals("x")) {
            
        }
        else{
            boolean sukses = removeToDoList(Integer.valueOf(todo));

            if (!sukses) {
                System.out.println("Gagal Manghapus To Do List" + todo);
            }
        }


    }
}
