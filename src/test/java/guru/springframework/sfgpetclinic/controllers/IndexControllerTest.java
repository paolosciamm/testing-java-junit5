package guru.springframework.sfgpetclinic.controllers;

import guru.springframework.sfgpetclinic.ControllerTests;
import org.junit.jupiter.api.*;

import java.time.Duration;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

@Tag("controllers")
class IndexControllerTest implements ControllerTests {

    IndexController controller;

    @BeforeEach
    void setUp() {
        controller = new IndexController();
    }

    @RepeatedTest(value=10, name="{displayName} : {currentRepetition} - {totalRepetition}")
    @DisplayName("Test Proper View bame is returned for index page")
    @Test
    void index() {

        assertEquals("index",controller.index(),"Wrong view returned");
        assertThat(controller.index()).isEqualTo("index");
    }

    /*@Test
    void oupsHandler() {
        assertTrue("notimplemented".equals(controller.oupsHandler()),()->"This is some expensive " +
                "Message to build "+
                "for my test");
    }*/

    @DisplayName("Test Proper View bame is returned for index page fails")
    @Test
    void indexFails() {
        assertEquals("index",controller.index(),"Wrong view returned");
    }

    @Test
    void oupsHandlerFails() {
        assertThrows(ValueArgumentNotFoundException.class,()->{
           controller.oupsHandler();
        });
    }

    @Test
    void testTimeout(){
        assertTimeout(Duration.ofMillis(1000),()->{
            Thread.sleep(900);
            System.out.println("I got here");
        });
    }
    @Test
    void testTimeoutPreempt(){
        assertTimeout(Duration.ofMillis(1000),()->{
            Thread.sleep(900);
            System.out.println("I got here preempt");
        });
    }

    @Test
    void testAssumptionTrue(){
        assumeTrue("paolofrancescosciammagroupedAssertionsFailrella".equalsIgnoreCase(System.getenv("paolofrancescosciammarella")));
    }
}