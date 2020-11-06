package com.isa.morswiny.freemarker;

import freemarker.template.Configuration;
import freemarker.template.Template;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import javax.servlet.ServletContext;
import java.io.IOException;

import static org.mockito.Mockito.when;

public class TemplateProviderTest {

    @Mock
    TemplateProvider templateProvider;

    @Test
    void testFreemarkerTemplate() throws IOException {

    }
}
