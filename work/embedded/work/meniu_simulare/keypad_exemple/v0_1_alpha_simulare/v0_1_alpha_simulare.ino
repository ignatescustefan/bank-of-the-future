#include <LiquidCrystal_I2C.h>
#include <Keypad.h>

LiquidCrystal_I2C lcd(0x27, 20, 4);

const byte ROWS = 4; //four rows
const byte COLS = 3; //three columns
char keys[ROWS][COLS] = {
  {'1','2','3'},
  {'4','5','6'},
  {'7','8','9'},
  {'*','0','#'}
};
byte rowPins[ROWS] = {D4,1, 3, D6}; //connect to the row pinouts of the keypad
byte colPins[COLS] = {D5, D3, 13}; //connect to the column pinouts of the keypad

/////////////////////////////
//D4=R1
//1=R2
//3=R3
//D6=R4
//D5=C1
//D3=C2
//13=C3
/////////////////////////////

short int State=-1;
unsigned short int Ci=0;
unsigned short int Cj=0;

short int PIN[]={1,2,3,4};
short int PIN_from_user[]={-1,-1,-1,-1};
unsigned int PIN_index=0;
unsigned short int PIN_attempts=3;
bool PIN_good=true;


void Execute_State_0()
{
  State=0;
  lcd.begin(20,4);
  lcd.init();
  lcd.backlight();
  lcd.clear();
  lcd.setCursor(0, 1);
  lcd.clear();
  Ci=6;
  Cj=1;
  lcd.setCursor(Ci,Cj);
  lcd.print("RIPBank");
  Ci=7;
  Cj=2;
  lcd.setCursor(Ci,Cj);
  lcd.print("TOKEN");
  delay(5000);
  Execute_State_1();
}

void Execute_State_1()
{
  State=1;
  int cnt=0;
  lcd.clear();
  delay(150);
  Ci=2;
  Cj=0;
  lcd.setCursor(Ci,Cj);
  lcd.print("Se conecteaza la");
  Ci=8;
  Cj=1;
  lcd.setCursor(Ci,Cj);
  lcd.print("WiFi");
  while(cnt<8)
  {
    Ci=6+cnt;
    Cj=2;
    lcd.setCursor(Ci,Cj);
    lcd.print(".");
    ++cnt;
    delay(500);
  }
  delay(1000);
  Execute_State_3(); 
}

void Execute_State_3()
{
  State=3;
  lcd.clear();
  Ci=6;
  Cj=0;
  lcd.setCursor(Ci,Cj);
  lcd.print("Conectat");
  
  Ci=9;
  Cj=1;
  lcd.setCursor(Ci,Cj);
  lcd.print("la");
  
  Ci=7;
  Cj=2;
  lcd.setCursor(Ci,Cj);
  lcd.print("WiFi!!");
  delay(3000);
  Execute_State_4();
}

void Execute_State_4()
{
  State=4;
  int cnt=0;
  lcd.clear();
  delay(150);
  Ci=2;
  Cj=0;
  lcd.setCursor(Ci,Cj);
  lcd.print("Se conecteaza la");
  Ci=7;
  Cj=1;
  lcd.setCursor(Ci,Cj);
  lcd.print("Server");
  while(cnt<8)
  {
    Ci=6+cnt;
    Cj=2;
    lcd.setCursor(Ci,Cj);
    lcd.print(".");
    ++cnt;
    delay(500);
  }
  delay(1000);
  Execute_State_6(); 
}

void Execute_State_6()
{
  State=6;
  lcd.clear();
  Ci=6;
  Cj=0;
  lcd.setCursor(Ci,Cj);
  lcd.print("Conectat");
  
  Ci=9;
  Cj=1;
  lcd.setCursor(Ci,Cj);
  lcd.print("la");
  
  Ci=6;
  Cj=2;
  lcd.setCursor(Ci,Cj);
  lcd.print("Server!!");
  delay(3000);
  Execute_State_7();
}

void Execute_State_7()
{
  State=7;
  int cnt=0;
  lcd.clear();
  delay(150);
  Ci=9;
  Cj=0;
  lcd.setCursor(Ci,Cj);
  lcd.print("Se");
  Ci=4;
  Cj=1;
  lcd.setCursor(Ci,Cj);
  lcd.print("actualizeaza");
  while(cnt<8)
  {
    Ci=6+cnt;
    Cj=2;
    lcd.setCursor(Ci,Cj);
    lcd.print(".");
    ++cnt;
    delay(500);
  }
  delay(1000);
  Execute_State_9(); 
}

void Execute_State_9()
{
  State=9;
  lcd.clear();
  Ci=5;
  Cj=0;
  lcd.setCursor(Ci,Cj);
  lcd.print("Actualizat");
  
  Ci=9;
  Cj=1;
  lcd.setCursor(Ci,Cj);
  lcd.print("cu");
  
  Ci=7;
  Cj=2;
  lcd.setCursor(Ci,Cj);
  lcd.print("succes");
  delay(3000);
  Execute_State_10();
}

void Execute_State_10()
{
  State=10;
  lcd.clear();
  
  Ci=3;
  Cj=0;
  lcd.setCursor(Ci,Cj);
  lcd.print("Alege optiune:");
  
  Ci=1;
  Cj=1;
  lcd.setCursor(Ci,Cj);
  lcd.print("1 Autentificare");
  
  Ci=1;
  Cj=2;
  lcd.setCursor(Ci,Cj);
  lcd.print("2     Despre");

  Ci=1;
  Cj=3;
  lcd.setCursor(Ci,Cj);
  lcd.print("3     Iesire");
  
  //delay(3000);
  //
}

void Execute_State_11()
{
  State=11;

  lcd.clear();
  
  Ci=1;
  Cj=0;
  lcd.setCursor(Ci,Cj);
  lcd.print("Despre dispozitiv:");
  
  Ci=3;
  Cj=1;
  lcd.setCursor(Ci,Cj);
  lcd.print("RIPBankC TOKEN");
  
  Ci=5;
  Cj=2;
  lcd.setCursor(Ci,Cj);
  lcd.print("v0.1 alpha");
  delay(7000);
  Execute_State_10();
}

void Execute_State_12()
{
  State=12;
  lcd.clear();
  Ci=1;
  Cj=0;
  lcd.setCursor(Ci,Cj);
  lcd.print("Introdu codul PIN:");
  Ci=0;
  Cj=1;
  lcd.setCursor(Ci,Cj);
  String att="";
  att+=(char)(PIN_attempts+'0');
  att+=" incercari ramase:";  
  lcd.print(att);
  PIN_index=0;
  PIN_from_user[0]=-1;
  PIN_from_user[1]=-1;
  PIN_from_user[2]=-1;
  PIN_from_user[3]=-1;
  Ci=8;
  Cj=2;
  //lcd.setCursor(Ci,Cj);
  
}

void Execute_State_14()
{
  State=14;
  lcd.clear();
  Ci=4;
  Cj=1;
  lcd.setCursor(Ci,Cj);
  lcd.print("PIN CORECT!!");
  delay(4000);
  Execute_State_15();
}

void Execute_State_19()
{
  State=19;
  lcd.clear();
  Ci=4;
  Cj=1;
  lcd.setCursor(Ci,Cj);
  lcd.print("PIN GRESIT!!");
  delay(4000);
}

void Execute_State_13()
{
  State=13;
  lcd.clear();
  
  Ci=1;
  Cj=0;
  lcd.setCursor(Ci,Cj);
  lcd.print("Ati introdus PINUL");

  Ci=2;
  Cj=1;
  lcd.setCursor(Ci,Cj);
  lcd.print("GRESIT de 3 ori!!");

  Ci=1;
  Cj=2;
  lcd.setCursor(Ci,Cj);
  lcd.print("Dispozitivul se va");

  Ci=5;
  Cj=3;
  lcd.setCursor(Ci,Cj);
  lcd.print("inchide!!!");
  delay(5000);
  Execute_State_18();
}

void Execute_State_15()
{
  State=15;
  int cnt=0;
  lcd.clear();
  delay(150);
  Ci=2;
  Cj=0;
  lcd.setCursor(Ci,Cj);
  lcd.print("Se trimit datele");
  Ci=2;
  Cj=1;
  lcd.setCursor(Ci,Cj);
  lcd.print("de autentificare");
  while(cnt<8)
  {
    Ci=5+cnt;
    Cj=2;
    lcd.setCursor(Ci,Cj);
    lcd.print(".");
    ++cnt;
    delay(500);
  }
  delay(1000);
  Execute_State_17();
  
}

void Execute_State_17()
  {
    State=17;
    lcd.clear();
  
    Ci=3;
    Cj=0;
    lcd.setCursor(Ci,Cj);
    lcd.print("Datele au fost");
  
    Ci=1;
    Cj=1;
    lcd.setCursor(Ci,Cj);
    lcd.print("trimise cu succes!");

    delay(4000);
    Execute_State_18();
  }

void Execute_State_18()
{
    State=18;
    lcd.clear();
  
    Ci=3;
    Cj=1;
    lcd.setCursor(Ci,Cj);
    lcd.print("Se inchide....");
    delay(2000);
    lcd.clear();
    lcd.noBacklight();
}
String kcharr="";
Keypad keypad = Keypad(makeKeymap(keys), rowPins, colPins, ROWS, COLS );

void keypadEvent(KeypadEvent key)
{
  int j=0;
  String str="";
  
  switch (keypad.getState())
  {
    case PRESSED:
      if(State==12 and (key>='0' and key<='9'))
      {
        str="";
        str+=key;
        lcd.setCursor(Ci+PIN_index,Cj);
        lcd.print(str);
        PIN_from_user[PIN_index]=key-'0';
        PIN_index++;
        
      }
      if(State==12 and key=='#')
      {
        for(j=0;j<4;++j)
        {
          if(PIN[j]!=PIN_from_user[j])
          {
            PIN_good=false;
          }
        }
        if(PIN_good==true)
        {
          Execute_State_14();
        }
        else
        {
          Execute_State_19();
          PIN_attempts--;
          if(PIN_attempts>0)
          {
            PIN_good=true;
            Execute_State_12();
          }
          else
          {
            Execute_State_13();
          }
        }
      }
      if(key=='1')
      {
        if(State==10 and PIN_attempts>0)
        {
          Execute_State_12();
        }
      }
      if(key=='2')
      {
        if(State==10)
        {
          Execute_State_11();
        }
      }
      if(key=='3' and State==10)
      {
        Execute_State_18();
      }
      if(key=='*')
      {
        Execute_State_0();
      }
      
      
      delay(100);
    break;
    case RELEASED:
      
    break;
    case HOLD:
      
    break;
  }
}


void setup()
{
  
  
  keypad.addEventListener(keypadEvent);  // Add an event listener.
  keypad.setHoldTime(100);               // Default is 1000mS
  keypad.setDebounceTime(50); 
  //Serial.begin(9600);
}

void loop()
{
  char key = keypad.getKey();
}
