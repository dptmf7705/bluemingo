package com.bluemingo.bluemingo.domain;

import java.sql.Date;

public class ImageVO {

	private Integer image_key;
	private String original_file_name;
	private String stored_file_name;
	private long file_size;
	private Long crea_dtm;
	private String crea_id;
	private String del_gb;
	
	private Integer item_key;
	private String item_name;
	
	
	public Integer getImage_key() {
		return image_key;
	}
	public void setImage_key(Integer image_key) {
		this.image_key = image_key;
	}
	public String getOriginal_file_name() {
		return original_file_name;
	}
	public void setOriginal_file_name(String original_file_name) {
		this.original_file_name = original_file_name;
	}
	public String getStored_file_name() {
		return stored_file_name;
	}
	public void setStored_file_name(String stored_file_name) {
		this.stored_file_name = stored_file_name;
	}
	public long getFile_size() {
		return file_size;
	}
	public void setFile_size(long file_size) {
		this.file_size = file_size;
	}
	public Long getCrea_dtm() {
		return crea_dtm;
	}
	public void setCrea_dtm(Date crea_dtm) {
		this.crea_dtm = crea_dtm.getTime();
	}
	public String getCrea_id() {
		return crea_id;
	}
	public void setCrea_id(String crea_id) {
		this.crea_id = crea_id;
	}
	public String getDel_gb() {
		return del_gb;
	}
	public void setDel_gb(String del_gb) {
		this.del_gb = del_gb;
	}
	public Integer getItem_key() {
		return item_key;
	}
	public void setItem_key(Integer item_key) {
		this.item_key = item_key;
	}
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	
	
	
}
