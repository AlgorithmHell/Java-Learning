import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

/**
 * Created by Helga on 12/20/2017.
 */
public  class ParamNode {

    Node node;

    public ParamNode(Node node) {
        this.node = node;
    }

    public String getName() {
        NamedNodeMap attributes = node.getAttributes();

        Node nameAttribute = attributes.getNamedItem("name");

        return nameAttribute.getNodeValue();
    }

}

