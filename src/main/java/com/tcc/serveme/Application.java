package com.tcc.serveme;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import java.math.BigDecimal;
import java.util.List;
import com.tcc.serveme.api.model.Product;
import com.tcc.serveme.api.repository.ProductRepository;

@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Application.class, args);

		ProductRepository repo = context.getBean(ProductRepository.class);

        System.out.println("==== STARTING PRODUCT REPOSITORY TESTS ====");

        // 1. Create a new product
        Product p1 = new Product();
        p1.setSku("PIZ001");
        p1.setName("Pizza Calabresa");
        p1.setPrice(new BigDecimal("35.50"));
        p1.setFkCategory(1L); // Existing category

        repo.save(p1);
        System.out.println("Saved product: " + p1);

        // 2. Retrieve all active products
        List<Product> allProducts = repo.findAll();
        System.out.println("All active products: " + allProducts);

        // 3. Retrieve product by ID (active)
        Product pById = repo.findById(allProducts.get(0).getId());
        System.out.println("Product by ID (active): " + pById);

        // 4. Update product
        pById.setPrice(new BigDecimal("37.00"));
        repo.update(pById);
        System.out.println("Updated product: " + repo.findById(pById.getId()));

        // 5. Soft delete the product
        repo.softDelete(pById.getId());
        System.out.println("Product soft deleted");

        // 6. Retrieve product by ID (active) after soft delete - should return null
        Product deletedActive = repo.findById(pById.getId());
        System.out.println("Product by ID after soft delete (active): " + deletedActive);

        // 7. Retrieve product by ID including inactive
        Product deletedAll = repo.findByIdIncludingInactive(pById.getId());
        System.out.println("Product by ID after soft delete (including inactive): " + deletedAll);

        // 8. Retrieve products by category
        List<Product> byCategory = repo.findByCategory(1L);
        System.out.println("Products by category: " + byCategory);

        // 9. Retrieve products by name
        List<Product> byName = repo.findByName("Pizza");
        System.out.println("Products by name: " + byName);

        // 10. Retrieve products by SKU
        List<Product> bySku = repo.findBySku("PIZ");
        System.out.println("Products by SKU: " + bySku);

        // 11. Check if SKU exists
        boolean exists = repo.existsBySku("PIZ001");
        System.out.println("Does SKU exist? " + exists);

        System.out.println("==== END OF PRODUCT REPOSITORY TESTS ====");
	}
}