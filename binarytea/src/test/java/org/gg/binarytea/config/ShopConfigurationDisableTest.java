package org.gg.binaryTea.config;

import jakarta.annotation.Resource;
import org.gg.binaryTea.BinaryTeaApplication;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest(classes = BinaryTeaApplication.class, properties = {
        "binary.tea.ready=false",
        "binary.tea.open-hours=8:30-22:00"
})
class ShopConfigurationDisableTest {
    @Resource
    private ApplicationContext applicationContext;

    @Test
    void testPropertiesBeanUnAvailable() {
        assert "false".equals(applicationContext.getEnvironment().getProperty("binary.tea.ready"));
        assert !applicationContext.containsBean("binary.tea-org.gg.binaryTea.config.BinaryTeaProperties");
    }
}