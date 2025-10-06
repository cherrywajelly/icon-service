package com.example.icon_service.util;

import com.example.icon_service.auth.adapter.in.filter.AuthFilter;
import com.example.icon_service.auth.adapter.in.resolver.LoginMemberResolver;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;

import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.restdocs.RestDocumentationContextProvider;
//import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

//import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;


@SpringBootTest
@ActiveProfiles("test")
@ExtendWith({SpringExtension.class})
public abstract class BaseControllerTests extends TestContainerSupport{

    protected static String USER_ACCESS_TOKEN;
    protected MockMvc mockMvc;
    protected ObjectMapper objectMapper  = serializingObjectMapper();

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

//    @Autowired
//    protected MemberRepository memberRepository;
//
//    @Autowired
//    protected MemberTokenRepository memberTokenRepository;

    @BeforeAll
    static void setUpAuth() {
        USER_ACCESS_TOKEN = "Bearer " + "eyJhbGciOiJIUzM4NCJ9.eyJqdGkiOiI0MjRkMzM2NC1lMzgzLTQ2MzQtYTcwMy0zNzVhMzYyZDA4NTYiLCJpc3MiOiJ0aW1lVG9hc3QuY29tIiwic3ViIjoie1wiaWRcIjozLFwiZW1haWxcIjpcInllaW5pMDQxN0BnbWFpbC5jb21cIixcInJvbGVcIjpcIlVTRVJcIn0iLCJpYXQiOjE3MzEzMDI1NjEsImV4cCI6MTczMTMwNjE2MX0.VbROPXRou8Fwe7cfKoIYeWEma0LLdyaJPl-bAHr2XHsiqqls2SYDDHyn87wUd58r";
    }

    @BeforeEach
    void setUp() {

        AuthFilter authFilter = new AuthFilter();
        this.mockMvc = MockMvcBuilders
                .standaloneSetup(initController())
                .apply(SecurityMockMvcConfigurers.springSecurity(new MockSpringSecurityFilter()))
//                .apply(documentationConfiguration(provider))
                .addInterceptors()
                .setCustomArgumentResolvers(new LoginMemberResolver())
//                .setControllerAdvice(new CustomExceptionAdvice())
                .build();
    }

    protected abstract Object initController();

    private ObjectMapper serializingObjectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();

        JavaTimeModule javaTimeModule = new JavaTimeModule();
        javaTimeModule.addSerializer(LocalDate.class, new LocalDateSerializer());
        javaTimeModule.addDeserializer(LocalDate.class, new LocalDateDeserializer());
        javaTimeModule.addSerializer(LocalTime.class, new LocalTimeSerializer());
        javaTimeModule.addDeserializer(LocalTime.class, new LocalTimeDeserializer());

        objectMapper.registerModule(javaTimeModule);
        return objectMapper;
    }

    private static class LocalDateSerializer extends JsonSerializer<LocalDate> {

        @Override
        public void serialize(final LocalDate value, JsonGenerator gen, final SerializerProvider serializers) throws IOException {
            gen.writeString(value.format(DATE_FORMATTER));
        }
    }

    private static class LocalDateDeserializer extends JsonDeserializer<LocalDate> {

        @Override
        public LocalDate deserialize(final JsonParser p, final DeserializationContext ctxt) throws IOException {
            return LocalDate.parse(p.getValueAsString(), DATE_FORMATTER);
        }
    }

    private static class LocalTimeSerializer extends JsonSerializer<LocalTime> {

        @Override
        public void serialize(final LocalTime value, final JsonGenerator gen, final SerializerProvider serializerProvider) throws IOException {
            gen.writeString(value.format(TIME_FORMATTER));
        }
    }

    private static class LocalTimeDeserializer extends JsonDeserializer<LocalTime> {

        @Override
        public LocalTime deserialize(final JsonParser p, final DeserializationContext ctxt) throws IOException {
            return LocalTime.parse(p.getValueAsString(), TIME_FORMATTER);
        }
    }


}
