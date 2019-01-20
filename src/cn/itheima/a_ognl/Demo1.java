package cn.itheima.a_ognl;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import cn.itheima.bean.User;
import ognl.Ognl;
import ognl.OgnlContext;
import ognl.OgnlException;

public class Demo1 {
    //root
	@Test
	public void fun1() throws OgnlException{
	   //准备ONGL
       //准备root
    	User rootUser = new User("Tom",18);
    	//准备context
    	Map<String,User> context = new HashMap<String,User>();
    	context.put("user1", new User("jack",18));
    	context.put("user2", new User("rose",20));
       //书写ONGL
    	OgnlContext oc = new OgnlContext();
    	oc.setRoot(rootUser);
    	oc.setValues(context);
    	
    	String name = (String) Ognl.getValue("name", oc, oc.getRoot());
    	System.out.println(name);
   } 
	@Test
    public void fun2() throws OgnlException{
        //user
    	//准备ONGL
        //准备root
     	User rootUser = new User("Tom",18);
     	//准备context
     	Map<String,User> context = new HashMap<String,User>();
     	context.put("user1", new User("jack",18));
     	context.put("user2", new User("rose",20));
        //书写ONGL
     	OgnlContext oc = new OgnlContext();
     	oc.setRoot(rootUser);
     	oc.setValues(context);
     	
     	String name = (String) Ognl.getValue("#user1.name", oc, oc.getRoot());
     	System.out.println(name);
    }
}
