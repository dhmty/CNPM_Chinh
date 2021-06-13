/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.applicationmvc.Utils;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author MinhTo
 */
public class SessionUtil {
  private static Map sessSionUser=new HashMap<String,Object>();
  public static String userCurrent=null;
   // class variable(khi lớp được khởi tạo nó sẽ được khởi tạo)    
   
    public static void putValue(String key,Object value)
            {
               sessSionUser.put(key, value);
               userCurrent=key;
            }
    public static Object getValue(String key)
            {
                return sessSionUser.get(key);
            }
    public static void removeSession(String key)
            {
              sessSionUser.remove(key);
              userCurrent=null;
            }
   
}
