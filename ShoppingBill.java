import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;

public class ShoppingBill
{
public static void main(String args[])
{
String id = null;
String productName = null;
int quantity = 0;
double price = 0.0;
double totalPrice = 0.0;
double overAllPrice = 0.0;
double cgst, sgst, subtotal=0.0, discount=0.0;
char choice = '\0';

System.out.println("\t\t\t\t--------------------Reciept-----------------");
System.out.println("\t\t\t\t\t\t "+" "+"Soicy Tires");
System.out.println("\t\t\t\t\t105 Main St New Town, California");
System.out.println("GSTIN: 03AWBPP8756K592"+"\t\t\t\t\t\t\tContact: (+91) 9988776655");

SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
Date date = new Date();
Calendar calendar = Calendar.getInstance();
String[] days = new String[] { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };

System.out.println("Date: "+formatter.format(date)+" "+days[calendar.get(Calendar.DAY_OF_WEEK) - 1]+"\t\t\t\t\t\t (+91) 9998887770");
Scanner scan = new Scanner(System.in);

System.out.print("Enter Customer Name: ");

String customername=scan.nextLine();
List<Product> product = new ArrayList<Product>();

do
{
System.out.println("Product details: ");
System.out.print("ID: ");
id = scan.nextLine();
System.out.print("Name: ");
productName = scan.nextLine();
System.out.print("Quantity: ");
quantity = scan.nextInt();
System.out.print("Price (per unit): ");
price = scan.nextDouble();

totalPrice = price * quantity;
overAllPrice = overAllPrice + totalPrice;
product.add( new Product(id, productName, quantity, price, totalPrice) );

System.out.print("Would you like to add any more items? (y or n): ");

choice = scan.next().charAt(0);
scan.nextLine();
}

while (choice == 'y' || choice == 'Y');
Product.displayFormat();
for (Product p : product)
{
p.display();
}

System.out.println("\n\t\t\t\t\t\t\t\t\t\tTotal Amount (Rs.) " +overAllPrice);
discount = overAllPrice*2/100;
System.out.println("\n\t\t\t\t\t\t\t\t\t\t Discount (Rs.) " +discount);
subtotal = overAllPrice-discount;
System.out.println("\n\t\t\t\t\t\t\t\t\t\t Subtotal "+subtotal);
sgst=overAllPrice*12/100;
System.out.println("\n\t\t\t\t\t\t\t\t\t\t SGST (%) "+sgst);
cgst=overAllPrice*12/100;
System.out.println("\n\t\t\t\t\t\t\t\t\t\t CGST (%) "+cgst);
System.out.println("\n\t\t\t\t\t\t\t\t\t\t Invoice Total " +(subtotal+cgst+sgst));
System.out.println("\t\t\t\t----------------Thank You for Shopping!!-----------------");
System.out.println("\t\t\t\t\t Feel free to leave a review on yelp!");
scan.close();
}
}