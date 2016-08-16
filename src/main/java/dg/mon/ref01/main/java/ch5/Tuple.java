package ch5;

public class Tuple {
	private String left;
	private String right;
	public Tuple(String left,String right)
	{
		this.setLeft(left);
		this.setRight(right);
	}
	public String getLeft() {
		return left;
	}
	public void setLeft(String left) {
		this.left = left;
	}
	public String getRight() {
		return right;
	}
	public void setRight(String right) {
		this.right = right;
	}
	
}
