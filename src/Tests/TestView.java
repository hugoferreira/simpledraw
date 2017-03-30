package Tests;

import static org.junit.Assert.fail;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Assert;
import org.junit.Test;

import main.CreateCircle;
import main.CreateRectangle;
import main.Document;
import main.View;

public class TestView {

	final String findCoordinatesRegex = "(?<=: )\\d+(?=[,|)])";
	final Pattern grabCoordinates = Pattern.compile(findCoordinatesRegex);
	final int X = 0;
	final int Y = 1;

	@Test
	public void testCreateView() {
		Document d1 = new Document();
		View view1 = new View(d1);
	}

	@Test
	public void testViewTranslation() {
		Document d1 = new Document();
		View view1 = new View(d1);
		View view2 = new View(d1, 10, 20);

		d1.execute(new CreateCircle(d1, 100, 100));

		int[] v1_pos = getFirstObjectPositions(view1);
		int[] v2_pos = getFirstObjectPositions(view2);

		Assert.assertEquals(v1_pos[X], 100);
		Assert.assertEquals(v2_pos[X], 90);
		Assert.assertEquals(v1_pos[Y], 100);
		Assert.assertEquals(v2_pos[Y], 80);
	}

	public int[] getFirstObjectPositions(View v) {
		int[] positions = new int[2];
		Matcher m = grabCoordinates.matcher(v.toString());

		if (m.find()) {
			positions[X] = Integer.parseInt(m.group(0));
		} else
			fail("Position X output not found on toString");

		if (m.find()) {
			positions[Y] = Integer.parseInt(m.group(0));
		} else
			fail("Position Y output not found on toString");

		return positions;
	}

}
