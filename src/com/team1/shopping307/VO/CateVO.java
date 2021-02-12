package com.team1.shopping307.VO;

public class CateVO {
  private String name;
  private String bigo;

  public String getName() {
     return name;
  }

  public void setName(String name) {
     this.name = name;
  }

  public String getBigo() {
     return bigo;
  }

  public void setBigo(String bigo) {
     this.bigo = bigo;
  }
  
  public CateVO() {
  }

  public CateVO(String name, String bigo) {
     this.name = name;
     this.bigo = bigo; 
  }

  @Override
  public String toString() {
     return "name=" + name + ", bigo=" + bigo;
  }

}
