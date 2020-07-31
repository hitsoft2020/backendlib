package com.hit.hotel;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = { "com.hit.hotel.admin.mapper", "com.hit.hotel.client.mapper",
		"com.hit.hotel.consumption.mapper", "com.hit.hotel.employee.mapper", "com.hit.hotel.goods.mapper",
		"com.hit.hotel.order.mapper", "com.hit.hotel.payout.mapper", "com.hit.hotel.payrecord.mapper",
		"com.hit.hotel.report.mapper", "com.hit.hotel.room.mapper", "com.hit.hotel.roomtel.mapper",
		"com.hit.hotel.vip.mapper" })
public class HotelMs014Application {

	public static void main(String[] args) {
		SpringApplication.run(HotelMs014Application.class, args);
	}

}
