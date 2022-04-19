package guru.springframework.sfgpetclinic.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.TestInfo;

public interface ModelRepeatedTest {
    @BeforeEach
    default void beforeEachConsoleOutputer(TestInfo testInfo, RepetitionInfo repetitionInfo){
        System.out.print("Running Test - "+testInfo.getDisplayName()+" - "+repetitionInfo.getCurrentRepetition()
                +" | "+repetitionInfo.getTotalRepetitions()+"\n \t");
    }
}
