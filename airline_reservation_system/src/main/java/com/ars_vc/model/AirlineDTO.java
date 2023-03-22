package com.ars_vc.model;

import java.util.List;

import com.ars_vc.entity.Flight;

import lombok.Data;
@Data
public class AirlineDTO {
	private int id;
	private String airlineName;
	private float fare;
	private List<Flight> flights;

}
