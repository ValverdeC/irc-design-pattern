import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class EnabledDecorator extends Decorator {
    public static List<JComponent> componentList = new ArrayList<JComponent>() {
    };

    public EnabledDecorator(JComponent c) {
        super(c);
        JComponent swingComponent = getSwingComponent(c);
        componentList.add(swingComponent);

        ((JButton) swingComponent)
                .addActionListener(e -> componentList
                        .forEach(f -> f.setBackground(f.equals(swingComponent)?Color.BLACK:Color.WHITE))
                );
    }


}
