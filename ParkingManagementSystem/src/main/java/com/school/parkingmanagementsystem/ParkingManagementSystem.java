/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.school.parkingmanagementsystem;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;
 record ServiceDetail(String description, double price) {}
     record Receipt(int plateNumber, String owner, double finalCost, String date) {}
  record DashboardSummary(int totalCars, double totalRevenue, String topOwner) {
}
class WorkshopDashboard 
{
    double TotalCosts;
    int NumberOfCars;
    //Data NewDat;
    String TheMostExpensiveCar;
   int NumberOfUnderRepairCars;
   int NumberOfReadyCars;
}

class Data 
{
    int PlateNumber;
    int ID;
    String OwnerName;
    String CarType;
    String Problem;
    String Status;
    double Cost;
    int NumberProblemForOneCar;
   
}

class ManagementSystem 
{
    // سجل يمثل خدمة واحدة تمت للسيارة
public record ServiceDetail(String description, double price) {}
    public record Receipt(int plateNumber, String owner, double finalCost, String date) {}
 record DashboardSummary(int totalCars, double totalRevenue, String topOwner) {
}
    double Costs[][] = new double[6][3];
     String problem[] = new String[6 * 3];
    String WhatisProblem[][] = new String[6][3];
    String ArrayOfTypeProblem[] = {"مشاكل المحرك", "مشاكل الكهرباء والبطارية", "أعطال نظام نقل الحركة",
        "مشاكل الفرامل والتعليق",
        "مشاكل الإطارات والعجلات", "أعطال التكييف ونظام التبريد"};
     Data NewData[]=new Data[100*2];
     int Index = 0;
  public void Check(){
      if (NewData.length==100) {
          Data NewData[]=new Data[100*2];
      }
  }
   // Data Da = new Data();
    Scanner in = new Scanner(System.in);

    public int ReadPsitiveNumber(String Message) {
        int SearchCar;
        do {
            System.out.println(Message);
            SearchCar = in.nextInt();
            
        } while (SearchCar <= 0);
        return SearchCar;
    }
 public int ReadNumberOfRangeFromStartToEnd(String Message,int From,int To)
 {
        int Number;
        do {
            System.out.println(Message);
            Number = in.nextInt();
            if (Number <From||Number>To) {
                System.out.println("لقد ادخلت قيمه خاظئة يجب ان يكون ضمن المدى"+From+"الى"+To);
            }
        } while (Number <From||Number>To);
        return Number;
    }

    public double DiscountLogic(double totalCost) 
    {
        ServiceDetail ServiceDet=new ServiceDetail("uh",67);
        return totalCost - (totalCost * 0.15);
    }

    public void InitializePrices()
    {
     Costs[0][0] = 150.0;
    Costs[0][1] = 100.0;
    Costs[0][2] = 50.0;
      Costs[1][0] = 80.0;
      Costs[1][1] = 40.0;
       Costs[1][2] = 120.0;
     Costs[2][0] = 200.0;
      Costs[2][1] = 250.0;
      Costs[2][2] = 600.0;
   Costs[3][0] = 150.0;
       Costs[3][1] = 300.0;
      Costs[3][2] = 50.0;
     Costs[4][0] = 99.0;
       Costs[4][1] = 47.7;
       Costs[4][2] = 82.5;
       Costs[5][0] = 20.9;
        Costs[5][1] = 59.3;
       Costs[5][2] = 370.6;
    }
    public void ShowPriceList()
    {
        System.out.println("=== قائمة خدمات وأسعار الورشة ===");
        for (int i = 0; i < ArrayOfTypeProblem.length; i++) {
            System.out.println("\n[" + ArrayOfTypeProblem[i] + "]");
            for (int j = 0; j < 3; j++) {
                System.out.println("   - " +WhatisProblem[i][j] + " | السعر: " + Costs[i][j] + " ريال");
            }
        }
        System.out.println("================================");
        
    }

    public void ReadOfTypeProblems() 
    {
  
       WhatisProblem[0][0] = "ارتفاع درجة الحرارة";
       WhatisProblem[0][1] = "استهلاك الزيت";
       WhatisProblem[0][2] = "تلف شمعات الاحتراق ";
     WhatisProblem[1][0] = "نفاد البطارية";
        WhatisProblem[1][1] = "ضعف الأضواء";
       WhatisProblem[1][2] = "عطل(السلف/الدينامو)";
       WhatisProblem[2][0] = "صعوبة تغيير السرعات";
        WhatisProblem[2][1] = "تأخر استجابة الجير الأوتوماتيكي";
        WhatisProblem[2][2] = "انزلاق النقلات";
        WhatisProblem[3][0] = "صفير الفرامل";
        WhatisProblem[3][1] = "ضعف كفاءة التوقف";
        WhatisProblem[3][2] = "اهتزاز عجلة القيادة";
        WhatisProblem[4][0] = "تلف الإطارات";
        WhatisProblem[4][1] = "تسريب الهواء";
        WhatisProblem[4][2] = " انحراف الاتجاهات";
        WhatisProblem[5][0] = "تسريب غاز الفريون";
        WhatisProblem[5][1] = "ضعف البرودة";
        WhatisProblem[5][2] = " سماع أصوات من كمبروسر التكييف";
    }

    public int ChoiceTypeProblem(String Message, String Message1, String Message2, String Message3, String Message4, String Message5, String Message6)
    {
        System.out.println(Message);
        System.out.println("1. " + Message1);
        System.out.println("2. " + Message2);
        System.out.println("3. " + Message3);
        System.out.println("4. " + Message4);
        System.out.println("5. " + Message5);
        System.out.println("6. " + Message6);
        System.out.println("____________________________________");
        System.out.println(" عند الانتهاء من تحديد المشاكل اضغط 0:");
        int choice = in.nextInt();
        return choice - 1;
    }

    public int ChoiceProblemInOneType(String Message, String Message1, String Message2, String Message3)
    {
        System.out.println(Message);
        System.out.println("1. " + Message1);
        System.out.println("2. " + Message2);
        System.out.println("3. " + Message3);
        System.out.println("____________________________________");
        System.out.println(" عند الانتهاء من تحديد المشاكل اضغط 0:");
        int choice = in.nextInt();
        return choice - 1;
    }
public void Ended(Data INfo)
{
           String Text="";
           int CountProblems=0;
           double totalCost = 0;
          int Result=ReadPsitiveNumber("عدد انزاع المشاكل  التي  تواجهها السيارة:");
           for (int i = 0; i <Result; i++) {
                int far=ChoiceTypeProblem("نوع المشكلة:","1. "+ArrayOfTypeProblem[0],
                "2. "+ArrayOfTypeProblem[1],"3. "+ArrayOfTypeProblem[2],"4. "+
               ArrayOfTypeProblem[3],"5. "+ArrayOfTypeProblem[4],"6. "+
              ArrayOfTypeProblem[5]);
         problem[i]=ArrayOfTypeProblem[far]+":";
          int result2=ReadPsitiveNumber("عدد  المشاكل  التي  تواجهها السيارة من نوع:"+problem[i]);
               for (int j = 0; j <result2; j++) {
                  int far2=ChoiceProblemInOneType("نوع المشكلة:","1. "+WhatisProblem[far][0],
                         "2. "+WhatisProblem[far][1],"2. "+WhatisProblem[far][2]);
                    problem[i]+=WhatisProblem[far][far2];
                    INfo.NumberProblemForOneCar++;
                    if (j<result2-1) {
                       problem[i]+="-";
                   }
                    CountProblems++;
                    totalCost+=Costs[far][far2];
               }
               Text+="\n"+problem[i];
      }
           if (CountProblems>3) {
       INfo.Cost= DiscountLogic(totalCost);
    }else
               INfo.Cost=totalCost;
          INfo.Problem=Text;
      }
               
    public String ChoiseProblems(int i)
    {
        return WhatisProblem[i][0];
    }

    public void AddCars()
    {
       Data NewCar = new Data();
         int NewPlateNumber=ReadPsitiveNumber("ادخل رقم اللوحه:");
         if (CheckCar(NewPlateNumber, NewData)==-1) 
         {
            NewCar.PlateNumber = NewPlateNumber;
        }else{        
            do{
            System.out.println("هذه السيارة موجودة مسبقاً"); 
            }while(CheckCar(ReadPsitiveNumber("ادخل رقم اخر:"), NewData)!=-1);
         }
        in.nextLine();
        System.out.println("نوع السياره: ");
        NewCar.CarType = in.nextLine(); 
        System.out.println(" اسم المالك: ");
        NewCar.OwnerName = in.nextLine();
        System.out.println(" المشكلة: ");
        ReadOfTypeProblems();
        Ended(NewCar);
         System.out.println(" الحالة: ");
        NewCar.Status=ChoiceStatus();
        //NewCar.NumberProblemForOneCar=Da.NumberProblemForOneCar;
        NewCar.ID=Index+1;
     //   NewCar.ID=Da.ID;
         NewData[Index] = NewCar;
        Index++;
    }
    public void ShowCars()
    {
        for (int i = 0; i < Index; i++) 
        {
            System.out.println("نوع السياره: " + NewData[i].CarType);
            System.out.println(" رقم اللوحة: " + NewData[i].PlateNumber);
            System.out.println(" اسم المالك: " + NewData[i].OwnerName);
            System.out.println(" المشكلة: " + NewData[i].Problem);
            System.out.println(" الحالة: " + NewData[i].Status);
            System.out.println(" التكلفة: " + NewData[i].Cost);
            System.out.println("--------------------------------");
        }
    }

    public void PrintReceiptOfCars(int id) 
 {
    Data car = NewData[id];
    String space = Tabs(3);
     System.out.println("\n\n" + space + "====================================================");
    System.out.println(space + "               [ سـنـد قـبـض ورشـة ]                ");
    System.out.println(space + "====================================================");
    System.out.println(space + " اسم العميل   : " + car.OwnerName);
    System.out.println(space + " رقم اللوحة   : " + car.PlateNumber);
    System.out.println(space + " نوع السيارة  : " + car.CarType);
    System.out.println(space + "----------------------------------------------------");
    System.out.println(space + " التفاصيل:");
    }

    public int CheckCar(int SearchCar, Data NewData[])
    {
        for (int i = 0; i < Index; i++) {
            if (SearchCar == NewData[i].PlateNumber)
            {
                return i;
            }
        }
        return -1;
    }
    
    public void SearchOfCar()
    {
        int Result = CheckCar(ReadPsitiveNumber("ادخل رقم اللوحه:"), NewData);
        if (Result == -1) 
        {
            System.out.println("عذرا لا توجد سيارة في الورشة تحمل هذا الرقم");
        } else {
            PrintReceiptOfCars(Result);
        }
    }
    public void CalculateNumberUnderRepairVSReady(WorkshopDashboard NewD)
    {
       
        for (int i = 0; i < Index; i++) {
            if (NewData[i].Status.equals("قيد الإصلاح")) {
                NewD.NumberOfUnderRepairCars++;
            }else if(NewData[i].Status.equals("جاهزة"))
                NewD.NumberOfReadyCars++;
        }
    }
 public String ChoiceStatus()
 {
    String arrChoiceStatus[]={"قيد الفحص","قيد الإصلاح","جاهزة"};
return arrChoiceStatus[ReadNumberOfRangeFromStartToEnd("1. قيد الفحص، 2. قيد الإصلاح، 3. جاهزة",1,3)-1];
}
    public void EditeData()
    {
        
        int Result = CheckCar(ReadPsitiveNumber("أدخل رقم لوحة السيارة لتحديث حالتها:"), NewData);
        if (Result == -1) 
        {
            System.out.println("عذرا لا توجد سيارة في الورشة تحمل هذا الرقم");
        } else {
            System.out.println("1. نوع السارة\n2. رقم اللوحة\n3. أسم المالك\n4. المشكلة\n5.الحالة\n6.التكلفة");
            System.out.println("مالذي تريد تحديثة");
            int choise = in.nextInt();
            switch (choise) 
            {
                case 1:
                    System.out.println(NewData[Result].CarType);
                    System.out.println("قم بتحديثها:");
                    NewData[Result].CarType = in.next();
                    System.out.println("_________________\nتم التحديث بنجاح");
                    break;
                case 2:
                    System.out.println(NewData[Result].PlateNumber);
                    System.out.println("قم بتحديثها:");
                    NewData[Result].PlateNumber = in.nextInt();
                    System.out.println("_________________\nتم التحديث بنجاح");
                    break;
                case 3:
                    System.out.println(NewData[Result].OwnerName);
                    System.out.println("قم بتحديثها:");
                    NewData[Result].OwnerName = in.next();
                    System.out.println("_________________\nتم التحديث بنجاح");
                    break;
                case 4:
                    System.out.println(NewData[Result].Problem);
                    System.out.println("قم بتحديثها:");
                   Ended(NewData[Result]);
                    System.out.println("_________________\nتم التحديث بنجاح");
                    break;
                case 5:
                    System.out.println(NewData[Result].Status);
                    System.out.println("قم بتحديثها:");
                    NewData[Result].Status = ChoiceStatus();
                    System.out.println("_________________\nتم التحديث بنجاح");
                    break;
                default:
                    System.out.println("عذرا لقد ادخلت خيار غير موجود");
            }
        }
    }
    public void FilterbyStatus(String Status)
    {
   Status=ChoiceStatus();
        for (int i = 0; i < Index; i++) {
            if (NewData[i].Status.equals(Status)) {
                System.out.println(NewData[i].CarType+" : "+NewData[i].Status);
            }
        }
    }
public void SortingCosts()
{
double MaxCost=NewData[0].Cost;
    for (int i = 0; i < Index; i++) 
    {
        for (int j = i+1; j < Index; j++) 
        {
            if (NewData[i].Cost>NewData[j].Cost)
            {
     Data TempData = NewData[i];
     NewData[i]=NewData[j];
     NewData[j]=TempData;
        } 
        }
       
    }
    for (int i = 0; i < Index; i++)
    {
        System.out.println(NewData[i].Cost);
    }
    System.out.println("=================");
    for (int i = 0; i < Index; i++) {
        System.out.println( NewData[i].Cost); 
    }
        System.out.println("=================");
}
    public void DelletCar() 
    {
        int Result = CheckCar(ReadPsitiveNumber("ادخل رقم اللوحه:"), NewData);
        if (Result == -1) 
        {
            System.out.println("عذرا لا توجد سيارة في الورشة تحمل هذا الرقم");
        } else {
            System.out.println("هل أنت متأكد من حذف هذه السيارة؟ ");
            PrintReceiptOfCars(Result);
        
            if (ReadNumberOfRangeFromStartToEnd("1 للقبول نعم  0 للتراجع",0,1)==1)
            {
               for (int i = Result; i < Index - 1; i++)
               {
                NewData[i] = NewData[i + 1];
            }
            Index--; 
                System.out.println("لقد تمت عملية الحذف");
            }else
                System.out.println("لقد تم الغاء عملية الحذف");
            
        }
    }
    public int SearchOfTopCost()
    {
        int IndexOfTopCost=0;
        double MaxCost=NewData[0].Cost;
        for (int i = 1; i < Index; i++) 
        {
            if (NewData[i].Cost>MaxCost) 
            {
                MaxCost=NewData[i].Cost;
                IndexOfTopCost=i;
            }
  
        }
    return IndexOfTopCost;
    }
    public double CalculateAverageCost(int id)
    {
    return (double)NewData[id].Cost/NewData[id].NumberProblemForOneCar;
    }
     public void  ShowDashboard()
     {
         WorkshopDashboard Dashboard=new WorkshopDashboard();
         CalculateNumberUnderRepairVSReady(Dashboard);
     double MaxCost=NewData[0].Cost;
      Dashboard.TotalCosts+=NewData[0].Cost;
     for (int i = 1; i < Index; i++)
     {
    Dashboard.TotalCosts+=NewData[i].Cost;
         if (NewData[i].Cost>MaxCost) 
         {
             MaxCost=NewData[i].Cost;
            Dashboard.TheMostExpensiveCar=NewData[i].OwnerName;
         }
         
     }
          System.out.println("عدد السيارات المتواجده في الورشه حاليا : "+Index);
              System.out.println("عدد السيارات الجاهزة:"+Dashboard.NumberOfReadyCars);
         System.out.println("عدد السيارات قيد الإصلاح :"+Dashboard.NumberOfUnderRepairCars);
     System.out.println("صاحب اعلى تكلفة اصلاح هوا: "+Dashboard.TheMostExpensiveCar);
System.out.println("مجموع تكاليف هذه الجلسه: "+Dashboard.TotalCosts);
         for (int i = 0; i < Index; i++) {
          System.out.println("حساب متوسط تكلفة الإصلاح "+" : "+
                  NewData[i].CarType+" = "+
                  CalculateAverageCost(i));
         }
System.out.println("=================================");
     }
  public void MostExpensiveCar()
  {
      System.out.println("");
  }
    public void Menu() 
    {
        boolean Run = true;
        ReadOfTypeProblems();
        InitializePrices();
        while (Run) 
        {
            System.out.println("1. اضافة سيارة");
            System.out.println("2. تحديث سيارة");
            System.out.println("3. عرض الجميع");
            System.out.println("4. عرض بيانات سيارة");
            System.out.println("5. حذف بيانات سيارة");
              System.out.println("6. ترتيب اعلا تكلفات");
                System.out.println("7. عرض الاسعار");
                  System.out.println("8. التقرير");
            int c = in.nextInt();
            switch (c)
            {
                case 1:
                    AddCars();
                
                break;
                case 2: 
                    EditeData();
                break;
                case 3: 
                    ShowCars();
                break;
                case 4:
                    SearchOfCar(); 
                break;
                case 5:
                    DelletCar(); 
                break;
                case 6: 
                    SortingCosts();
                   // ShowPriceList();
                break;
                case 7: 
                   ShowPriceList();
                break;
                case 8: 
           ShowDashboard();
                    break;
                default: 
                    Run = false;
            }
        }
    }
// public  String Tabs(int num) 
//{
//	String t = "";
//	for (int i = 0; i < num; i++)
//	{
//		t = "\t";
//		t = t + "\t";
//		          System.out.print(t);
//	}
//	return t;
//}
//public void ShowGameOverScreen() 
//{
//	   System.out.println(Tabs(2)+"----------------------------------------------------\n\n");
//	   System.out.println(Tabs(2)+"           +++ G a m e  O v e r +++\n");
//	   System.out.println(Tabs(2)+ "----------------------------------------------------\n\n");
//
//}
//public void ShowFinalGameResults(int id) {
//	   System.out.print(Tabs(2)+"_____________________ [سند قبض ]_____________________\n\n");
//	   System.out.print(Tabs(2)+"    اسم المالك          : "+NewData[id].OwnerName);
//	   System.out.print(Tabs(2) + "نوع السيارة  : " + NewData[id].CarType);
//	   System.out.print(Tabs(2)+ "رقم اللوحه : "+NewData[id].PlateNumber);
//	   System.out.print( Tabs(2)+ "التكلفه       : "+NewData[id].Cost);
//           System.out.print( Tabs(2)+ "المشكلة       : "+NewData[id].Problem);
//           System.out.print( Tabs(2)+ "الحالة       : "+NewData[id].Status);
//	   System.out.print( Tabs(2)+ "__________________________________________________________\n\n");
//	
//}
    public String Tabs(int num) {
    String t = "";
    for (int i = 0; i < num; i++) {
        t += "\t"; 
    }
    return t; 
}
    public void ShowFinalReceipt(int id) {
    Data car = NewData[id];
    String space = Tabs(3); // نستخدم 3 مسافات للدفع لمنتصف الشاشة

    System.out.println("\n\n" + space + "====================================================");
    System.out.println(space + "               [ سـنـد قـبـض ورشـة ]                ");
    System.out.println(space + "====================================================");
    System.out.println(space + " اسم العميل   : " + car.OwnerName);
    System.out.println(space + " رقم اللوحة   : " + car.PlateNumber);
    System.out.println(space + " نوع السيارة  : " + car.CarType);
    System.out.println(space + "----------------------------------------------------");
    System.out.println(space + " التفاصيل:");
    
    // طباعة المشاكل من مصفوفة الـ Records
//    for (int i = 0; i < car.servicesCounter; i++) {
//        System.out.println(space + "  - " + car.myServices[i].description() + " \t " + car.myServices[i].price() + " ريال");
//    }
//    
//    System.out.println(space + "----------------------------------------------------");
//    System.out.println(space + " الإجمالي النهائي : " + car.Cost + " ريال");
//    System.out.println(space + " حالة المركبة     : " + car.Status);
//    System.out.println(space + "====================================================\n");
}
}

public class ParkingManagementSystem 
{
    public static void main(String[] args) throws UnsupportedEncodingException 
    {
        System.setOut(new java.io.PrintStream(System.out, true, "UTF-8"));
    
        
       ManagementSystem system = new ManagementSystem();
       
        system.Menu();
       
    }
}

//package com.school.parkingmanagementsystem;
//import java.io.UnsupportedEncodingException;
//import java.util.Scanner;
// record ServiceDetail(String description, double price) {}
//     record Receipt(int plateNumber, String owner, double finalCost, String date) {}
//  record DashboardSummary(int totalCars, double totalRevenue, String topOwner) {
//}
//class WorkshopDashboard 
//{
//    double TotalCosts;
//    int NumberOfCars;
//    //Data NewDat;
//    String TheMostExpensiveCar;
//   int NumberOfUnderRepairCars;
//   int NumberOfReadyCars;
//}
//
//class Data 
//{
//    int PlateNumber;
//    int ID;
//    String OwnerName;
//    String CarType;
//    String Problem;
//    String Status;
//    double Cost;
//    ServiceDetail[] services = new ServiceDetail[20];
//    int serviceCount = 0;
//    int NumberProblemForOneCar;
//   
//}
//
//class ManagementSystem 
//{
//    // سجل يمثل خدمة واحدة تمت للسيارة
//
//    double Costs[][] = new double[6][3];
//     String problem[] = new String[6 * 3];
//    String WhatisProblem[][] = new String[6][3];
//    String ArrayOfTypeProblem[] = {"مشاكل المحرك", "مشاكل الكهرباء والبطارية", "أعطال نظام نقل الحركة",
//        "مشاكل الفرامل والتعليق",
//        "مشاكل الإطارات والعجلات", "أعطال التكييف ونظام التبريد"};
//     Data NewData[]=new Data[100*2];
//     int Index = 0;
//  public void Check(){
//      if (NewData.length==100) {
//          Data NewData[]=new Data[100*2];
//      }
//  }
//   // Data Da = new Data();
//    Scanner in = new Scanner(System.in);
//
//    public int ReadPsitiveNumber(String Message) {
//        int SearchCar;
//        do {
//            System.out.println(Message);
//            SearchCar = in.nextInt();
//            
//        } while (SearchCar <= 0);
//        return SearchCar;
//    }
// public int ReadNumberOfRangeFromStartToEnd(String Message,int From,int To)
// {
//        int Number;
//        do {
//            System.out.println(Message);
//            Number = in.nextInt();
//            if (Number <From||Number>To) {
//                System.out.println("لقد ادخلت قيمه خاظئة يجب ان يكون ضمن المدى"+From+"الى"+To);
//            }
//        } while (Number <From||Number>To);
//        return Number;
//    }
//
//    public double DiscountLogic(double totalCost) 
//    {
//        return totalCost - (totalCost * 0.15);
//    }
//
//    public void InitializePrices()
//    {
//     Costs[0][0] = 150.0;
//    Costs[0][1] = 100.0;
//    Costs[0][2] = 50.0;
//      Costs[1][0] = 80.0;
//      Costs[1][1] = 40.0;
//       Costs[1][2] = 120.0;
//     Costs[2][0] = 200.0;
//      Costs[2][1] = 250.0;
//      Costs[2][2] = 600.0;
//   Costs[3][0] = 150.0;
//       Costs[3][1] = 300.0;
//      Costs[3][2] = 50.0;
//     Costs[4][0] = 99.0;
//       Costs[4][1] = 47.7;
//       Costs[4][2] = 82.5;
//       Costs[5][0] = 20.9;
//        Costs[5][1] = 59.3;
//       Costs[5][2] = 370.6;
//    }
//    public void ShowPriceList()
//    {
//        System.out.println("=== قائمة خدمات وأسعار الورشة ===");
//        for (int i = 0; i < ArrayOfTypeProblem.length; i++) {
//            System.out.println("\n[" + ArrayOfTypeProblem[i] + "]");
//            for (int j = 0; j < 3; j++) {
//                System.out.println("   - " +WhatisProblem[i][j] + " | السعر: " + Costs[i][j] + " ريال");
//            }
//        }
//        System.out.println("================================");
//        
//    }
//
//    public void ReadOfTypeProblems() 
//    {
//  
//       WhatisProblem[0][0] = "ارتفاع درجة الحرارة";
//       WhatisProblem[0][1] = "استهلاك الزيت";
//       WhatisProblem[0][2] = "تلف شمعات الاحتراق ";
//     WhatisProblem[1][0] = "نفاد البطارية";
//        WhatisProblem[1][1] = "ضعف الأضواء";
//       WhatisProblem[1][2] = "عطل(السلف/الدينامو)";
//       WhatisProblem[2][0] = "صعوبة تغيير السرعات";
//        WhatisProblem[2][1] = "تأخر استجابة الجير الأوتوماتيكي";
//        WhatisProblem[2][2] = "انزلاق النقلات";
//        WhatisProblem[3][0] = "صفير الفرامل";
//        WhatisProblem[3][1] = "ضعف كفاءة التوقف";
//        WhatisProblem[3][2] = "اهتزاز عجلة القيادة";
//        WhatisProblem[4][0] = "تلف الإطارات";
//        WhatisProblem[4][1] = "تسريب الهواء";
//        WhatisProblem[4][2] = " انحراف الاتجاهات";
//        WhatisProblem[5][0] = "تسريب غاز الفريون";
//        WhatisProblem[5][1] = "ضعف البرودة";
//        WhatisProblem[5][2] = " سماع أصوات من كمبروسر التكييف";
//    }
//
//    public int ChoiceTypeProblem(String Message, String Message1, String Message2, String Message3, String Message4, String Message5, String Message6)
//    {
//        System.out.println(Message);
//        System.out.println("1. " + Message1);
//        System.out.println("2. " + Message2);
//        System.out.println("3. " + Message3);
//        System.out.println("4. " + Message4);
//        System.out.println("5. " + Message5);
//        System.out.println("6. " + Message6);
//        System.out.println("____________________________________");
//        System.out.println(" عند الانتهاء من تحديد المشاكل اضغط 0:");
//        int choice = in.nextInt();
//        return choice - 1;
//    }
//
//    public int ChoiceProblemInOneType(String Message, String Message1, String Message2, String Message3)
//    {
//        System.out.println(Message);
//        System.out.println("1. " + Message1);
//        System.out.println("2. " + Message2);
//        System.out.println("3. " + Message3);
//        System.out.println("____________________________________");
//        System.out.println(" عند الانتهاء من تحديد المشاكل اضغط 0:");
//        int choice = in.nextInt();
//        return choice - 1;
//    }
//public void Ended(Data INfo)
//{
//          
//           int CountProblems=0;
//           double totalCost = 0;
//           INfo.serviceCount = 0;
//          int Result=ReadPsitiveNumber("عدد انزاع المشاكل  التي  تواجهها السيارة:");
//           for (int i = 0; i <Result; i++) {
//                int far=ChoiceTypeProblem("نوع المشكلة:","1. "+ArrayOfTypeProblem[0],
//                "2. "+ArrayOfTypeProblem[1],"3. "+ArrayOfTypeProblem[2],"4. "+
//               ArrayOfTypeProblem[3],"5. "+ArrayOfTypeProblem[4],"6. "+
//              ArrayOfTypeProblem[5]);
//         problem[i]=ArrayOfTypeProblem[far]+":";
//          int result2=ReadPsitiveNumber("عدد  المشاكل  التي  تواجهها السيارة من نوع:"+problem[i]);
//               for (int j = 0; j <result2; j++) {
//                  int far2=ChoiceProblemInOneType("نوع المشكلة:","1. "+WhatisProblem[far][0],
//                         "2. "+WhatisProblem[far][1],"2. "+WhatisProblem[far][2]);
//                    String problemName = WhatisProblem[far][far2];
//            double problemPrice = Costs[far][far2];
//            INfo.services[INfo.serviceCount] = new ServiceDetail(problemName, problemPrice);
//            INfo.serviceCount++;
//                
//                    INfo.NumberProblemForOneCar++;
//                    if (j<result2-1) {
//                       problem[i]+="-";
//                   }
//                    CountProblems++;
//                    totalCost+=problemPrice;
//               }
//              
//      }
//           if (CountProblems>3) {
//       INfo.Cost= DiscountLogic(totalCost);
//    }else
//               INfo.Cost=totalCost;
//         // INfo.Problem=;
//      }
//               
//    public String ChoiseProblems(int i)
//    {
//        return WhatisProblem[i][0];
//    }
//
//    public void AddCars()
//    {
//       Data NewCar = new Data();
//         int NewPlateNumber=ReadPsitiveNumber("ادخل رقم اللوحه:");
//         if (CheckCar(NewPlateNumber, NewData)==-1) 
//         {
//            NewCar.PlateNumber = NewPlateNumber;
//        }else{        
//            do{
//            System.out.println("هذه السيارة موجودة مسبقاً"); 
//            }while(CheckCar(ReadPsitiveNumber("ادخل رقم اخر:"), NewData)!=-1);
//         }
//        in.nextLine();
//        System.out.println("نوع السياره: ");
//        NewCar.CarType = in.nextLine(); 
//        System.out.println(" اسم المالك: ");
//        NewCar.OwnerName = in.nextLine();
//        System.out.println(" المشكلة: ");
//        ReadOfTypeProblems();
//        Ended(NewCar);
//         System.out.println(" الحالة: ");
//        NewCar.Status=ChoiceStatus();
//        //NewCar.NumberProblemForOneCar=Da.NumberProblemForOneCar;
//        NewCar.ID=Index+1;
//     //   NewCar.ID=Da.ID;
//         NewData[Index] = NewCar;
//        Index++;
//    }
//    public void ShowCars()
//    {
//        for (int i = 0; i < Index; i++) 
//        {
//            System.out.println("نوع السياره: " + NewData[i].CarType);
//            System.out.println(" رقم اللوحة: " + NewData[i].PlateNumber);
//            System.out.println(" اسم المالك: " + NewData[i].OwnerName);
//            System.out.println(" المشكلة: " + NewData[i].Problem);
//            System.out.println(" الحالة: " + NewData[i].Status);
//            System.out.println(" التكلفة: " + NewData[i].Cost);
//            System.out.println("--------------------------------");
//        }
//    }
//
//    public void PrintDataOfCars(int id) 
// {
//        System.out.println("نوع السياره: " + NewData[id].CarType);
//        System.out.println(" رقم اللوحة: " + NewData[id].PlateNumber);
//        System.out.println(" اسم المالك: " + NewData[id].OwnerName);
//        System.out.println(" المشكلة: " + NewData[id].Problem);
//        System.out.println(" الحالة: " + NewData[id].Status);
//        System.out.println(" التكلفة: " + NewData[id].Cost);
//    }
//
//    public int CheckCar(int SearchCar, Data NewData[])
//    {
//        for (int i = 0; i < Index; i++) {
//            if (SearchCar == NewData[i].PlateNumber)
//            {
//                return i;
//            }
//        }
//        return -1;
//    }
//    
//    public void SearchOfCar()
//    {
//        int Result = CheckCar(ReadPsitiveNumber("ادخل رقم اللوحه:"), NewData);
//        if (Result == -1) 
//        {
//            System.out.println("عذرا لا توجد سيارة في الورشة تحمل هذا الرقم");
//        } else {
//            PrintDataOfCars(Result);
//        }
//    }
//    public void CalculateNumberUnderRepairVSReady(WorkshopDashboard NewD)
//    {
//       
//        for (int i = 0; i < Index; i++) {
//            if (NewData[i].Status.equals("قيد الإصلاح")) {
//                NewD.NumberOfUnderRepairCars++;
//            }else if(NewData[i].Status.equals("جاهزة"))
//                NewD.NumberOfReadyCars++;
//        }
//    }
// public String ChoiceStatus()
// {
//    String arrChoiceStatus[]={"قيد الفحص","قيد الإصلاح","جاهزة"};
//return arrChoiceStatus[ReadNumberOfRangeFromStartToEnd("1. قيد الفحص، 2. قيد الإصلاح، 3. جاهزة",1,3)-1];
//}
//    public void EditeData()
//    {
//        
//        int Result = CheckCar(ReadPsitiveNumber("أدخل رقم لوحة السيارة لتحديث حالتها:"), NewData);
//        if (Result == -1) 
//        {
//            System.out.println("عذرا لا توجد سيارة في الورشة تحمل هذا الرقم");
//        } else {
//            System.out.println("1. نوع السارة\n2. رقم اللوحة\n3. أسم المالك\n4. المشكلة\n5.الحالة\n6.التكلفة");
//            System.out.println("مالذي تريد تحديثة");
//            int choise = in.nextInt();
//            switch (choise) 
//            {
//                case 1:
//                    System.out.println(NewData[Result].CarType);
//                    System.out.println("قم بتحديثها:");
//                    NewData[Result].CarType = in.next();
//                    System.out.println("_________________\nتم التحديث بنجاح");
//                    break;
//                case 2:
//                    System.out.println(NewData[Result].PlateNumber);
//                    System.out.println("قم بتحديثها:");
//                    NewData[Result].PlateNumber = in.nextInt();
//                    System.out.println("_________________\nتم التحديث بنجاح");
//                    break;
//                case 3:
//                    System.out.println(NewData[Result].OwnerName);
//                    System.out.println("قم بتحديثها:");
//                    NewData[Result].OwnerName = in.next();
//                    System.out.println("_________________\nتم التحديث بنجاح");
//                    break;
//                case 4:
//                    Data car = NewData[Result];
//                    
//                    System.out.println(NewData[Result].Problem);
//                    System.out.println("قم بتحديثها:");
//                   Ended(NewData[Result]);
//                    System.out.println("_________________\nتم التحديث بنجاح");
//                    break;
//                case 5:
//                    System.out.println(NewData[Result].Status);
//                    System.out.println("قم بتحديثها:");
//                    NewData[Result].Status = ChoiceStatus();
//                    System.out.println("_________________\nتم التحديث بنجاح");
//                    break;
//                default:
//                    System.out.println("عذرا لقد ادخلت خيار غير موجود");
//            }
//        }
//    }
//    public void FilterbyStatus(String Status)
//    {
//   Status=ChoiceStatus();
//        for (int i = 0; i < Index; i++) {
//            if (NewData[i].Status.equals(Status)) {
//                System.out.println(NewData[i].CarType+" : "+NewData[i].Status);
//            }
//        }
//    }
//public void SortingCosts()
//{
//double MaxCost=NewData[0].Cost;
//    for (int i = 0; i < Index; i++) 
//    {
//        for (int j = i+1; j < Index; j++) 
//        {
//            if (NewData[i].Cost>NewData[j].Cost)
//            {
//     Data TempData = NewData[i];
//     NewData[i]=NewData[j];
//     NewData[j]=TempData;
//        } 
//        }
//       
//    }
//    for (int i = 0; i < Index; i++)
//    {
//        System.out.println(NewData[i].Cost);
//    }
//    System.out.println("=================");
//    for (int i = 0; i < Index; i++) {
//        System.out.println( NewData[i].Cost); 
//    }
//        System.out.println("=================");
//}
//    public void DelletCar() 
//    {
//        int Result = CheckCar(ReadPsitiveNumber("ادخل رقم اللوحه:"), NewData);
//        if (Result == -1) 
//        {
//            System.out.println("عذرا لا توجد سيارة في الورشة تحمل هذا الرقم");
//        } else {
//            System.out.println("هل أنت متأكد من حذف هذه السيارة؟ ");
//            PrintDataOfCars(Result);
//        
//            if (ReadNumberOfRangeFromStartToEnd("1 للقبول نعم  0 للتراجع",0,1)==1)
//            {
//               for (int i = Result; i < Index - 1; i++)
//               {
//                NewData[i] = NewData[i + 1];
//            }
//            Index--; 
//                System.out.println("لقد تمت عملية الحذف");
//            }else
//                System.out.println("لقد تم الغاء عملية الحذف");
//            
//        }
//    }
//    public int SearchOfTopCost()
//    {
//        int IndexOfTopCost=0;
//        double MaxCost=NewData[0].Cost;
//        for (int i = 1; i < Index; i++) 
//        {
//            if (NewData[i].Cost>MaxCost) 
//            {
//                MaxCost=NewData[i].Cost;
//                IndexOfTopCost=i;
//            }
//  
//        }
//    return IndexOfTopCost;
//    }
//    public double CalculateAverageCost(int id)
//    {
//    return (double)NewData[id].Cost/NewData[id].NumberProblemForOneCar;
//    }
//     public void  ShowDashboard()
//     {
//         WorkshopDashboard Dashboard=new WorkshopDashboard();
//         CalculateNumberUnderRepairVSReady(Dashboard);
//     double MaxCost=NewData[0].Cost;
//      Dashboard.TotalCosts+=NewData[0].Cost;
//     for (int i = 1; i < Index; i++)
//     {
//    Dashboard.TotalCosts+=NewData[i].Cost;
//         if (NewData[i].Cost>MaxCost) 
//         {
//             MaxCost=NewData[i].Cost;
//            Dashboard.TheMostExpensiveCar=NewData[i].OwnerName;
//         }
//         
//     }
//          System.out.println("عدد السيارات المتواجده في الورشه حاليا : "+Index);
//              System.out.println("عدد السيارات الجاهزة:"+Dashboard.NumberOfReadyCars);
//         System.out.println("عدد السيارات قيد الإصلاح :"+Dashboard.NumberOfUnderRepairCars);
//     System.out.println("صاحب اعلى تكلفة اصلاح هوا: "+Dashboard.TheMostExpensiveCar);
//System.out.println("مجموع تكاليف هذه الجلسه: "+Dashboard.TotalCosts);
//         for (int i = 0; i < Index; i++) {
//          System.out.println("حساب متوسط تكلفة الإصلاح "+" : "+
//                  NewData[i].CarType+" = "+
//                  CalculateAverageCost(i));
//         }
//System.out.println("=================================");
//     }
//  public void MostExpensiveCar()
//  {
//      System.out.println("");
//  }
//    public void Menu() 
//    {
//        boolean Run = true;
//        ReadOfTypeProblems();
//        InitializePrices();
//        while (Run) 
//        {
//            System.out.println("1. اضافة سيارة");
//            System.out.println("2. تحديث سيارة");
//            System.out.println("3. عرض الجميع");
//            System.out.println("4. عرض بيانات سيارة");
//            System.out.println("5. حذف بيانات سيارة");
//              System.out.println("6. ترتيب اعلا تكلفات");
//                System.out.println("7. عرض الاسعار");
//                  System.out.println("8. التقرير");
//            int c = in.nextInt();
//            switch (c)
//            {
//                case 1:
//                    AddCars();
//                
//                break;
//                case 2: 
//                    EditeData();
//                break;
//                case 3: 
//                    ShowCars();
//                break;
//                case 4:
//                    SearchOfCar(); 
//                break;
//                case 5:
//                    DelletCar(); 
//                break;
//                case 6: 
//                    SortingCosts();
//                   // ShowPriceList();
//                break;
//                case 7: 
//                   ShowPriceList();
//                break;
//                case 8: 
//           ShowDashboard();
//                    break;
//                default: 
//                    Run = false;
//            }
//        }
//    }
// public  String Tabs(int num) 
//{
//	String t = "";
//	for (int i = 0; i < num; i++)
//	{
//		t = "\t";
//		t = t + "\t";
//		          System.out.print(t);
//	}
//	return t;
//}

//public void ShowGameOverScreen() 
//{
//	   System.out.println(Tabs(2)+"----------------------------------------------------\n\n");
//	   System.out.println(Tabs(2)+"           +++ G a m e  O v e r +++\n");
//	   System.out.println(Tabs(2)+ "----------------------------------------------------\n\n");
//
//}
//public void ShowFinalGameResults(int id) {
//	   System.out.print(Tabs(2)+"_____________________ [سند قبض ]_____________________\n\n");
//	   System.out.print(Tabs(2)+"    اسم المالك          : "+NewData[id].OwnerName);
//	   System.out.print(Tabs(2) + "نوع السيارة  : " + NewData[id].CarType);
//	   System.out.print(Tabs(2)+ "رقم اللوحه : "+NewData[id].PlateNumber);
//	   System.out.print( Tabs(2)+ "التكلفه       : "+NewData[id].Cost);
//           System.out.print( Tabs(2)+ "المشكلة       : "+NewData[id].Problem);
//           System.out.print( Tabs(2)+ "الحالة       : "+NewData[id].Status);
//	   System.out.print( Tabs(2)+ "__________________________________________________________\n\n");
//	
//}
//}
