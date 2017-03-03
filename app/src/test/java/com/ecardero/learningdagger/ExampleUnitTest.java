package com.ecardero.learningdagger;

import com.ecardero.learningdagger.presentation.service.StarWarsService;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.UUID;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    @Mock
    StarWarsService starWarsService;

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Test
    public void addition_isCorrect() throws Exception {
        starWarsService.getCharacterById(UUID.randomUUID());

        assertEquals(4, 2 + 2);
    }
}