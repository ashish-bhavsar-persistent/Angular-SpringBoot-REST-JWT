package com.app.model.response;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

//@Data //for getters and setters
public class PageResponse extends OperationResponse {
	private boolean first;
	private boolean last;
	private int currentPageNumber;
	private int itemsInPage;
	private int pageSize;
	private int totalPages;
	private long totalItems;
	private Sort sort;
	private List items;

	public void setPageStats(Page pg, boolean setDefaultMessage) {
		this.first = pg.isFirst();
		this.last = pg.isLast();
		this.currentPageNumber = pg.getNumber();
		this.itemsInPage = pg.getNumberOfElements();
		this.pageSize = pg.getSize();
		this.totalPages = pg.getTotalPages();
		this.totalItems = pg.getTotalElements();
		// this.items = pg.getContent();
		this.sort = pg.getSort();
		if (setDefaultMessage == true) {
			this.setOperationStatus(ResponseStatusEnum.SUCCESS);
			this.setOperationMessage("Page " + (pg.getNumber() + 1) + " of " + pg.getTotalPages());
		}
	}

	public void setPageTotal(int count, boolean setDefaultMessage) {
		// this.items = list;
		this.first = true;
		this.last = true;
		this.itemsInPage = count;
		this.totalItems = count;
		this.totalPages = 1;
		this.pageSize = count;
		if (setDefaultMessage == true) {
			this.setOperationStatus(ResponseStatusEnum.SUCCESS);
			this.setOperationMessage("Total " + count + " items ");
		}
	}

}
