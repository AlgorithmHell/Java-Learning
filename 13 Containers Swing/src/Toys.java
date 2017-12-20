
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.swing.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

/**
 * Created by Helga on 12/17/2017.
 */
public class Toys  {

    private  Set<Toy> toys;

    public Toys() {
        toys = new HashSet<>();
    }

    private Toys(Set<Toy> toys) {
        this.toys = toys;
    }

    private Comparator<Toy> comparator = new Comparator<Toy>() {
        @Override
        public int compare(Toy o1, Toy o2) {
            return o1.getPrice() - o2.getPrice();
        }
    };

    public boolean add(Toy e) {
        return  toys.add(e);
    }

    public Toys getEligibleToys(int leftEdge, int rightEdge) {

        Toys eligibleToys = new Toys(new TreeSet<>(comparator));

        Iterator<Toy> iterator = toys.iterator();

        while(iterator.hasNext()) {
            Toy toy = iterator.next();
            if(toy.getLeftEdge() <= leftEdge && toy.getRightEdge() >= rightEdge) {
                eligibleToys.add(toy);
            }
        }

        return eligibleToys;
    }

    public Toys(File file) throws InvalidFileInfoException, NumberFormatException,
            InputMismatchException, IllegalParameterException ,  ParserConfigurationException, SAXException , IOException {
         toys = new HashSet<>();

        String fileName = file.getPath();
        String extension = fileName.substring(fileName.lastIndexOf(".") + 1);
        if(extension.equals("txt"))
        readFromTxt(file);
        if(extension.equals("xml"))
            readFromXML(file);

    }

    private void readFromTxt(File file) throws FileNotFoundException, InvalidFileInfoException, NumberFormatException, InputMismatchException, IllegalParameterException {
        Scanner in = new Scanner(file);
        while (in.hasNextLine()) {
            StringTokenizer stringTokenizer = new StringTokenizer(in.nextLine());
            if(stringTokenizer.countTokens() != 4) {
                throw new InvalidFileInfoException("Invalid Input Data");
            }

            this.add(new Toy(stringTokenizer.nextToken(),Integer.parseInt(stringTokenizer.nextToken()),
                    Integer.parseInt(stringTokenizer.nextToken()),Integer.parseInt(stringTokenizer.nextToken())));
        }
    }

    private void readFromXML(File file) throws ParserConfigurationException, SAXException , IOException, IllegalParameterException {
         readDocument(getDocument(file));
    }

    private  Document getDocument(File file)  throws ParserConfigurationException, SAXException , IOException{

            DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
            f.setValidating(false);
            DocumentBuilder builder = f.newDocumentBuilder();
            return builder.parse(file);
    }

    private  void readDocument(Document document) throws  IllegalParameterException {
        StringBuffer content = new StringBuffer();
        Node node = document.getChildNodes().item(0);
        ToysNode toysNode = new ToysNode(node);

        content.append("Application \n");

        List<ToyNode> toysNodes = toysNode.getToys();

        for (int i = 0; i < toysNodes.size(); i++) {

            List<ParamNode> params = toysNodes.get(i).getParams();
            List<String> toyAtributes = new ArrayList<>();
            for (int j = 0; j < params.size(); j++) {
                ParamNode paramNode = params.get(j);
                toyAtributes.add(paramNode.getName());
            }
            Iterator iterator = toyAtributes.iterator();
            if(iterator.hasNext()) {
                toys.add(new Toy(iterator.next().toString(),
                        Integer.parseInt(iterator.next().toString()),
                        Integer.parseInt(iterator.next().toString()),
                        Integer.parseInt(iterator.next().toString())
                ));
            }

        }
    }


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Iterator<Toy> iterator = toys.iterator();
        while(iterator.hasNext()) {
            stringBuilder.append(iterator.next().toString());
        }

        return stringBuilder.toString();
    }

    public String toXMLString() {
        StringBuilder stringBuilder = new StringBuilder("<toys>\n");

        Iterator iterator = toys.iterator();
        while(iterator.hasNext()) {
            Toy toy = (Toy)iterator.next();
            stringBuilder.append(toy.toXMLString());
        }
        stringBuilder.append("</toys>");
        return stringBuilder.toString();
    }
}
