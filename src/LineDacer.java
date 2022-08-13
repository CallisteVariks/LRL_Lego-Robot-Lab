import lejos.nxt.*;

public class LineDacer
{
   public static void main(String[] args) throws InterruptedException
   {
      OptimusPrime optimus = new OptimusPrime();
      MotorPort ML = MotorPort.B;
      MotorPort MR = MotorPort.A;
      LightSensor light = new LightSensor(SensorPort.S1);
      int [] arr = new int[100];
      int j = 0;
      int pwr = 0;
      int menu = 1;
      boolean flag = true;
      
      while(flag)
      {
         if(Button.RIGHT.isDown())
         {
            LCD.clear();
            if (menu == 3)
            {menu = 1;}
            else
            {menu++;}
            
            while (Button.RIGHT.isDown())
            {;}
            
            if (Button.LEFT.isDown())
            {
               LCD.clear();
               if (menu == 1)
               {menu = 3;}
               else
               {menu--;}
               
               while (Button.LEFT.isDown())
               {;}
            }
            if (menu == 1)
            {
               LCD.drawString("Slow", 1, 1);
               LCD.drawString("POwer: 70", 1, 3);
               if (Button.ENTER.isDown())
               {
                  pwr = 70;
                  while(Button.ENTER.isDown())
                  {;}
               break;
               }
            }
            
            if (menu == 2)
            {
               LCD.drawString("Medium", 1, 1);
               LCD.drawString("Power: 80", 1, 3);
               if (Button.ENTER.isDown())
               {
                  pwr = 80;
                  while(Button.ENTER.isDown())
                  {;}
               break;
               }
            }
            
            if (menu == 3)
            {
               LCD.drawString("Fast", 1, 1);
               LCD.drawString("Power: 90", 1, 3);
               if (Button.ENTER.isDown())
               {
                  pwr = 90;
                  while(Button.ENTER.isDown())
                  {;}
               break;
               }
            }
         }
      }
         
      
         LCD.clear();  
         LCD.drawString("Place on black", 1, 1);         
         Button.waitForAnyPress();
         light.calibrateLow();
         LCD.clear();
         
         LCD.drawString("Place on white", 1, 1);
         Button.waitForAnyPress();
         light.calibrateHigh();
         LCD.clear();
      
         LCD.drawString("GO!", 1, 1);
         Button.waitForAnyPress();
      
         LCD.clear();
      
         while(!(Button.ESCAPE.isDown()))
         {
            optimus.resetCount();
         
            while(light.getLightValue() < 20)
            {
               optimus.forward();
            }
            optimus.stop();
            arr[j] = MR.getTachoCount() + 100;
            j++;
         
            optimus.resetCount();
         
            while(light.getLightValue() >= 20 && MR.getTachoCount() < 80)
            {
               MR.controlMotor(90, 2);
               ML.controlMotor(90, 1);
            }
         
            optimus.stop();
            optimus.resetCount();
         
            while(light.getLightValue() >= 20 && MR.getTachoCount() < 160)
            {
               Sound.playNote(Sound.FLUTE, 20, 100);
               MR.controlMotor (90, 1);
               ML.controlMotor (90, 2);
            }
            optimus.resetCount();
         
            if (light.getLightValue() >= 20)
            {
               optimus.stop();
            
               for(int i = 0; i < j; i++)
               {
                  Sound.playNote(Sound.PIANO, arr[i], 100);
               }
               break;
            }
         }
      }
      
      
}
