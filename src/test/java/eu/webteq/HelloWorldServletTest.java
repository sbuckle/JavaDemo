package eu.webteq;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
 
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class HelloWorldServletTest {

	@Mock
	HttpServletRequest request;

	@Mock
	HttpServletResponse response;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testGreeting() throws IOException, ServletException {
		// when(request.getParameter("msg")).thenReturn("hello");
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);

		when(response.getWriter()).thenReturn(pw);

		HelloWorldServlet servlet = new HelloWorldServlet();
		servlet.doGet(request, response);
		String result = sw.getBuffer().toString().trim();
		assertEquals(result, new String("Hello Test!"));
	}
}