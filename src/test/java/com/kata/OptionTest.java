package com.kata;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * author : pkelly
 */
public class OptionTest {

    private ArrayList<Option<String>> names;

    @Before
    public void beforeEach() {
        names = new ArrayList<Option<String>>();
        names.add(new HasAValue<String>("Dean"));
        names.add(new NoValue<String>());
        names.add(new HasAValue<String>("Wampler"));
    }

    @Test
    public void shouldEnsureGetOrElseUseValueForSomeAndAlternativeForNone() {

        String[] expected = {"Dean", "Unknown", "Wampler"};
        for (int i = 0; i < names.size(); i++) {
            Option<String> name = names.get(i);
            String orElse = name.getOrElse("Unknown");
            System.out.println("OrElse : " + orElse);
            assertThat(expected[i], is(orElse));
        }
    }

    @Test
    public void shouldWrapAnOptionAndReturnCorrectValue() {

        String str = "Hello1";
        Option<String> opt1 = wrap(str);
        assertThat(str, is(opt1.get()));

    }

    static Option<String> wrap(String s) {

        if (s == null) {
            return new NoValue<String>();
        } else {
            return new HasAValue<String>(s);
        }
    }
}
