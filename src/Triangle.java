import lejos.nxt.*; 

public class Triangle
{
      public static void main(String[] args)
      {
       //declaring the variables
       int pwrleft;
       int pwrright;
       MotorPort motorL;
       MotorPort motorR;
       double rWheel = 2.9;
       double cWheels = 2*Math.PI*rWheel;
       double cmInTacho = 360/cWheels;
       
       //initializing the variables
       pwrleft = 75;
       pwrright = 75;
       motorR = MotorPort.A;
       motorL = MotorPort.B;
       
       //reseting the tachocounter
       MotorPort.B.resetTachoCount(); 
       MotorPort.A.resetTachoCount();
       
       //LCD clear and "press to start"
       LCD.drawString("Press any key", 0, 0);
       Button.waitForAnyPress();
       LCD.clear();
       
       //moving forward 60 cm
       
      while(motorL.getTachoCount()< 60*cmInTacho) {
         while(motorL.getTachoCount() < 60*cmInTacho)
         {
           if ((motorL.getTachoCount() < 60*cmInTacho) && 
                 (motorR.getTachoCount() < 60*cmInTacho))
           { motorL.controlMotor(pwrleft, 1);
           motorR.controlMotor(pwrright, 1);}
           else
           {  motorR.controlMotor(0, 3);
           motorL.controlMotor(0, 3);}
         }
            motorL.controlMotor(pwrleft, 1);
          motorR.controlMotor (pwrright, 1);
       }
       
       //reseting the tachocounter
         MotorPort.B.resetTachoCount(); 
         MotorPort.A.resetTachoCount();
       
       //turning 107.45 deg counter-clockwise
       while (motorR.getTachoCount()  < 10.5*cmInTacho){
          
          motorL.controlMotor(pwrleft, 2);
          motorR.controlMotor(pwrright, 1);
       }
       
       //reseting the tachocounter
          MotorPort.B.resetTachoCount(); 
          MotorPort.A.resetTachoCount();
       
       //moving 100 cm forward
          while(motorL.getTachoCount()< 100*cmInTacho) {
             while(motorL.getTachoCount() < 100*cmInTacho)
          {
             if (motorL.getTachoCount() < 100*cmInTacho)
             { motorL.controlMotor(pwrleft, 1);}
             else
             {  motorR.controlMotor(0, 3);}
             if (motorR.getTachoCount() < 100*cmInTacho)
             {motorR.controlMotor(pwrright, 1);}
             else 
             {motorL.controlMotor(0, 3);}
          }
          motorL.controlMotor(pwrleft, 1);
          motorR.controlMotor (pwrright, 1);
       }
       
       //reseting the tachocounter
          MotorPort.A.resetTachoCount();
          MotorPort.B.resetTachoCount();
       
       //turning 145.1 deg counter-clockwise
       while (motorR.getTachoCount() < 14.18*cmInTacho){
          
          motorL.controlMotor(pwrleft, 2);
          motorR.controlMotor(pwrright, 1);
       }
       
       //reseting the tachocounter
       MotorPort.A.resetTachoCount();
       MotorPort.B.resetTachoCount();
      
       //moving 100 cm forward
      while(motorL.getTachoCount()< 100*cmInTacho) {
         while(motorL.getTachoCount() < 100*cmInTacho)
         {
           if (motorL.getTachoCount() < 100*cmInTacho)
            { motorL.controlMotor(pwrleft, 1);}
            else
            {  motorR.controlMotor(0, 3);}
            if (motorR.getTachoCount() < 100*cmInTacho)
            {motorR.controlMotor(pwrright, 1);}
            else 
            {motorL.controlMotor(0, 3);}
         }
         motorL.controlMotor(pwrleft, 1);
         motorR.controlMotor(pwrright, 1);
      }
      
      //reseting the tachocounter
      MotorPort.A.resetTachoCount();
      MotorPort.B.resetTachoCount();
      
      //turning 107.45 deg counter-clockwise
      while (motorR.getTachoCount() < 10.5*cmInTacho){
         
         motorL.controlMotor(pwrleft, 2);
         motorR.controlMotor(pwrright, 1);
      }
      
      
   } 
}

