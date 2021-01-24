package com.payment.paymentgateway.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.payment.paymentgateway.model.BookDetailsResponse;
import com.payment.paymentgateway.model.BookImageResponse;
import com.payment.paymentgateway.model.BooksContent;

@Service
public class StaticContentDataService {
	
	Map<String, BooksContent> cacheStore = new HashMap<String, BooksContent>();
	
	List<BooksContent> bookContent = null;
	
	@Value("${BOOK_DETAILS_URL}")
	private String bookDetailsUrl;
	
	@Value("${BOOK_IMAGES_URL}")
	private String bookImageUrl;
	
	@PostConstruct
	public void init() {
		bookContent = new ArrayList<BooksContent>();
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<BookImageResponse[]> response = restTemplate.getForEntity(bookImageUrl,BookImageResponse[].class );
		BookImageResponse[] resBody = response.getBody();
		
		ResponseEntity<BookDetailsResponse[]> detailsRes = restTemplate.getForEntity(bookDetailsUrl, BookDetailsResponse[].class);
		BookDetailsResponse[] detailsResBody = detailsRes.getBody();
		int i=0;
		List<BooksContent> cntList = new ArrayList<>();
		for(BookDetailsResponse det : detailsResBody) {
			if(i > 9) {
				i = 0;
			}
			BooksContent content = new BooksContent();
			content.setBookID(det.getBookID());
			content.setAuthor(det.getAuthors());
			content.setAvgRating(det.getAverageRating());
			content.setTitle(det.getTitle());
			content.setPrice(det.getPrice());
			content.setImage(resBody[i].getImage());
			i++;
			bookContent.add(content);
		}
		
	}
	
	public BooksContent[] getBookDetailsContent() {
		return bookContent.toArray(new BooksContent[bookContent.size()]);
	}

}
