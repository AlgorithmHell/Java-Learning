public class Toy {

    private String name;

    private int price;

    private int leftEdge;

    private int rightEdge;

    private static final int MAX_LEFT_RANGE = 1;

    private static final int MAX_RIGHT_RANGE = 18;

    public Toy(String name, int price, int leftEdge, int rightEdge) throws IllegalParameterException {

        this.name = name;

        if(leftEdge < MAX_LEFT_RANGE || rightEdge > MAX_RIGHT_RANGE || price < 0)
            throw new IllegalParameterException("Edge : "+leftEdge+" is illegal");
        else {
            this.price = price;
            this.leftEdge = leftEdge;
            this.rightEdge = rightEdge;
        }

    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getLeftEdge() {
        return leftEdge;
    }

    public int getRightEdge() {
        return rightEdge;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Toy toy = (Toy) o;

        if (price != toy.price) return false;
        if (leftEdge != toy.leftEdge) return false;
        if (rightEdge != toy.rightEdge) return false;
        return name.equals(toy.name);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + price;
        result = 31 * result + leftEdge;
        result = 31 * result + rightEdge;
        return result;
    }

    @Override
    public String toString() {
        return "' "+name+" ' " +" price : "
                + Integer.toString(price)+
                " age : [ "+leftEdge+" , "+rightEdge+" ]"+"\n";
    }

    public String toXMLString() {
        return "\t<toy>\n\t\t<name name =  \" "+name+" \" />\n\t\t" +
                "<price name = \""+price+"\" />\n\t\t" +
                "<leftEdge name = \"" + leftEdge + "\" />\n\t\t" +
                "<rightEdge name = \"" + rightEdge + "\" />\n" +
                "\t</toy>";
    }
}