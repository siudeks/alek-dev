package com.example.calc1;

import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route("")
public class CalculatorView extends VerticalLayout {

    public CalculatorView() {

        var result = new TextField();
        result.setReadOnly(true);
        result.setValue("0");
        result.setWidth("200px");

        var inputAsInches = new TextField();
        inputAsInches.setWidth("200px");
        inputAsInches.addValueChangeListener(it -> {

            try {
                var valueAsInches = it.getValue();
                var valueAsInchesAsInt = Double.parseDouble(valueAsInches);
                var valueAsMm = valueAsInchesAsInt * 25.4;
                result.setValue(Double.toString(valueAsMm));
            } catch (Exception ex) {
                result.setValue(ex.getMessage());
            }

        });


        var inputLabelInches = newLabel("Cale");
        var layout1 = newLayout();
        layout1.add(inputLabelInches);
        layout1.add(inputAsInches);


        var inputLabelMilis = newLabel("Milimetry");
        var inputAsMilis = newInput();
        inputAsMilis.addValueChangeListener(it -> {
            try {
                var valueAsMilis = it.getValue();
                var valueAsMilisAsInt = Double.parseDouble(valueAsMilis);
                var valueAsMm = valueAsMilisAsInt / 25.4;
                result.setValue(Double.toString(valueAsMm));
            } catch (Exception ex) {
                result.setValue(ex.getMessage());
            }

        });
        var layout2 = newLayout();
        layout2.add(inputLabelMilis, inputAsMilis);

        var layout3 = newLayout();
        layout3.add(result);

        add(layout1, layout2, layout3);

        setSpacing(true);
    }

    private static HorizontalLayout newLayout() {
        var result = new HorizontalLayout();
        result.setPadding(true);
        result.setWidth("auto");
        result.setMargin(true);
        result.setAlignItems(FlexComponent.Alignment.STRETCH);
        return result;
    }

    private static TextField newLabel(String text) {
        var result = new TextField();
        result.setReadOnly(true);
        result.setValue(text);
        return result;
    }

    private static TextField newInput() {
        var result = new TextField();
        result.setWidth("200px");
        return result;
    }
}