package jpabook.jpashop.controller;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookForm {

    /**
     * 상품 공통 사항
     */
    private Long id;

    private String name;
    private int price;
    private int stockQuantity;

    /**
     * 상품의 특정 book과 관련된 것.
     */
    private String author;
    private String isbn;
}
