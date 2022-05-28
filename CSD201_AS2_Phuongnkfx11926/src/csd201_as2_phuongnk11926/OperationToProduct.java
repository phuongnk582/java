/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csd201_as2_phuongnk11926;
import java.io.*;
import java.util.Scanner;

/**
 *
 * @author Phuong Nguyen
 */
public class OperationToProduct {
    //Scanner sc = new Scanner(System.in);
    Scanner sc = new Scanner(System.in).useDelimiter("\n");
    //không tạo biến chung, vì mỗi khi tạo hàm đã tạo tham số rồi.
    /*Node head;
    Product pro = new Product();
    MyList list = new MyList();*/
  
    //1. Đọc dữ liệu có sẵn từ file chứa các sản phẩm rồi lưu vào Linked List
    public void readFile(MyList<Product> list, String fileName){            
        try{
            File file = new File(fileName);
            InputStream inputStream = new FileInputStream(file);
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader reader = new BufferedReader(inputStreamReader);
            //kiem tra list khac rong thi clear đi
            if(list.isEmpty() !=true)
                list.clear();
            String line = "";
            while((line = reader.readLine())!=null){
                 String [] item = line.split("  \\|  "); //tach chuoi thanh cac phan tu chuoi
                Product pro = new Product(item[0],item[1],Integer.parseInt(item[2]), Double.parseDouble(item[3]));
                list.insertAtLast(pro);   
                System.out.println(pro) ;  
            }
            reader.close();
        }
        catch(FileNotFoundException e){
            //System.out.println(e);
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    //2. Nhập và thêm một sản phẩm vào cuối của danh sách Linked List 
        // Viết hàm tạo một sản phẩm
    public Product createProduct() {
        System.out.print("Input new ID: ");
        String code = sc.nextLine();
        System.out.print("Input Product's Name: ");
        String name = sc.nextLine();
        System.out.print("Input Product's quantity: ");
        Integer quan = Integer.parseInt(sc.nextLine());
        System.out.print("Input Product's price: ");
        Double price = Double.parseDouble(sc.nextLine());
        
        return new Product(code, name, quan, price);
    }
        //kết hợp 2 hàm tạo sp và add vào last
    public void inputProductAtLast(MyList<Product> list){
        //gán sản phẩm mới sẽ add vào list là sp đã được tạo trong hàm create
        Product pro = createProduct();
        list.insertAtLast(pro);
    }

    //3. In nội dung ds linklist //
    public void printList(MyList<Product> list)
    {
        Node<Product> tnode = list.head;
        while (tnode != null) {
            System.out.println(tnode.data + "   ");
            tnode = tnode.next;
        }
    }
    
    //4. Lưu danh sách các sản phẩm vào file
        //ghi một đối tượng vào file sử dụng Input Stream
    public void writeFile(MyList<Product> list, String fileName) throws Exception{
        /*
        Ghi theo kiểu đối tượng - đang bị lỗi - tìm hiểu sau
        File file = new File(fileName);
        try {
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos); 
             
            oos.writeObject(list);
            
            oos.close();
            fos.close();
        }
        catch(FileNotFoundException e){
            //System.out.println(e);
            e.printStackTrace();
        }*/
        printList(list);
        File file = new File(fileName);
        try {
          FileOutputStream fout = new FileOutputStream(file);
          OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fout);
          BufferedWriter writer = new BufferedWriter(outputStreamWriter);
          
            //FileWriter fw = new FileWriter(fileName);  // dùng trực tiếp hàm tạo FileWriter để ghi file
               
            try{ String text="";
                Node<Product> pro = list.head;
                while (pro != null) {
                    text+=pro.data.toString()+"\n";
                    pro = pro.next;
                }
                //fw.write(text);
                //fw.close();
               writer.write(text);
                writer.close();
            } 
            catch(FileNotFoundException e){
                System.out.println(e);
            }
        }catch(FileNotFoundException e){
            System.out.println(e);
        }
    }
    
    //5. Tìm kiếm thông tin của sản phẩm theo ID. nếu không tìm thấy trả về -1 hoặc thông báo không tìm thấy
        //Node phải có kiểu dữ liệu Product thì mới truy xuất giá trị trong kiểu Product
    public void search(MyList<Product> list, String x)
    {
        Node<Product> current = list.head;    //Khởi tạo biến hiện tại
        boolean check = false;
        while (current != null)
        {
            if (current.data.code.equals(x)){
                System.out.println(current.data);   //tìm thấy sản phẩm
                check = true;
            }
            current = current.next;
        }
        if(check == false)
            System.out.println("-1");    //không tìm thấy sản phẩm
    }
    
    //6. Xóa sản phẩm trong danh sách theo ID
    void deleteTail(MyList<Product> list, String x) 
    {
        Node<Product> temp = list.head;
        while (temp.next!= list.tail){
            temp = temp.getNextNode();
        }
        temp.next=null;
        list.tail=temp; 
    }
    void deleteNode(MyList<Product> list, String x)
    {
        Node<Product> temp = list.head;
        Node<Product> current = list.head; 
       
            // xóa head
            if(temp.data.code.equals(x)){
                list.head=temp.next; 
                System.out.println("Deleted!");
                return ;
            }
              //xóa phần tử có id ở cuối
            if(list.tail.data.code.equals(x)){
                deleteTail(list,x);
                System.out.println("Deleted! ");
                return;
            }
            //xóa phần tử có id giữa list
            while (temp.next != null ){
                if( temp.next.data.code.equals(x)){
                    temp.next = temp.next.next;
                    System.out.println("Deleted! ");
                  
                    return;
                }     
                temp=temp.next;
            }
        System.out.println("Không tìm thấy sp cần xóa"); 
    }
    
    //7. Sắp xếp các sản phẩm  trong danh sách theo ID
    void sortByCode(MyList<Product> list){
        Product temp;
        Node<Product> p = list.head;
        while (p!= null){
            Node<Product> q = p.getNextNode();
            while (q != null){
                if(q.data.code.compareTo(p.data.code)<0){
                   temp = p.data; 
                   p.data = q.data;
                   q.data = temp;                   
                }
                q=q.next;
            }
            p=p.next;
        }
    }
    
    //8. Biểu diễn số lượng sản phẩm (đang ở hệ đếm cơ số 10)
    //của phần tử đầu tiên trong Linked List về hệ đếm nhị phân bằng phương pháp đệ quy.
    //tham số truyền vào là 1 số nguyên, nhưng để lấy giá trị số lượng của head thì gọi trong main.
    public String convertToBinary(int i){
        if(i == 0)
            return "0";
        else{
            return convertToBinary(i/2) + (i%2);
        } 
    }
    
    //9. Đọc dữ liệu từ file chứa các sản phẩm rồi lưu vào stack. 
    //Liệt kê ra màn hình các sản phẩm có trong stack.
    
    /* In nội dung ds linklist */
    public void printStack(MyStack<Product> stack)
    {
        while (!stack.isEmpty()) {
            System.out.println(stack.pop() + "   ");
        }
    }
    public void readFileToStack(MyStack<Product> stack, String fileName){            
        try{
            File file = new File(fileName);
            InputStream inputStream = new FileInputStream(file);
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader reader = new BufferedReader(inputStreamReader);
           
            String line = "";
            while((line = reader.readLine())!=null){
                String [] item = line.split("  \\|  "); //tach chuoi thanh cac phan tu chuoi
                Product pro = new Product(item[0],item[1],Integer.parseInt(item[2]), Double.parseDouble(item[3]));
                stack.push(pro);
            }
            reader.close();
            printStack(stack);
        }
        catch(FileNotFoundException e){
            //System.out.println(e);
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    //10. Đọc dữ liệu từ file chứa các sản phẩm lưu vào queue. 
    //Hiển thị ra màn hình các sản phẩm có trong queue.
    
    public void printQueue(MyQueue<Product> queue)
    {
        while (!queue.isEmpty()) {
            System.out.println(queue.dequeue()+ "   ");
        }
    }
    public void readFileToQueue(MyQueue<Product> queue, String fileName){            
        try{
            File file = new File(fileName);
            InputStream inputStream = new FileInputStream(file);
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader reader = new BufferedReader(inputStreamReader);
           
            String line = "";
            while((line = reader.readLine())!=null){
                String [] item = line.split("  \\|  "); //tach chuoi thanh cac phan tu chuoi
                Product pro = new Product(item[0],item[1],Integer.parseInt(item[2]), Double.parseDouble(item[3]));
                queue.enqueue(pro);   
            }
            reader.close();
            printQueue(queue);
        }
        catch(FileNotFoundException e){
            //System.out.println(e);
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    //nâng cao, sắp xếp dùng QuickSort
    Node<Product> paritionLast(Node<Product> start, Node<Product> end)
    {
        if (start == end || start == null || end == null)
            return start;
        Node<Product> pivot_prev = start;
        Node<Product> curr = start;
        Product pivot = end.data;
        // iterate till one before the end,
        // no need to iterate till the end
        // because end is pivot
        while (start != end) {
            if (start.data.code.compareTo(pivot.code)<0) {
                // keep tracks of last modified item
                pivot_prev = curr;
                Product temp = curr.data;
                curr.data = start.data;
                start.data = temp;
                curr = curr.next; //duyệt phần tử tiếp theo
            }
            start = start.next; // duyệt phần tử tiếp theo
        }
 
        // swap the position of curr i.e.
        // next suitable index and pivot
        Product temp = curr.data;
        curr.data = pivot;
        end.data = temp;
 
        // return one previous to current
        // because current is now pointing to pivot
        return pivot_prev;
    }
 
    void sort(Node<Product> start, Node<Product> end)
    {
        if(start == null || start == end|| start == end.next )
            return;
 
        // phân chia danh sách và phân vùng đệ quy
        Node<Product> pivot_prev = paritionLast(start, end);
        sort(start, pivot_prev);
 
        // if pivot is picked and moved to the start,
        // that means start and pivot is same
        // so pick from next of pivot
        if (pivot_prev != null && pivot_prev == start)
            sort(pivot_prev.next, end);
 
        // if pivot is in between of the list,
        // start from next of pivot,
        // since we have pivot_prev, so we move two nodes
        else if (pivot_prev != null && pivot_prev.next != null)
            sort(pivot_prev.next.next, end);
    }
        
}
