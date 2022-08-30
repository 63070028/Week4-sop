package com.example.week4;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.web.reactive.function.client.WebClient;

@Route(value = "index1")
public class MathView extends VerticalLayout {
    private TextField tf1, tf2, ans;
    private Button bt_plus;
    private Button bt_minus;
    private Button bt_multi;
    private Button bt_divide;
    private Button bt_mod;
    private Button bt_max;

    public MathView(){
        tf1 = new TextField("Number1");
        tf2 = new TextField("Number2");
        tf1.setWidthFull();
        tf2.setWidthFull();

        bt_plus = new Button("+");
        bt_minus = new Button("-");
        bt_multi = new Button("x");
        bt_divide = new Button("/");
        bt_mod = new Button("Mod");
        bt_max = new Button("Max");
        HorizontalLayout hl_button = new HorizontalLayout();
        Text t = new Text("Operator");
        hl_button.add(bt_plus, bt_minus, bt_multi, bt_divide, bt_mod, bt_max);
        hl_button.setWidthFull();
        ans = new TextField("Answer");
        ans.setWidthFull();
        add(tf1, tf2, t, hl_button, ans);

        bt_plus.addClickListener(e->{
            double num1 = Double.parseDouble(tf1.getValue());
            double num2 = Double.parseDouble(tf2.getValue());
            double out = WebClient.create().get().uri("http://localhost:8080/plus/"+num1+"/"+num2).retrieve().bodyToMono(double.class).block();
            ans.setValue(String.valueOf(out));
        });

        bt_minus.addClickListener(e->{
            double num1 = Double.parseDouble(tf1.getValue());
            double num2 = Double.parseDouble(tf2.getValue());
            double out = WebClient.create().get().uri("http://localhost:8080/minus/"+num1+"/"+num2).retrieve().bodyToMono(double.class).block();
            ans.setValue(String.valueOf(out));
        });

        bt_multi.addClickListener(e->{
            double num1 = Double.parseDouble(tf1.getValue());
            double num2 = Double.parseDouble(tf2.getValue());
            double out = WebClient.create().get().uri("http://localhost:8080/multi/"+num1+"/"+num2).retrieve().bodyToMono(double.class).block();
            ans.setValue(String.valueOf(out));
        });

        bt_divide.addClickListener(e->{
            double num1 = Double.parseDouble(tf1.getValue());
            double num2 = Double.parseDouble(tf2.getValue());
            double out = WebClient.create().get().uri("http://localhost:8080/divide/"+num1+"/"+num2).retrieve().bodyToMono(double.class).block();
            ans.setValue(String.valueOf(out));
        });

        bt_mod.addClickListener(e->{
            double num1 = Double.parseDouble(tf1.getValue());
            double num2 = Double.parseDouble(tf2.getValue());
            double out = WebClient.create().get().uri("http://localhost:8080/mod/"+num1+"/"+num2).retrieve().bodyToMono(double.class).block();
            ans.setValue(String.valueOf(out));
        });

        bt_max.addClickListener(e->{
            double num1 = Double.parseDouble(tf1.getValue());
            double num2 = Double.parseDouble(tf2.getValue());
            double out = WebClient.create().post().uri("http://localhost:8080/max?n1="+num1+"&"+"n2="+num2).retrieve().bodyToMono(double.class).block();
            ans.setValue(String.valueOf(out));
        });


    }



}
