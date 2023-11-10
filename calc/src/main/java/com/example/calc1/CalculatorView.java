package com.example.calc1;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route("")
public class CalculatorView extends VerticalLayout {

    private TextField inputLabel;
    private TextField inputAsInches;
    private TextField display2;

    public CalculatorView() {


        inputLabel = new TextField();
        inputLabel.setReadOnly(true);
        inputLabel.setValue("Cale");

        inputAsInches = new TextField();
        // display1.setReadOnly(true);
        inputAsInches.setWidth("200px");
        inputAsInches.addValueChangeListener(it -> {

            try {
                var valueAsInches = it.getValue();
                var valueAsInchesAsInt = Double.parseDouble(valueAsInches);
                var valueAsMm = valueAsInchesAsInt * 25.4;
                display2.setValue(Double.toString(valueAsMm));
            } catch (Exception ex) {
                display2.setValue(ex.getMessage());
            }

        });

        display2 = new TextField();
        display2.setReadOnly(true);
        display2.setValue("0");
        display2.setWidth("200px");

        var layout1 = new HorizontalLayout();
        layout1.setPadding(true);
        layout1.setWidth("auto");
        layout1.setMargin(true);
        layout1.setAlignItems(FlexComponent.Alignment.STRETCH);
        layout1.add(inputLabel);
        layout1.add(inputAsInches);

        var layout2 = new HorizontalLayout();
        layout2.setPadding(true);
        layout2.setWidth("auto");
        layout2.setMargin(true);
        layout2.setAlignItems(FlexComponent.Alignment.STRETCH);
        layout2.add(display2);

        add(layout1, layout2);

        setSpacing(true);
    }
}