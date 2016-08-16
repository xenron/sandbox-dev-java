package SVG;

import java.util.Random; 

public class SVGGenerator {
 
	private static String circleStr ="<circle   cx='%d' cy='%d' r='%d'  fill='%s' />";
	private static String rectStr ="<rect x='%d' y='%d' height='%d' width='%d' fill='%s'/>";
	private static String ellipseStr ="<ellipse   cx='100' cy='100' rx='7'  ry='140' fill='%s' />";
	private static String rect2str ="<rect x='%d' y='%d' height='%d' width='%d' fill='%s'/>"; 
	private static String[] colors = new String[]{"red","yellow","black","green","orange","blue","purple","pink"};
	
	public static void main(String[] args) { 
		Random rand = new Random(1000); 
		StringBuilder sb = new StringBuilder("<svg  width='500' height='500'>");
		int i=0;
		while(i<10)
		{
			int type = rand.nextInt(4);
			switch (type) {
			case 0:
				sb.append(String.format(circleStr, rand.nextInt(400),
						rand.nextInt(400), rand.nextInt(100),
						colors[rand.nextInt(7)]));
				sb.append("\n");
				break;
			case 1:
				int width = rand.nextInt(200);
				sb.append(String.format(rectStr, rand.nextInt(400),
						rand.nextInt(400),width,width,
						colors[rand.nextInt(7)]));
				sb.append("\n");
				break;

			case 2:
				sb.append(String.format(ellipseStr, rand.nextInt(400),
						rand.nextInt(400), rand.nextInt(100),rand.nextInt(200),
						colors[rand.nextInt(7)]));
				sb.append("\n");
				break;
			case 3:
				sb.append(String.format(rect2str, rand.nextInt(400),
						rand.nextInt(400), rand.nextInt(100),rand.nextInt(200),
						colors[rand.nextInt(7)]));
				sb.append("\n");
				break;

			}
			i++;
		}
		sb.append("</svg>");
		System.out.println(sb.toString());
	}

}
