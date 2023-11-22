package IEstateAgent;

//Interface showing the what the estate agent does 
 interface IEstateAgent{
    double estateAgentSales(double[] propertySales);
    double estateAgentCommission(double propertySales);
    int topEstateAgent(double[] totalSales);
    //(From the exam paper)
   
}
//Abstarct class implementing the IEstateAgent interface with normal action
abstract class EstateAgent implements IEstateAgent{
    
    //Calculate total property sales for the Agents 
    @Override
    public double estateAgentSales(double[] propertySales){
        double totalSales = 0;
        for(double sale : propertySales){
            totalSales += sale;
            
            //(Farrell, 2019)
        }
        //adds all the amounts and returns the totalsales 
        return totalSales;
    }
    
    //this method calculates the commission of each agent based on their total sale 
    
    @Override
    public double estateAgentCommission(double propertySales){
        return propertySales * 0.02; // Commission is 2% 
    }
    
   //this method compares both the agents totalsales and determines the top performing agent 
    
    @Override 
    public int topEstateAgent(double[] totalSales){
        int topAgentIndex = 0;
        double allSales = totalSales[0];
        
        for (int i = 1; i < totalSales.length; i++) {
            if (totalSales[i] > allSales) {
                allSales = totalSales[i];
                topAgentIndex = i;
                
                //(Farrell, 2019)
            }
            
        }
        return topAgentIndex;
    }
}

//Main class 
public class MainApplication {

    public static void main(String[] args) {
        // Creating a 2D array containing the property sales
     
        double[][] propertySales = {
                {800000, 1500000, 2000000},
                {700000, 1200000, 1600000}
        };//(Farrell, 2019)

        //instance created fo the EstateAgent class 
        IEstateAgent estateAgent = new EstateAgent() {};//(Farrell, 2019)

        //String builder used to create the report as it displays with out any square or curly brackets
        StringBuilder report = new StringBuilder();

           double totalSalesJoeBloggs = estateAgent.estateAgentSales(propertySales[0]);
            double commissionJoeBloggs = estateAgent.estateAgentCommission(totalSalesJoeBloggs);

            double totalSalesJaneDoe = estateAgent.estateAgentSales(propertySales[1]);
            double commissionJaneDoe = estateAgent.estateAgentCommission(totalSalesJaneDoe);
        
        // Calculate and print total property sales and commission for each estate agent
        
        
        // i tried using a for loop which gave me a problem that it was printing the report twice with the same infomation
        
        
    //    for (int i = 0; i < propertySales.length;i++) {
           
    
              //using "append" to append information to the report  
             // Report calculating  and printing  total property sales and commission for each estate agent , this report also displays  the agent that earned the most commission
            report.append("\n")
                    .append("                  JAN    ").append("        FEB   ").append("           MAR   ").append("\n")
                    .append("--------------------------------------------------------------------").append("\n")
                    .append("Joe Bloggs").append("\t").append(propertySales[0][0]).append("\t").append(propertySales[0][1]).append("\t").append(propertySales[0][2]).append("\n")
                    .append("Jane Doe").append("\t").append(propertySales[1][0]).append("\t").append(propertySales[1][1]).append("\t").append(propertySales[1][2]).append("\n")
                    .append("\n")
                    .append("Total property sales for Joe Bloggs").append(" =  R ").append(totalSalesJoeBloggs).append("\n")
                    .append("Total property sales for Jane Doe").append(" =  R ").append(totalSalesJaneDoe).append("\n")
                    .append("\n")
                    .append("Sales Commission for Joe Bloggs").append(" =  R ").append(commissionJoeBloggs).append("\n")
                    .append("Sales Commission for Jane Doe").append(" =  R ").append(commissionJaneDoe).append("\n")
                    .append("\n")
                    .append("Top performing estate agent: ").append(totalSalesJoeBloggs > totalSalesJaneDoe ? "Joe Bloggs" : "Jane Doe");
            
        
        
        // console print report 
        System.out.println(report.toString());
      
    }
}

/*
Reference:

Farrell, J. (2019) Java Programming (Version 9) [Computer program]

W3schools (2023). Java Interface () [Computer Program] 
Available at https://www.w3schools.com/java/java_interface.asp
(Accessed 22 November 2023).

PROG6112 adapted from by Fatima Sheik (PROG workshop video on teams)

*/




































//public class ESTATE_AGENT_SALES_REPORT{

//
  //  public static void main(String[] args) {
//        
//       
//
     //Creating a 2D Array containing the property prices 
   
   //    double[][] Propertysales = {     {800000, 1500000, 2000000}, {700000, 1200000, 1600000}   };
//       
//      double sum = 0;
//      double sum1 = 0;
//
    //   public static void Report(Agents, Propertysales){
//       StringBuilder report = new StringBuilder();
//       
//        for (int i= 0; i < Agents.length; i++) {
//            
//            report.append(" JAN    ").append("  FEB   ").append("  MAR   ").append("\n")
//                        .append("---------------------------------------------------------------------------------------------------------").append("\n")
//                        .append(Agents[i][0]).append(Propertysales[i][0]).append(Propertysales[i][1]).append(Propertysales[i][2]).append("\n")
//                        .append(Agents[i][1]).append(Propertysales[i][0]).append(Propertysales[i][1]).append(Propertysales[i][2]).append("\n")
//                        .append("\n")
//                        .append("Total property sales for ").append(Agents[i][0]).append(" =  R ").append(sum += Propertysales[i][0]).append("\n")
//                        .append("Total property sales for ").append(Agents[i][1]).append(" =  R ").append(sum1 += Propertysales[i][1]).append("\n")
//                        .append("\n")
//                        .append("Sales Commission for ").append(Agents[0][i]).append(" =  R ").append(calculateCommission(sum)).append("\n")
//                        .append("Sales Commission for ").append(Agents[1][i]).append(" =  R ").append(calculateCommission(sum1)).append("\n")
//                        .append("\n")
//                        .append("Top performing estate agent: ").append(Agents[0][i]);
////       for (int i = 0; i < Agents.length; i++) {
////            report.append(" JAN    ").append("  FEB   ").append("  MAR   ").append("\n")
////                    .append("---------------------------------------------------------------------------------------------------------").append("\n")
////                    .append(Agents[i][0]).append("  ").append(Propertysales[i][0]).append("  ").append(Propertysales[i][1]).append("  ").append(Propertysales[i][2]).append("\n")
////                    .append("\n")
////                    .append("Total property sales for ").append(Agents[i][0]).append(" =  R ").append(sum += Propertysales[i][0] + Propertysales[i][1] + Propertysales[i][2]).append("\n")
////                    .append("\n")
////                    .append("Sales Commission for ").append(Agents[i][0]).append(" =  R ").append(calculateCommission(sum)).append("\n")
////                    .append("\n")
////                    .append("Top performing estate agent: ").append(Agents[i][0])
////                    .append("\n");
//
//}
//        System.out.println(report.toString());
//}
//    
//    static double calculateCommission(double totalSales){
//        
//        
//        return totalSales * 0.02;
//    }
//}
    


//
// double total = calculateSum(Propertysales);
//       
//       static double calculateSum(double[][] array){
//           double sum = 0;
//           
//           for (int i = 0; i < array.length; i++) {
//               for (int j = 0; j < array[i].length; j++) {
//                   sum += array[i][j];
//               }
//           }
//       return sum;
//       }