package ru.pivovarov.application;

import java.util.Map;

public class Render {

   public void render (Map map){
   		map.forEach(( k,v)-> System.out.println(k+ ":" + v));

   }
}