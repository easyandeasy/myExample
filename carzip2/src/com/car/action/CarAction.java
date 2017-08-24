package com.car.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.car.beans.Car;
import com.car.service.CarServiceImpl;
import com.car.service.ICarService;

import net.sf.json.JSONArray;

public class CarAction{

	private ICarService service = new CarServiceImpl();
	private HttpServletResponse request = ServletActionContext.getResponse();

	
	public void carInfo() throws Exception{
		request.setContentType("text/html;charset=utf-8");
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = response.getWriter();
		List<Car> cars = service.queryCarMap();
		JSONArray json = JSONArray.fromObject(cars);
		out.print(json);
		out.flush();
		out.close();
	}
/*	
	@Test
	public void test(){
		
		HttpServletResponse response = ServletActionContext.getResponse();
		System.out.println("=========================");
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		List<Map> cars = service.queryCarMap();
		for (Map map : cars) {
			System.out.println(map.get("CNAME"));
		}
		JSONObject json = JSONObject.fromObject(cars);
		out.print(json.toString());
		out.flush();
		out.close();
	}*/
}
