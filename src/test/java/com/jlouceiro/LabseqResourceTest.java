package com.jlouceiro;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.lessThan;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
class LabseqResourceTest {

    @Test
    void testLabseqEndpoint_zero() {
        given()
                .pathParam("n", 0)
                .when().get("/labseq/{n}")
                .then()
                .statusCode(200)
                .body(is("0"));
    }

    @Test
    void testLabseqEndpoint_one() {
        given()
                .pathParam("n", 1)
                .when().get("/labseq/{n}")
                .then()
                .statusCode(200)
                .body(is("1"));
    }

    @Test
    void testLabseqEndpoint_two() {
        given()
                .pathParam("n", 2)
                .when().get("/labseq/{n}")
                .then()
                .statusCode(200)
                .body(is("0"));
    }

    @Test
    void testLabseqEndpoint_three() {
        given()
                .pathParam("n", 3)
                .when().get("/labseq/{n}")
                .then()
                .statusCode(200)
                .body(is("1"));
    }

    @Test
    void testLabseqEndpoint_four() {
        given()
                .pathParam("n", 4)
                .when().get("/labseq/{n}")
                .then()
                .statusCode(200)
                .body(is("1"));
    }

    @Test
    void testLabseqEndpoint_five() {
        given()
                .pathParam("n", 5)
                .when().get("/labseq/{n}")
                .then()
                .statusCode(200)
                .body(is("1"));
    }

    @Test
    void testLabseqEndpoint_six() {
        given()
                .pathParam("n", 6)
                .when().get("/labseq/{n}")
                .then()
                .statusCode(200)
                .body(is("1"));
    }

    @Test
    void testLabseqEndpoint_seven() {
        given()
                .pathParam("n", 7)
                .when().get("/labseq/{n}")
                .then()
                .statusCode(200)
                .body(is("2"));
    }

    @Test
    void testLabseqEndpoint_eight() {
        given()
                .pathParam("n", 8)
                .when().get("/labseq/{n}")
                .then()
                .statusCode(200)
                .body(is("2"));
    }

    @Test
    void testLabseqEndpoint_nine() {
        given()
                .pathParam("n", 9)
                .when().get("/labseq/{n}")
                .then()
                .statusCode(200)
                .body(is("2"));
    }

    @Test
    void testLabseqEndpoint_ten() {
        given()
                .pathParam("n", 10)
                .when().get("/labseq/{n}")
                .then()
                .statusCode(200)
                .body(is("3"));
    }

    @Test
    void testLabseqEndpoint_twenty() {
        given()
                .pathParam("n", 20)
                .when().get("/labseq/{n}")
                .then()
                .statusCode(200)
                .body(is("21"));
    }

    @Test
    void testLabseqEndpoint_negative() {
        given()
                .pathParam("n", -3)
                .when().get("/labseq/{n}")
                .then()
                .statusCode(400);
    }

   @Test
    @Timeout(value = 10, unit = TimeUnit.SECONDS) 
    void testLabseqEndpoint_highValue_respondsInTime() {
        given()
                .pathParam("n", 100000)
                .when().get("/labseq/{n}")
                .then()
                .statusCode(200)
                .time(lessThan(10000L)); 
    }

}
