package com.main.java.zipit;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.SystemUtils;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class TestMain {

	public static void main(String[] args) {

		/*List<Integer>  list1 = new ArrayList<>();
		
		list1.add(2);
		list1.add(3);
		list1.add(4);
		list1.add(5);
		
		List<Integer>  list2 = new ArrayList<>();
		
		list2.add(4);
		list2.add(5);
		list2.add(6);
		list2.add(7);
		
		System.out.println("######################## List Difference #######################");
		System.out.println("List 1 : "+list1);
		
		System.out.println("List 2 : "+list2);
		
		list2.removeAll(list1);
		
		System.out.println("Differnce : "+list2);
		
		System.out.println("######################## Array Difference #######################");
		
		int[] arr1 = new int[]{2,3,4,5};
		
		int[] arr2 = new int[]{4,5,6,7};
		
		boolean flag = false;
		for(int i=0;i<arr2.length;i++){
			
			for(int j=0;j<arr1.length;j++){
				
				if(arr2[i] == arr1[j])
					flag = true;
			}
			
			if(!flag)
				System.out.println("Element "+arr2[i]+" is not present in arraylist1");
			flag = false;
		}*/
		
		SomeEntity pojo1 = new SomeEntity("abc", null, 0, 0, "def", null, false, null);
		SomeEntity pojo12 = new SomeEntity("ghi", null, 1, 1, "jkl", null, true, null);
		
		List<SomeEntity> list = new ArrayList<>();
		list.add(pojo1);
		list.add(pojo12);
		//NotNullToStringStyle toStingStyle = new NotNullToStringStyle(NotNullToStringStyle.CONTENT_START_SPACE, NotNullToStringStyle.CONTENT_END_DOT, true, false, false);
		NotNullToStringStyle toStingStyle = new NotNullToStringStyle()
												.contentStart(NotNullToStringStyle.CONTENT_START_SPACE)
												//.fieldSeparator(SystemUtils.LINE_SEPARATOR + " ")
												//.isFieldSeparatorAtStart(true)
												.contentEnd(NotNullToStringStyle.CONTENT_END_DOT)
												.useFielNameValueSeparator(":")
												.useFieldName(true)
												.useClassName(false)
												.useIdentityHashCode(false);
		//ToStringStyle toStingStyle1 = NotNullToStringStyle.MULTI_LINE_STYLE;
		
		String temp = ReflectionToStringBuilder.toString(pojo1, toStingStyle, true, true);
		System.out.println(temp);
	}

}
