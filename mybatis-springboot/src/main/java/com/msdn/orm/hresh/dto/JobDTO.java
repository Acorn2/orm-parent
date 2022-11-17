package com.msdn.orm.hresh.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JobDTO {

	@Schema(name = "")
	private String name;

	@Schema(name = "")
	private Long userId;

	@Schema(name = "")
	private String address;
}
