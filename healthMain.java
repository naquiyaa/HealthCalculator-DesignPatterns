
//Naquiya Asghar 
//factory pattern
import java.util.Scanner;

//defining interface for factory class

interface HealthAppCalculator {
  double convertKgToPounds(double kg);
  double convertPoundstoKG(double pounds);
  double calculateBMI(double weight, double height);
  double calculateBMR(int age, double weight, double height, String gender);
 
}

//concrete class
class DefaultCalc implements HealthAppCalculator {
  
  public double calculateBMI(double weight, double height) {
      return Math.round(weight / (height * height));
  }

  // bmr calculation based on gender
  public double calculateBMR(int age, double weight, double height, String gender) {
    String genderFormatted = gender.toLowerCase();
    System.out.println(genderFormatted);
    if(genderFormatted.equals("female")){
      return Math.round((9.6 * weight + 1.8 * height - 4.7 * age + 655)*100)/100;
    }
    else if(genderFormatted.equals("male")){
      return Math.round((13.75 * weight + 5 * height - 6.76 * age + 66)*100)/100;
    }
    return 0;
  }

  
  public double convertKgToPounds(double kg) {
      return Math.round((kg / 0.453592)*100)/100;
  }

  
  public double convertPoundstoKG(double pounds) {
      return pounds * 0.453592;
  }
}


class HealthApp {
  private HealthAppCalculator calculator;

  public HealthApp() {
      this.calculator = new DefaultCalc();
  }
  public double convertKgToPounds(double kg) {
    return calculator.convertKgToPounds(kg);
}

public double convertPoundstoKG(double pounds) {
    return calculator.convertPoundstoKG(pounds);
}

  public double calculateBMI(double weight, double height) {
      return calculator.calculateBMI(weight, height);
  }

  public double calculateBMR(int age, double weight, double height, String gender) {
      return calculator.calculateBMR(age, weight, height, gender);
  }

  
}


public class healthMain {
  public static void main(String[] args) {
      HealthApp data = new HealthApp();

      Scanner scanner = new Scanner(System.in);
      System.out.print("Enter your name: ");
      String name = scanner.next();

        System.out.print("Enter your weight in Kg: ");
        double weightInKgs = scanner.nextDouble();

        System.out.print("Enter your height in m: ");
        double heightinM = scanner.nextDouble();

        System.out.print("Enter your age: ");
        int age = scanner.nextInt();

        System.out.print("What's your gender?: ");
        String gender = scanner.next();

      // String name = "ali";
      // double weightInKgs = 60.0;
      // double heightinM = 1.65;
      // int age = 30;
      // String gender = "male";

      double BMIValue = data.calculateBMI(weightInKgs, heightinM);
      double BMRValue = data.calculateBMR(age, weightInKgs, heightinM, gender);
      double weightInPounds = data.convertKgToPounds(weightInKgs);
      double weightInKgAgain = data.convertPoundstoKG(weightInPounds);

      System.out.println("Hello, " + name + "! These are your health details: ");
      System.out.println("BMI: " + BMIValue);
      System.out.println("BMR: " + BMRValue);
      System.out.println("Weight (kg): " + weightInKgs);
      System.out.println("Converting Weight in pounds (pounds): " + weightInPounds);
      System.out.println("Converting Weight in kg: " + weightInKgAgain);
  }
}
