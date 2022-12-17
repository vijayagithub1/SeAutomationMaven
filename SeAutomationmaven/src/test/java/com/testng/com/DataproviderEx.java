package com.testng.com;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataproviderEx {
@Test(dataProvider="addition")
public void add(int a,int b,int c) {
	int value=a+b;
	Assert.assertEquals(value,c);
}

@Test(dataProvider="substration")
public void substration(int a,int b,int c) {
	int value=b-a;
	Assert.assertEquals(value,c);
}
@DataProvider(name="addition")
public Object [][]data(){
	Object[][]data={{1,2,3},{4,5,9},{7,8,15},{9,8,17},{1,2,3},{4,5,9},{7,8,15},{9,8,17}};
return data;
}
@DataProvider(name="substration")
public Object [][]data1(){
	Object[][]data={{1,2,1},{4,5,1},{3,4,1},{9,8,-1},{1,2,1},{4,5,1},{7,8,1},{9,8,-1}};
return data;
}
}