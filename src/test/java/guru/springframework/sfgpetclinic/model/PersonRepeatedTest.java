package guru.springframework.sfgpetclinic.model;

import org.junit.jupiter.api.*;

@Tag("repeated")
public class PersonRepeatedTest implements ModelRepeatedTest{
    @RepeatedTest(5)
    void myRepeatedTestDI(TestInfo testInfo, RepetitionInfo repetitionInfo){
        System.out.println(testInfo.getDisplayName()+": "+repetitionInfo.getCurrentRepetition());
    }

    @RepeatedTest(value=5, name="{displayName} : {currentRepetition} | {totalRepetitions}")
    @DisplayName("My assignment repeated test")
    void myAssignmentRepeated(TestInfo testInfo, RepetitionInfo repetitionInfo){
        System.out.println(testInfo.getDisplayName()+": "+repetitionInfo.getCurrentRepetition());
    }
}
