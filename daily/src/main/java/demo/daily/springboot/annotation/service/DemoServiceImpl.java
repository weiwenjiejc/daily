package demo.daily.springboot.annotation.service;

import org.springframework.stereotype.Service;

@Service
public class DemoServiceImpl implements DemoService{

	@Override
	public void demo() {
		// TODO Auto-generated method stub
		System.out.println("DemoService");
		
	}

}
