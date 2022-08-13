import lejos.nxt.*;

public class Square2
{
   public static void main(String[] args) throws InterruptedException
   {
      int pwrleft; // Power to left motor
      int pwrright; // Power to right motor
      MotorPort motorleft; // Object representing left motor
      MotorPort motorright; // Object representing right motor
  
      // Initializing variables
      pwrleft = 75;
      pwrright = 75;
      motorleft = MotorPort.B;
      motorright = MotorPort.C;


      MotorPort.B.resetTachoCount();
      MotorPort.C.resetTachoCount();


      int tachoCountOneCentimeter = 1;
      motorleft.resetTachoCount();
      motorright.resetTachoCount();
      boolean now = false;

      while (!now)
      {
         if (motorleft.getTachoCount() < tachoCountOneCentimeter * 50)
         {
            motorleft.controlMotor(pwrleft, 1);
         }
         else
         {
            motorleft.controlMotor(0, 3);
         }

         if (motorright.getTachoCount() < tachoCountOneCentimeter * 50)
         {
            motorright.controlMotor(pwrright, 1);
         }
         else
         {
            motorright.controlMotor(0, 3);
         }

         if ((motorleft.getTachoCount() > tachoCountOneCentimeter * 50)
               && (motorright.getTachoCount() > tachoCountOneCentimeter * 50))
         {
            now = true;
         }
      }

   }
}
