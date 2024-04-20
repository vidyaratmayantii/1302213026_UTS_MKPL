package lib;

public class Depent{
    private String childNames;
	private String childIdNumbers;

    public void addChild(String childName, String childIdNumber) {
		childNames.add(childName);
		childIdNumbers.add(childIdNumber);
	}
}