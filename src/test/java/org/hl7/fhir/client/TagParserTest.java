package org.hl7.fhir.client;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import org.hl7.fhir.instance.client.TagParser;
import org.hl7.fhir.instance.model.AtomCategory;
import org.hl7.fhir.instance.model.DateAndTime;
import org.junit.Test;

public class TagParserTest {
	
	public static final String CATEGORY1 = "http://client/tag/123; label=\"tag 123\"; scheme=\"http://client/123/scheme\", http://client/tag/456; label=\"tag 456\"; scheme=\"http://client/456/scheme\"";
	public static final String CATEGORY2 = "http://readtag.nu.nl;   scheme=\"http://hl7.org/fhir/tag\";label=\"readTagTest\"";
	public static final String CATEGORY3 = "dog; label=\"Canine\"; scheme=\"http://purl.org/net/animals\"";
	public static final String CATEGORY4 = "dog; label=\"Canine\"; scheme=\"http://purl.org/net/animals\",  lowchen; label*=UTF-8'de'L%c3%b6wchen\";scheme=\"http://purl.org/net/animals/dogs\"";

	@Test
	public void testParse1() {
		try {
			List<AtomCategory> tags = new TagParser().parse(CATEGORY1);
			assertTrue(tags.size() > 0);
			assertEquals(2, tags.size());
			assertEquals("http://client/tag/123", tags.get(0).getTerm());
			assertEquals("\"tag 123\"", tags.get(0).getLabel());
			assertEquals("\"http://client/123/scheme\"", tags.get(0).getScheme());
			assertEquals("http://client/tag/456",tags.get(1).getTerm());
			assertEquals("\"tag 456\"",tags.get(1).getLabel());
			assertEquals("\"http://client/456/scheme\"",tags.get(1).getScheme());
		}catch(Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void testParse2() {
		try {
			List<AtomCategory> tags = new TagParser().parse(CATEGORY2);
			assertTrue(tags.size() > 0);
			assertEquals(1, tags.size());
			assertEquals("http://readtag.nu.nl", tags.get(0).getTerm());
			assertEquals("\"readTagTest\"", tags.get(0).getLabel());
			assertEquals("\"http://hl7.org/fhir/tag\"", tags.get(0).getScheme());
		}catch(Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void testParse3() {
		try {
			List<AtomCategory> tags = new TagParser().parse(CATEGORY3);
			assertTrue(tags.size() > 0);
			assertEquals(1, tags.size());
			assertEquals("dog", tags.get(0).getTerm());
			assertEquals("\"Canine\"", tags.get(0).getLabel());
			assertEquals("\"http://purl.org/net/animals\"", tags.get(0).getScheme());
		}catch(Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void testParse4() {
		try {
			List<AtomCategory> tags = new TagParser().parse(CATEGORY4);
			assertTrue(tags.size() > 0);
			assertEquals(2, tags.size());
			assertEquals("dog", tags.get(0).getTerm());
			assertEquals("\"Canine\"", tags.get(0).getLabel());
			assertEquals("\"http://purl.org/net/animals\"", tags.get(0).getScheme());
			assertEquals("lowchen", tags.get(1).getTerm());
			assertEquals("UTF-8'de'L%c3%b6wchen\"", tags.get(1).getLabel());
			assertEquals("\"http://purl.org/net/animals/dogs\"", tags.get(1).getScheme());
		}catch(Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void testDateTime() {
		try {
		DateAndTime date = new DateAndTime("2013-01-01T10:30:00+00:00");
		date = new DateAndTime(new java.util.Date(System.currentTimeMillis()));
		} catch(Exception e) {
			e.printStackTrace();
			fail();
		}
	}

}
