package com.hqyj.SpringBootDemo.modules.common.vo;

import com.hqyj.SpringBootDemo.modules.common.vo.Result.ResultStatus;

public class Result<T> {

	private final static Integer SUCCESS = 200;
	private final static Integer FAILD = 500;
	private int status;
	private String message;
	private T object;

	public Result() {
	}

	public Result(int status, String message) {
		this.status = status;
		this.message = message;
	}

	public Result(int status, String message, T object) {
		this.status = status;
		this.message = message;
		this.object = object;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getObject() {
		return object;
	}

	private final static int BIG_IMAGE_WIDTH = 1000;
	private final static int BIG_IMAGE_HEIGH = 800;
	private final static String BIG_IMAGE_ALT = "big image";

	private final static int MIDDEL_IMAGE_WIDTH = 500;
	private final static int MIDDEL_IMAGE_HEIGHT = 400;
	private final static int SMALL_IMAGE_WIDTH = 100;
	private final static int SMALL_IMAGE_HEIGHT = 80;

	public void setObject(T object) {
		this.object = object;
	}

	public enum ImageEnum {
		BIG(1000, 800, "big image"), MIDDEL(500, 400), SMALL(100, 80);

		public int width;
		public int heigh;
		public String alt;

		private ImageEnum(int width, int heigh) {
			this.width = width;
			this.heigh = heigh;
		}

		private ImageEnum(int width, int heigh, String alt) {
			this.width = width;
			this.heigh = heigh;
			this.alt = alt;
		}

	}

	public enum ResultStatus {
		SUCCESS(200), FAILD(500);

		public int status;

		private ResultStatus(int status) {
			this.status = status;
		}

	}

}