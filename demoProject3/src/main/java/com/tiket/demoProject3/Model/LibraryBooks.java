package com.tiket.demoProject3.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LibraryBooks {
    private String id;
    private String name;
    private String author;
    private BigDecimal price;
}
