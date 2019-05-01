///**
//   BasicHTTPClient.ino
//    Created on: 24.05.2015
//*/
//
//#include <Arduino.h>
//
//#include <ESP8266WiFi.h>
//#include <ESP8266WiFiMulti.h>
//
//#include <ESP8266HTTPClient.h>
//
//#include <WiFiClient.h>
//
//ESP8266WiFiMulti WiFiMulti;
//
//void setup() {
//
//  Serial.begin(115200);
//  // Serial.setDebugOutput(true);
//
//  Serial.println();
//  Serial.println();
//  Serial.println();
//
//  for (uint8_t t = 4; t > 0; t--) {
//    Serial.printf("[SETUP] WAIT %d...\n", t);
//    Serial.flush();
//    delay(1000);
//  }
//
//  WiFi.mode(WIFI_STA);
//  WiFiMulti.addAP("cam444", "speedXro");
//
//}
//
//void loop() {
//  // wait for WiFi connection
//  if ((WiFiMulti.run() == WL_CONNECTED)) 
//  {
//    Serial.println("Conectat la WiFi");
//    WiFiClient client;
//
//    HTTPClient http;
//
//    Serial.print("[HTTP] begin...\n");
//    if (http.begin(client, "http://192.168.0.107:5678/Windows")) 
//    {  // HTTP
//
//
//      Serial.print("[HTTP] GET...\n");
//      // start connection and send HTTP header
//      int httpCode = http.GET();
//
//      // httpCode will be negative on error
//      if (httpCode > 0) 
//      {
//        // HTTP header has been send and Server response header has been handled
//        Serial.printf("[HTTP] GET... code: %d\n", httpCode);
//
//        // file found at server
//        if (httpCode == HTTP_CODE_OK || httpCode == HTTP_CODE_MOVED_PERMANENTLY) 
//        {
//          String payload = http.getString();
//          Serial.println(payload);
//        }
//      } 
//      else 
//      {
//        Serial.printf("[HTTP] GET... failed, error: %s\n", http.errorToString(httpCode).c_str());
//      }
//
//      http.end();
//    } 
//    else 
//    {
//      Serial.printf("[HTTP} Unable to connect\n");
//    }
//  }
//
//  delay(10000);
//}

//#include <ESP8266WiFi.h>
//unsigned int i=0;
//String apiKey = "1EYZIS5OCRJSKZHG";  // replace with your channel’s thingspeak API key,
//
///*Put your SSID & Password*/
//const char* ssid = "cam444";    // Enter SSID here
//const char* password = "speedXro";  // Enter Password here
//
//const char* server = "api.thingspeak.com";
//int Sample;
//
//WiFiClient client;
//
//void setup() {
//  Serial.begin(9600);
//  delay(1000);
//
//  Serial.println("Connecting to ");
//  Serial.println(ssid);
//
//  //connect to your local wi-fi network
//  WiFi.begin(ssid, password);
//
//  //check wi-fi is connected to wi-fi network
//  while (WiFi.status() != WL_CONNECTED) {
//    delay(500);
//    Serial.print(".");
//  }
//  Serial.println("");
//  Serial.println("WiFi connected");
//}
//
//void loop() 
//{
//  if (client.connect("",8080))     // "184.106.153.149" or api.thingspeak.com
//  { 
//    Serial.println("conectat\n");
//    String postStr="POST_NO_";
//    postStr+=i;
//    postStr+="\n";
//   
//
//    client.println("POST /update HTTP/1.1");
//    client.println("Host:cosmin");
//    client.println("Content-Type:text/plain");
//    client.print("Content-Length: ");
//    client.println(postStr.length());
//    client.print("\r\n");
//    client.print(postStr);
//  }
//  client.stop();
//
//  Serial.println("Waiting…");       // thingspeak needs minimum 15 sec delay between updates
//
//  delay(8000);
//}

#include <ESP8266HTTPClient.h>
#include <ESP8266WiFi.h>
unsigned int i=0;
void setup() {
 
  Serial.begin(115200);                                  //Serial connection
  WiFi.begin("cam444", "speedXro");   //WiFi connection
 
  while (WiFi.status() != WL_CONNECTED) {  //Wait for the WiFI connection completion
 
    delay(500);
    Serial.println("Waiting for connection");
 
  }
 
}
 
void loop() {
 String msg_to_raileanu="message from ESP8266 No. ";
 msg_to_raileanu+=i;
 msg_to_raileanu+="\n";
 if(WiFi.status()== WL_CONNECTED){   //Check WiFi connection status
 
   HTTPClient http;    //Declare object of class HTTPClient
 
   if(http.begin("http://192.168.0.103:8080/RIPBankServiciiWeb/api/myresource"))
   {
   http.addHeader("Content-Type", "text/plain");  //Specify content-type header
 
   int httpCode = http.POST(msg_to_raileanu);   //Send the request
   String payload = http.getString();                  //Get the response payload
 
   Serial.println(httpCode);   //Print HTTP return code
   Serial.println(payload);    //Print request response payload
 
   http.end();  //Close connection
   }
 }else{
 
    Serial.println("Error in WiFi connection");   
 
 }
  i++;
  delay(5000);  //Send a request every 30 seconds
 
}
