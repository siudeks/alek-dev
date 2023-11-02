package com.example.calc1;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route("")
public class CalculatorView extends VerticalLayout {

    private TextField input;
    private TextField display2;

    public CalculatorView() {
        input = new TextField();
        // display1.setReadOnly(true);
        input.setWidth("200px");
        input.addValueChangeListener(it -> {
            display2.setValue(it.getValue());
        });

        display2 = new TextField();
        display2.setReadOnly(true);
        display2.setValue("0");
        display2.setWidth("200px");

        add(input, display2);

        setSpacing(true);
    }
}