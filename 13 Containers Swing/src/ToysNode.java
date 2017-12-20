
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Helga on 12/20/2017.
 */
public class ToysNode {
    Node node;

    public ToysNode(Node node) {
        this.node = node;
    }

    public List<ToyNode> getToys() {
        ArrayList<ToyNode> toyNodes = new ArrayList<ToyNode>();

        NodeList nodeList = node.getChildNodes();

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);

            if (node.getNodeType() == Node.ELEMENT_NODE) {
                ToyNode toyNode = new ToyNode(node);
                toyNodes.add(toyNode);
            }
        }

        return toyNodes;
    }

}
