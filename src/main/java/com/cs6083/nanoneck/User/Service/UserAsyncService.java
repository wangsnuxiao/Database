package com.cs6083.nanoneck.User.Service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class UserAsyncService {

	@Async
	public void hello(){
		try{
			Thread.sleep(3000);
		} catch (InterruptedException e){
			e.printStackTrace();
		}
		System.out.println("Data Processing");
	}
}
