package org.gg.binaryTea.config;

import jakarta.annotation.Resource;
import org.gg.binaryTea.BinaryTeaApplication;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest(classes = BinaryTeaApplication.class, properties = {
        "binary.tea.ready=true",
        "binary.tea.open-hours=8:30-22:00"
})
class ShopConfigurationTest {
    @Resource
    private ApplicationContext applicationContext;

    @Test
    void testPropertiesBeanAvailable() {
        assert applicationContext.containsBean("binary.tea-org.gg.binaryTea.config.BinaryTeaProperties");
    }

    @Test
    void testPropertiesValue() {
        BinaryTeaProperties binaryTeaProperties = applicationContext.getBean(BinaryTeaProperties.class);
        assert binaryTeaProperties.isReady();
        assert binaryTeaProperties.getOpenHours().equals("8:30-22:00");
    }

}
