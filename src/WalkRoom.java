import lejos.nxt.*;

public class WalkRoom
{
   public static void main(String[] args) throws InterruptedException
   {
      //Declaring and initializing variables
      int pwrleft = 75;
      int pwrright = 75;
      double tacos = 999999999.0;
      MotorPort motorL = MotorPort.B;
      MotorPort motorR = MotorPort.A;
      UltrasonicSensor sonic = new UltrasonicSensor(SensorPort.S1);
      motorL.resetTachoCount();
      motorR.resetTachoCount();
      Button.waitForAnyPress();
      
      while (true)
      {
         motorL.resetTachoCount();
         motorR.resetTachoCount();
         
         if(sonic.getDistance() > 30)
         {
            while(motorL.getTachoCount() < 10)
            {
               if (motorL.getTachoCount() < tacos)
               { motorL.controlMotor(pwrleft, 1);}
               else
               {  motorR.controlMotor(0, 3);}
               if (motorR.getTachoCount() < tacos)
               {motorR.controlMotor(pwrright, 1);}
               else 
               {motorL.controlMotor(0, 3);}
            }
         }
         else 
         {
            motorL.controlMotor(75, 2);
            motorR.controlMotor(0 , 3);
         }
      }
   }

}
