package co.nz.csoft.elasticsearch.dto;

import java.util.List;

public class ThmPropertyResponseDto {
    private List<ThmPropertyDto> content;
    private int totalPages;
    private int totalElements;
    private boolean last;
    private int size;
    private int number;
	public List<ThmPropertyDto> getContent() {
		return content;
	}
	public void setContent(List<ThmPropertyDto> content) {
		this.content = content;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	public int getTotalElements() {
		return totalElements;
	}
	public void setTotalElements(int totalElements) {
		this.totalElements = totalElements;
	}
	public boolean isLast() {
		return last;
	}
	public void setLast(boolean last) {
		this.last = last;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
    
    

}
