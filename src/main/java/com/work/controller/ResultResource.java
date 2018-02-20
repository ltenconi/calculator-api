package com.work.controller;

import org.springframework.hateoas.ResourceSupport;

public class ResultResource extends ResourceSupport {

	private Integer result;

	public ResultResource() {
	}

	public ResultResource(Integer result) {
		this.result = result;
	}

	public Integer getResult() {
		return result;
	}
}
