/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csd201_as2_phuongnk11926;
import java.util.Scanner;
//import java.io.*;

/**
 *
 * @author Phuong Nguyen
 */
public class CSD201_AS2_Phuongnk11926 {

    /**
     * @param args the command line arguments
     */
    public static String DATA_FILE = "DATA.txt";
    public static void main(String[] args) throws Exception{
        //Scanner sc = new Scanner(System.in);
        Scanner sc = new Scanner(System.in).useDelimiter("\n");
        int choice;  
        MyList<Product> list = new MyList();
        MyStack<Product> stack = new MyStack<>();
        MyQueue<Product> queue = new MyQueue<>();
        OperationToProduct otp = new OperationToProduct();
         
        while(true){
            System.out.println("Please choose one of this options");
            System.out.println("---------Menu---------");
            System.out.println("1. Load data from file and display ");
            System.out.println("2. Input & add to the end ");
            System.out.println("3. Display data ");
            System.out.println("4. Save product list to file ");
            System.out.println("5. Search by ID ");
            System.out.println("6. Delete by ID ");
            System.out.println("7. Sort by ID");
            System.out.println("8. Convert to Binary ");
            System.out.println("9. Load to stack and display");
            System.out.println("10. Load to queue and display ");
            System.out.println("11. Sort by ID use Quick sort ");
            System.out.println("0. Exit");
            System.out.println("----------------------");            
            System.out.print("Your choose : ");
            choice = Integer.parseInt(sc.nextLine());
            if(choice ==0)
            {
                System.out.println("Good bye!!!");
                break;
            }
            switch(choice){
                case 1: // in d??? li???u t??? File ra
                    System.out.println("Product's list from File: ");
                    System.out.println("Code  |  Name  |  Quantity  |  Price");
                    System.out.println("-----------------------------");
                    otp.readFile(list,DATA_FILE);
                    System.out.println();
                    break;
                case 2: // th??m d??? li???u v??o cu???i 
                    System.out.println("Input new product information : ");
                    otp.inputProductAtLast(list);
                    System.out.println();
                    break;
                case 3: // in d??? li???u t??? list ra
                    System.out.println("List of product from list :");
                    System.out.println("Code  |  Name  |  Quantity  |  Price");
                    System.out.println("-----------------------------");
                    otp.printList(list);
                    System.out.println();
                    break;    
                case 4: //l??u d??? li???u v??o file
                    System.out.println("Save data from list to File ");
                    otp.writeFile(list, DATA_FILE);
                    System.out.println("-----------------------------");
                    System.out.println("Successfully !!");
                    System.out.println();
                    break;
                case 5: //t??m ki???m s???n ph???m b???ng ID
                    System.out.println("Search by ID ");
                    System.out.print("Input code product to find out: ");
                    String value = sc.nextLine();
                    System.out.println("Result: ");
                    otp.search(list, value);
                    System.out.println();
                    break;
                case 6: // x??a s???n ph???m b???ng ID
                    System.out.println("Delete by ID ");
                    System.out.print("Input code product to delete : ");
                    value = sc.nextLine();
                    otp.deleteNode(list, value);
                    System.out.println();
                    break;
                case 7: // s???p x???p theo ID
                    System.out.println("Sort by ID ");
                    otp.sortByCode(list);
                    System.out.println();
                    break;
                case 8: // chuy???n t??? th???p ph??n sang nh??? ph??n s??? l?????ng c???a s???n ph???m ?????u ti??n
                    System.out.println("Convert to Binary  ");
                    int x = list.head.data.quantity;
                    System.out.print("Quantity of first product: " + list.head.data.quantity + " => ");
                    System.out.println(otp.convertToBinary(x));
                    System.out.println();
                    break;
                case 9: //load d??? li???u v??o ng??n x???p v?? hi???n th???
                    System.out.println("Load to stack and display");
                    otp.readFileToStack(stack, DATA_FILE);
                    System.out.println();
                    break;
                case 10: // load d??? li???u v??o h??ng ?????i v?? hi???n th???
                    System.out.println("Load to queue and display");
                    otp.readFileToQueue(queue, DATA_FILE);
                    System.out.println();
                    break;
                case 11: // s???p x???p b???ng quick sort
                    System.out.println("Arrange by Quick sort: ");
                    otp.sort(list.head, list.tail);
                    otp.printList(list);
                    System.out.println();
                    break;
                default:
                    System.out.println("Input selection from 0 to 11 ");
                    System.out.println();
                    break;
            }
        }
    }  
}
