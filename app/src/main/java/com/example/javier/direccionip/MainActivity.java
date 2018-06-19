package com.example.javier.direccionip;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    /*Declarando valores iniciales de EditText y TextView*/
    private EditText IP = null;
    private EditText mascara = null;
    private TextView netID = null;
    private TextView broadcast = null;
    private TextView hostpart = null;
    private TextView hosts = null;
    private TextView mask2 = null;
    private TextView red = null;
    /*Crear metodo para calcular*/
    private ObtenerIP calcular = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.IP = (EditText) findViewById(R.id.direccionip);
        this.mascara = (EditText) findViewById(R.id.mascara1);
        this.netID = (TextView) findViewById(R.id.netid1);
        this.broadcast = (TextView) findViewById(R.id.broad1);
        this.hostpart = (TextView) findViewById(R.id.host2);
        this.hosts = (TextView) findViewById(R.id.host1);
        this.mask2 = (TextView) findViewById(R.id.masc2);
        this.red = (TextView) findViewById(R.id.red1);
    }

    public void calcular (View view) {
        this.calcular = new ObtenerIP(this.IP.getText().toString(), Integer.parseInt(this.mascara.getText().toString()));

        String info[] = this.calcular.geInfo();

        this.mask2.setText("Netmask: " + info[0]);
        this.hosts.setText("Wildcard: " + info[1]);
        this.netID.setText("Network: " + info[2]);
        this.broadcast.setText("Broadcast: " + info[3]);
        this.hostpart.setText("Hosts: " + info[4]);
        this.red.setText("Nets: " + info[5]);
    }
}



