package de.htwberlin.webtech.service;

import de.htwberlin.webtech.healthyrecipes.persistence.RecipeRepository;
import de.htwberlin.webtech.healthyrecipes.service.RecipeService;
import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class RecipeServiceTest implements WithAssertions {

    @Mock
    private RecipeRepository repository;

    @InjectMocks
    private RecipeService underTest;

    @Test
    @DisplayName("should return true if delete was successful")
    void should_return_true_if_delete_was_successful(){
        Long givenId = 100L;
        doReturn(true).when(repository).existsById(givenId);

        boolean result = underTest.deleteById(givenId);

        verify(repository).deleteById(givenId);
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("should return false if person to delete does not exist")
    void should_return_false_if_person_to_delete_does_not_exist(){
        Long givenId = 100L;
        doReturn(false).when(repository).existsById(givenId);

        boolean result = underTest.deleteById(givenId);

        verifyNoMoreInteractions(repository);
        assertThat(result).isFalse();
    }
}
