package com.habuma.spitter.mvc;

import static com.habuma.spitter.mvc.HomeController.*;
import static java.util.Arrays.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.HashMap;
import java.util.List;

import org.junit.Test;

import com.habuma.spitter.domain.Spittle;
import com.habuma.spitter.service.SpitterService;

public class HomeControllerTest {  
  @Test
  public void shouldDisplayRecentSpittles() {
    List<Spittle> expectedSpittles = asList(new Spittle(), new Spittle(), new Spittle());
    
    SpitterService spitterService = mock(SpitterService.class);

    when(spitterService.getRecentSpittles(DEFAULT_SPITTLES_PER_PAGE)).thenReturn(expectedSpittles);
    
    HomeController controller = new HomeController(spitterService);
    
    HashMap<String, Object> model = new HashMap<>();
    String viewName = controller.showHomePage(model);
    
    assertEquals("home", viewName);

    assertSame(expectedSpittles, model.get("spittles"));
    verify(spitterService).getRecentSpittles(DEFAULT_SPITTLES_PER_PAGE);
  }
}
