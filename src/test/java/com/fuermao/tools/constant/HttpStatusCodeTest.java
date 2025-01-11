package com.fuermao.tools.constant;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class HttpStatusCodeTest {

    @Test
    void getCode() {
        int code = HttpStatusCode.OK.getCode();
        assertEquals(200, code);
    }

    @Test
    void getMessage() {
        String message = HttpStatusCode.OK.getMessage();
        assertEquals("OK", message);
    }

    @ParameterizedTest
    @ValueSource(ints = {0,-1,1000})
    void getHttpStatusCode(int code) {
        HttpStatusCode httpStatusCode = HttpStatusCode.getHttpStatusCode(code);
        assertNull(httpStatusCode);
    }
}