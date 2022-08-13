
import lejos.nxt.*;



public class Menu
{
   FollowWall handin1 = new FollowWall();
   
   MotorPort motorL = MotorPort.A;
   MotorPort motorR= MotorPort.B;
   double rWheel = 2.9;
   double cWheels = 2*Math.PI*rWheel;
   double cmInTacho = 360/cWheels;
   
   public void moveForward(int move)
   {
   MotorPort.B.resetTachoCount(); 
   MotorPort.A.resetTachoCount();
   
   
   while(motorL.getTachoCount()< move*cmInTacho) {
      while(motorL.getTachoCount() < move*cmInTacho)
      {
        if ((motorL.getTachoCount() < move*cmInTacho) && 
              (motorR.getTachoCount() < move*cmInTacho))
        { motorL.controlMotor(75, 1);
        motorR.controlMotor(75, 1);}
        else
        {  motorR.controlMotor(0, 3);
        motorL.controlMotor(0, 3);}
      }
         motorL.controlMotor(75, 1);
       motorR.controlMotor (75, 1);
    }
   }
   
   public void turnAnyDegree(int degree)
   {
      MotorPort.A.resetTachoCount();
      MotorPort.B.resetTachoCount();
      while (motorR.getTachoCount()  < degree*cmInTacho){
         
         motorL.controlMotor(75, 2);
         motorR.controlMotor(75, 1);
      }
   }
   
   public void turnBothWheels(int degreeBoth)
   {
      MotorPort.A.resetTachoCount();
      MotorPort.B.resetTachoCount();
      while (motorR.getTachoCount() < degreeBoth * cmInTacho)
      {
         motorL.controlMotor(65, 1);
         motorR.controlMotor(85, 1);
      }
   }
   
   public void readDistance(int sonicDistance)
   {
      UltrasonicSensor ultrasonic;
      ultrasonic = new UltrasonicSensor(SensorPort.S1);
      boolean now = false;
      
      while(!now)
         {
         if (motorL.getTachoCount() < sonicDistance * cmInTacho)
         {
            motorL.controlMotor(75, 1);
         }
         else 
         {
            motorL.controlMotor(0,  3);
         }
         
         if (motorR.getTachoCount() < sonicDistance * cmInTacho)
         {
            motorR.controlMotor(75, 1);
         }
         
         LCD.clear();
         LCD.drawString("Distance: " + ultrasonic.getDistance(), 0, 0);
         }
   }
   
   public static void main(String[] args) throws InterruptedException
   {      
      Menu press = new Menu();
      int menu = 1;
      
      boolean flag = false;
      while (true)
      {
         if (menu == 1)
         {
            LCD.drawString("Menu 1 ", 0, 0);
            while (Button.ENTER.isDown())
            {
               press.moveForward(50);
            }
         }
         else if (menu == 2)
         {
            LCD.drawString("Menu 2 ", 0, 0);
            while (Button.ENTER.isDown())
            {
               press.turnAnyDegree(30);
            }
         }
         else if (menu == 3)
         {
            LCD.drawString("Menu 3 ", 0, 0);
            while (Button.ENTER.isDown())
            {
               press.turnBothWheels(50);
            }
         }
         else if (menu == 4)
         {
            LCD.drawString("Menu 4 ", 0, 0);
            press.readDistance(50);
            
         }
         else if (menu == 0 || menu > 3)
         {
            LCD.drawString("Menu 1 ", 0, 0);
         }
         if(Button.RIGHT.isDown() && flag == false)
         {
            menu++;
            while(Button.RIGHT.isDown())
            {}
         }
         if(Button.LEFT.isDown() && flag == false)
         {
            menu--;
            while(Button.LEFT.isDown())
            {}
         }
      }
      
   }

}
