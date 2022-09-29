import java.util.Scanner;
class UnitConverter{
    public static float converter (float fromNum, String fromUnit, String toUnit){
        float result = 0;
        boolean err = false;
        switch (fromUnit){
            case "in":
            case "inches":
                switch (toUnit){
                    case "mm":
                        result = (float) (fromNum * 25.4);
                        break;
                    case "cm":
                        result = (float) (fromNum * 2.54);
                        break;
                    default:
                        System.out.println("Error");
                        err = true;
                        break;
                }
                break;


            case "gal":
            case "gallons":
            case "gallon":
                switch (toUnit){
                    case "qt":
                        result = fromNum * 4;
                        break;
                    case "pt":
                        result = fromNum * 8;
                        break;
                    case "cup":
                    case "cups":
                        result = fromNum * 16;
                        break;
                    default:
                        System.out.println("Error");
                        err = true;   
                        break;  
                }
                break;


            case "cup":
            case "cups":
            case "cp":
                switch (toUnit){
                    case "gal":
                    case "gallon":
                    case "gallons":
                        result = (float)(fromNum * 0.0625);
                        break;
                    case "pt":
                    case "pint":
                    case "pints":
                        result = (float)(fromNum * 0.5);
                        break;
                    case "qt":
                    case "quart":
                    case "quarts":
                        result = (float) (fromNum * 0.25);
                        break;
                    default:
                        System.out.println("Error");
                        err = true;   
                        break;  
                }
                break;

            case "qt":
            case "quart":
                switch (toUnit){
                    case "gal":
                        result = fromNum * 25 / 100;
                        break;
                    case "pt":
                        result = fromNum * 2;
                        break;
                    case "cups":
                        result = fromNum * 4;      
                    default:
                        System.out.println("Error");
                        err = true;
                        break;
                }
                break;


            default:
                System.out.println("Error");
                err = true;
                break;  
                
            


        }
        if (err == false){
            System.out.printf("%.2f %s = %.2f %s%n", fromNum, fromUnit, result, toUnit);
        }
        
        return result;

    }

}
public class Conversion {
    
    
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("Please enter a conversion. EX: 1 gal = pt, 1 pt = gal or exit" );
            String str;
            str = input.nextLine();
            str = str.toLowerCase();
            if (str.equals("exit")){
                break;
            }
            String[] sa;
            sa = str.split(" ");
            if (sa.length == 4){   
                String fromNum = sa[0];
                String fromUnit = sa[1];
                String toUnit = sa[3];
                float fromVal = Float.parseFloat(fromNum);
                UnitConverter.converter(fromVal,fromUnit,toUnit);
            }

            else{
                System.out.println("Invalid input, please try again.");
            }
            
        }
        input.close();
    }
}
