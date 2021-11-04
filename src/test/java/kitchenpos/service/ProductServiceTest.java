package kitchenpos.service;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.math.BigDecimal;
import kitchenpos.application.ProductService;
import kitchenpos.dao.ProductDao;
import kitchenpos.dto.ProductRequest;
import kitchenpos.fixture.ProductFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

public class ProductServiceTest extends ServiceTest {
    @Mock
    private ProductDao productDao;
    @InjectMocks
    private ProductService productService;

    @DisplayName("상품을 생성할 수 있다")
    @Test
    void create() {
        productService.create(ProductFixture.productRequest());
    }

    @DisplayName("상품 가격이 null일 수 없다")
    @Test
    void createNull() {
        ProductRequest productRequest = new ProductRequest("name", null);

        assertThatThrownBy(() -> productService.create(productRequest)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("상품 가격이 0보다 작을 수 없다")
    @Test
    void createMinus() {
        ProductRequest productRequest = new ProductRequest("name", BigDecimal.valueOf(-1));

        assertThatThrownBy(() -> productService.create(productRequest)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("상품 가격이 0보다 작을 수 없다")
    @Test
    void findAll() {
        productService.list();
    }
}
