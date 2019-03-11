package com.ripbank.serviciiweb;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

// adnotarea ApplicationPath specifica calea URL spre serviciile web
// e.g., @ApplicationPath("api") => http://localhost:8080/RIPBankServiciiWeb/api/
@ApplicationPath("api")
public class MyApplication extends Application {

}