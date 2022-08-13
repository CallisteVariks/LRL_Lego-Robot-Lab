import lejos.nxt.*;


public class SquareExercise
{

         public static void main(String[] args) throws InterruptedException
         {
            int pwrleft;
            int pwrright;
            MotorPort motorleft;
            MotorPort motorright;
            
            pwrleft = 75;
            pwrright = 75;
            motorleft = MotorPort.B;
            motorright = MotorPort.C;
            
            UltrasonicSensor ultrasonic;
            ultrasonic = new UltrasonicSensor(SensorPort.S1);
            
            LCD.clear();
            LCD.drawString("Press any key", 0, 0);
            
            int tacho = 1;
            boolean now = false;
            
            while(!now)
               {
               motorleft.resetTachoCount();
               motorright.resetTachoCount();
               
               if ((motorleft.getTachoCount() < tacho * 90) 
                     && (motorright.getTachoCount() > tacho * 90))
               {
                  motorleft.controlMotor(pwrleft, 1);
                  motorright.controlMotor(pwrright, 1);
               }
               else if ((motorleft.getTachoCount() < tacho * 60)
                     && (motorright.getTachoCount() > tacho * 60))
               {
                  motorleft.controlMotor(0,  3);
               }
               
             
               else
               {
                  now = true;
                  motorright.controlMotor(0, 3);
                  motorleft.controlMotor(0, 3);
               }
               
               
           }      
         }

      
      
   }
