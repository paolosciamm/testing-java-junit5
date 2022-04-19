package guru.springframework.sfgpetclinic.model;

import guru.springframework.sfgpetclinic.CustomArgsProvider;
import guru.springframework.sfgpetclinic.ModelTests;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;

class OwnerTest implements ModelTests {

    @Test
    void dependentAssertions(){
        Owner owner = new Owner(1L, "Joe","Buck");
        owner.setCity("Key West");
        owner.setTelephone("12312333");
        assertAll("Properties Test",
                ()-> assertAll("Person properties",
                        ()->assertEquals("Joe",owner.getFirstName(),"First name did not match"),
                        ()->assertEquals("Buck",owner.getLastName())
                ),
                ()->assertAll("Owner properties",
                        ()->assertEquals("Key West",owner.getCity()),
                        ()->assertEquals("12312333",owner.getTelephone())
                )
        );
        assertThat(owner.getCity(),is("Key West"));
    }

    @DisplayName("Test Value")
    @ParameterizedTest(name="{displayName} - [{index}] {arguments}")
    @ValueSource(strings={"Spring","Framework","Guru"})
    void testValueSource(String val) {
        System.out.println(val);
    }

    @DisplayName("Test Value")
    @ParameterizedTest(name="{displayName} - [{index}] {arguments}")
    @EnumSource(OwnerType.class)
    void enumTest(OwnerType val) {
        System.out.println(val);
    }

    @DisplayName("CSV Input Test")
    @ParameterizedTest(name="{displayName} - [{index}] {arguments}")
    @CsvSource({
            "FL,1,1",
            "OH,2,2",
            "MI,1,1",
    })
    void csvInputTest(String stateName, int val1, int val2){ //column
        System.out.println(stateName+" = "+val1+" "+val2);
    }

    @DisplayName("CSV Input From File Test")
    @ParameterizedTest(name="{displayName} - [{index}] {arguments}")
    @CsvFileSource(resources = "/input.csv", numLinesToSkip = 1)
    void csvInputFromFileTest(String stateName, int val1, int val2){ //column
        System.out.println(stateName+" = "+val1+" "+val2);
    }

    @DisplayName("Method Provider Test")
    @ParameterizedTest(name="{displayName} - [{index}] {arguments}")
    @MethodSource("getArgs")
    void fromMethodTest(String stateName, int val1, int val2){ //column
        System.out.println(stateName+" = "+val1+" "+val2);
    }

    static Stream<Arguments> getArgs(){
        return Stream.of(Arguments.of("FL",1,1),
                Arguments.of("OH",31,1),
                Arguments.of("MI",13,41));
    }

    @DisplayName("Method Provider Test")
    @ParameterizedTest(name="{displayName} - [{index}] {arguments}")
    @ArgumentsSource(CustomArgsProvider.class)
    void fromCustomTest(String stateName, int val1, int val2){ //column
        System.out.println(stateName+" = "+val1+" "+val2);
    }
}