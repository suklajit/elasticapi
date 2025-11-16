package co.nz.csoft.elasticsearch.dto;

import java.util.List;
import java.util.Map;

public class PaginatedResponse {
	private List<Map<String, Object>> content;
	private long totalElements;                
    private int pageNumber;                    
    private int pageSize;                      
    private long totalPages;
    
   
	public PaginatedResponse(List<Map<String, Object>> content, long totalElements, int pageNumber, int pageSize,
			long totalPages) {
		super();
		this.content = content;
		this.totalElements = totalElements;
		this.pageNumber = pageNumber;
		this.pageSize = pageSize;
		this.totalPages = totalPages;
	}
	public List<Map<String, Object>> getContent() {
		return content;
	}
	public void setContent(List<Map<String, Object>> content) {
		this.content = content;
	}
	public long getTotalElements() {
		return totalElements;
	}
	public void setTotalElements(long totalElements) {
		this.totalElements = totalElements;
	}
	public int getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public long getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(long totalPages) {
		this.totalPages = totalPages;
	} 
    
    
    

}
