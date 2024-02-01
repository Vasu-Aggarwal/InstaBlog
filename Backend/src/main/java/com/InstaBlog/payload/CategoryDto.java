package com.InstaBlog.payload;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class CategoryDto {

    private Integer categoryId;
    @NotEmpty(message = "Category Title cannot be empty.")
    @NotNull
    private String categoryTitle;
    @NotNull
    @NotEmpty
    private String categoryDesc;

}
