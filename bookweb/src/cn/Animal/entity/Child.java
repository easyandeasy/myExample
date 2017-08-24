package cn.Animal.entity;

public class Child extends TestParent {
	
	  public void count() {
		    System.out.println(10/3);
	  }
	  
	  public static void main(String args[]) {
	    TestParent p = new Child();
	    p.count();
	  }
}
