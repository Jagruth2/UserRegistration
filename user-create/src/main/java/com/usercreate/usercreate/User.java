package com.usercreate.usercreate;

import org.springframework.web.bind.annotation.RequestMapping;

public class User
{
	//private double startingMoney;
	private String firstName;
	private String lastName;
	//private String username;
	//private String password;

	private static int count = 0; // number of objects in memory

	// initialize user, add 1 to static count and
	// output String indicating that constructor was called
	
	@RequestMapping("/mike")
	public String User2( String first, String last )
	{
		firstName = first;
		lastName = last;

		count++; // increment static count of Users
		System.out.printf( "User constructor: %s %s; count = %d\n",
				firstName, lastName, count );
		return "helloow";
	
	} // end User constructor


	

}
