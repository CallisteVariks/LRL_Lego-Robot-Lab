import lejos.nxt.*;


public class MovingForward
{

   public static void main(String[] args) throws InterruptedException
   {
   // declaring and initializing the variables
      int pwrleft = 75;
      int pwrright = 75;
      MotorPort ML = MotorPort.B;
      MotorPort MR = MotorPort.A;
      double rWheel = 2.9;
      double dWheels = 11.2;
      double cWheel = 2* Math.PI * rWheel; 
      double cmInTacho = 360/cWheel;
      double halfRotation = dWheels/2 * Math.PI * 2 / 2 ;  
      double rightAngle= (halfRotation * cmInTacho)/2;
      
      //reseting the tacho-counter
      MotorPort.B.resetTachoCount();
      MotorPort.A.resetTachoCount();
      
      //LCD clearing and "press to start"
      LCD.drawString("Press to start", 0, 0);
      Button.waitForAnyPress();
      LCD.clear();
      
      //moving forward 20 cm
      while(ML.getTachoCount() < 20*cmInTacho)
      {
         if((ML.getTachoCount() < 20*cmInTacho) && MR.getTachoCount() < 20*cmInTacho)
         {
            ML.controlMotor(pwrleft, 1);
            MR.controlMotor(pwrright, 1);
         }
         else 
         {
            MR.controlMotor(0, 3);
            ML.controlMotor(0, 3);
         }
         ML.controlMotor(pwrleft, 1);
         MR.controlMotor(pwrright, 1);
      }
      //reseting the tacho-counter
      MotorPort.B.resetTachoCount();
      MotorPort.A.resetTachoCount(); 
   }

}
