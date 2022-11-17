package com.msdn.orm.hresh.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SubUserDTO {

	@Schema(name = "")
	private String name;

	@Schema(name = "")
	private String customerId;

	@Schema(name = "")
	private String address;

}
